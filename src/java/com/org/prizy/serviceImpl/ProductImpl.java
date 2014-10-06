/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.prizy.serviceImpl;

import com.org.prizy.master.ProductDetail;
import com.org.prizy.master.ProductList;
import com.org.prizy.master.Product;
import com.org.prizy.service.ProductService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

/**
 *
 * @author PREM BABOO
 */
@Service
public class ProductImpl  implements ProductService {
    //Get the values from the properties file
    @Value("${barcode_read_url}")
    private String barcodeReadUrl;
    
    @Value("${how_much_remove_lowest}")
    private String removeLowest;
    
    @Value("${how_much_remove_highest}")
    private String removeHighest;
    
    @Value("${adding_percentage}")
    private String addPercentage;
    
    
    protected static final Logger logger = Logger.getLogger("ProductImpl");
    
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Set the jdbcTemplate instance getting from the XML file
     * @param jdbcTemplate 
     */
    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * To create the new product in the store
     * @param map
     */
    @Override
    public void createProduct(Map<String,Object> map) {
        String query = "INSERT INTO products (name,barcode,description) values (?,?,?)";
        Object name = map.get("name");
        Object barcode = map.get("barcode");
        Object description = map.get("description");
        jdbcTemplate.update(query, new Object[]{name, barcode,  description});
        
    }
    
    /**
     * To add the price corresponding to the product entered by user who takes the survey
     * @param map 
     */
    @Override
    public void addPrice(Map<String, Object> map) {
        String query = "INSERT INTO prices (product_id,entered_price,notes) values (?,?,?)";
        Object product_id = map.get("product_id");
        Object entered_price = map.get("entered_price");
        Object notes = map.get("notes");     
        jdbcTemplate.update(query, new Object[]{product_id, entered_price, notes});
        
    }

    /**
     * To grab all the product for the drop-down list
     * @return 
     */
    @Override
    public List<Product> findAllProducts() {
        return jdbcTemplate.query("SELECT id, name FROM products WHERE 1", new ResultSetExtractor<List<Product>>(){  
            @Override  
             public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {  
                List<Product> list=new ArrayList<Product>();  
                while(rs.next()){  
                    Product e = new Product();  
                    e.setProductId(rs.getInt(1));  
                    e.setName(rs.getString(2));  
                    list.add(e);  
                }  
                return list;  
                }  
        }); 
    }

    /**
     * To grab the product detail for view the product 
     * @param id
     * @return 
     */
    @Override
    public List<ProductDetail> getProductDetail(int id) {
        return jdbcTemplate.query("SELECT * FROM products WHERE id="+id, new ResultSetExtractor<List<ProductDetail>>(){  
            @Override  
             public List<ProductDetail> extractData(ResultSet rs) throws SQLException, DataAccessException {  
                List<ProductDetail> list=new ArrayList<ProductDetail>();  
                while(rs.next()){  
                    ProductDetail e = new ProductDetail();  
                    List<Integer> l = getPriceList(rs.getInt(1));
                    e.setId(rs.getInt(1)); 
                    e.setBarcode(barcodeReadUrl+rs.getString(2));
                    e.setName(rs.getString(3));  
                    e.setDescription(rs.getString(3));
                    e.setPrice(getAveragePrice(l));
                    e.setLowestprice(getLowestPrice(l));
                    e.setHighestprice(getHighestPrice(l));
                    e.setIdelprice(getIdealPrice(l));
                    list.add(e);  
                }  
                return list;  
                }  
        }); 
        
    }

    /**
     * To find the all products for showing the list
     * @return 
     */
    @Override
    public List<ProductList> findProductList() {
        return jdbcTemplate.query("SELECT * FROM products WHERE 1", new ResultSetExtractor<List<ProductList>>(){  
            @Override  
             public List<ProductList> extractData(ResultSet rs) throws SQLException, DataAccessException {  
                List<ProductList> list=new ArrayList<ProductList>();  
                while(rs.next()){  
                    ProductList e = new ProductList(); 
                    e.setId(rs.getInt(1));  
                    e.setBarcode(barcodeReadUrl+rs.getString(2));
                    e.setName(rs.getString(3));
                    e.setDescription(rs.getString(4));
                    list.add(e);  
                }  
                return list;  
                }  
        });
    }
    
    /**
     * To get lowest price entered to the product in the survey taken 
     * @param arr
     * @return 
     */
    private int getLowestPrice(List<Integer> arr) {
        int len = arr.size();
        if(len==0)
            return 0;
        return arr.get(0);
    }
    
    /**
     * To get the highest price to the product achieved in the survey taken 
     * @param arr
     * @return 
     */
    private int getHighestPrice(List<Integer> arr) {
        int len = arr.size();
        if(len==0)
            return 0;
        return arr.get(len-1);
    }
    
    /**
     * To get the average price to the product
     * @param arr
     * @return 
     */
    private int getAveragePrice(List<Integer> arr) {
        int sum = 0, len = arr.size();
        
        //return o if no price entered to the survey
        if(len==0)
            return 0;
        
        //calculate the sum of the price entered to the product in survey by users
        for(int i = 0; i < len ; i++) 
            sum += arr.get(i);    
        return sum/len;
    }
    
    /**
     * To calculate the ideal price based on the formulae based on the configuration file values 
     * @param arr
     * @return 
     */
    private int getIdealPrice(List<Integer> arr) {
        int lowest = Integer.parseInt(removeLowest), highest = Integer.parseInt(removeHighest);
        int sum=0, len = arr.size(), all = lowest+highest, average = 0, value = 0;
        if(len==0)
            return 0;
        // check if the remove lowest and highest achieved in the survey to remove
        if(len <= all) {
            for(int i = 0; i < len ; i++) 
            sum += arr.get(i);    
            return (sum/len);
        }
        else {
            len = len - 4;
            for(int i = lowest; i < len-highest; i++)
                sum += arr.get(i);   
                average = sum/len;
                value = Integer.parseInt(addPercentage)*average/100;
                return (average + value);
        }
    }
    
    /**
     * To get all price entered by user to a product
     * @param id
     * @return 
     */
    private List<Integer> getPriceList(int id) {
        return jdbcTemplate.query("SELECT entered_price FROM prices WHERE product_id="+id, new ResultSetExtractor<List<Integer>>(){  
            @Override
            public List<Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Integer> list=new ArrayList<Integer>();
                while(rs.next()) {
                    list.add(rs.getInt(1));
                }
                Collections.sort(list);
                return list;
            }  
        });
    }
    
}
