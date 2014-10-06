/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.prizy.master;

/**
 *
 * @author PREM BABOO
 */
public class ProductMaster 
{

    private Integer productId;
    private String productName;
    private String barcode;
    private String description;
    
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
  
}
