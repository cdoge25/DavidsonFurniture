package com.nhom6.davidsonfurniture.Models;

public class Product {

    int productThumb;
    String productName, productCategory, productRate;
    double productPrice;


    public Product(int productThumb, String productName, String productCategory, String productRate, double productPrice) {
        this.productThumb = productThumb;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productRate = productRate;
        this.productPrice = productPrice;
    }

    public int getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(int productThumb) {
        this.productThumb = productThumb;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductRate() {
        return productRate;
    }

    public void setProductRate(String productRate) {
        this.productRate = productRate;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }



}
