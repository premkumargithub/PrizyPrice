/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.prizy.testing;

import com.org.prizy.master.Product;
import com.org.prizy.master.ProductDetail;
import com.org.prizy.master.ProductList;
import java.util.List;

/**
 *
 * @author Prem Baboo
 */
public class ProductTest {
    
    public static boolean testProduct(List<Product> product) {
        int s = product.size();
        return s > 0;
    }
    
    public static boolean testProductList(List<ProductList> product) {
        int s = product.size();
        return s > 0;
    }

    public static Object testProductDetail(List<ProductDetail> list) {
        int s = list.size();
        return s > 0;
    }
    
}
