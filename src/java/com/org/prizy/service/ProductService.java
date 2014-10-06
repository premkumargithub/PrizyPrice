/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.prizy.service;

import com.org.prizy.master.Product;
import com.org.prizy.master.ProductDetail;
import com.org.prizy.master.ProductList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PREM BABOO
 */
public interface ProductService {

    public void createProduct(Map<String,Object> map);
    
    public void addPrice(Map<String, Object> map);
    
    public List<Product> findAllProducts();
    
    public List<ProductList> findProductList();
    
    public List<ProductDetail> getProductDetail(int id);
    
}
