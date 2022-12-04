package com.nhom6.davidsonfurniture.Models;

public class Product {

    public Product(int productThumb, String productName, String productCategory, String productRate, int productPrice) {
        this.productThumb = productThumb;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productRate = productRate;
        this.productPrice = productPrice;
    }

    int productThumb;
    String productName, productCategory, productRate;
    int productPrice;

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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}
