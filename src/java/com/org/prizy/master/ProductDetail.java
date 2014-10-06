/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.prizy.master;

/**
 *
 * @author Prem Baboo
 */
public class ProductDetail {
    private int id;
    private String name;
    private String barcode;
    private String description;
    private int price;
    private int lowestprice;
    private int highestprice;
    private int idelprice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLowestprice() {
        return lowestprice;
    }

    public void setLowestprice(int lowestprice) {
        this.lowestprice = lowestprice;
    }

    public int getHighestprice() {
        return highestprice;
    }

    public void setHighestprice(int highestprice) {
        this.highestprice = highestprice;
    }

    public int getIdelprice() {
        return idelprice;
    }

    public void setIdelprice(int idelprice) {
        this.idelprice = idelprice;
    }
     
}
