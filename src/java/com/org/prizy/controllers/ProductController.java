/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.prizy.controllers;

import com.org.barcode.Barcode;
import com.org.prizy.master.Product;
import com.org.prizy.master.ProductDetail;
import com.org.prizy.master.ProductList;
import com.org.prizy.service.ProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author PREM BABOO
 */
@Controller
public class ProductController 
{
    @Value("${barcode_write_url}")
    private String barcodeUrl;
        
    @Autowired
    ProductService productService;
    
    /**
     * To show all products to show take survey by user
     * @param model
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping("/index")
    public String takeSurvey(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        List<Product> product = productService.findAllProducts();
        model.addAttribute("items", product);
        return "home";
    }
     
    /**
     * To save price to product, survey attended by user
     * @param model
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value="submitSurvey", method = RequestMethod.POST)
    public String savePrice(Model model, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map;
        map = new HashMap<>();
        map.put("product_id", request.getParameter("productid"));
        map.put("entered_price", request.getParameter("price"));
        map.put("notes", request.getParameter("notes"));
        productService.addPrice(map);
        return "redirect:index";
    }
    
    /**
     * Render add product form 
     * @param model
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping("/add")
    public String addProduct(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "add";
    }
    
    /**
     * To add product and create bar code for the same
     * @param model
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping(value="saveProduct", method = RequestMethod.POST)
    public String save(Model model, HttpServletRequest request, HttpServletResponse response) {
        Barcode bar = new Barcode();
        String name = request.getParameter("name");
        String barcode = bar.getBarcode(barcodeUrl); //to get the barcode
        System.out.println("here barcode = "+barcode);
        String description = request.getParameter("description");
        Map<String,Object> map;
        map = new HashMap<>();
        map.put("barcode", barcode);
        map.put("name", name);
        map.put("description", description); 
        productService.createProduct(map);
        return "redirect:admin";
    }
   
    /**
     * List all the product in the administrator section
     * @param map
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping("/admin")
    public String listProduct(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        List<ProductList> product = productService.findProductList();
        map.addAttribute("items", product);
        return "list";
    }
    
    /**
     * get all the product to show to select from drop-down list
     * @param model
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping("select")
    public String selectProduct(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        List<Product> product = productService.findAllProducts();
        model.addAttribute("items", product);
        return "select";
    }
    
    /**
     * Get the product detail for the product
     * @param map
     * @param request
     * @param response
     * @return 
     */
    @RequestMapping("/view")
    public String view(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("productid"));
        System.out.println("id= "+id);
        List<ProductDetail> list = productService.getProductDetail(id);
        map.addAttribute("data", list);
        return "view";
    }
    
}
