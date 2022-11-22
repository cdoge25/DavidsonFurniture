package com.nhom6.davidsonfurniture.Models;

public class ProductInfor {
    int productImage;
    String productName;
    String productType;
    double productPrice;

    //Constructor

    public ProductInfor(int productImage, String productName, String productType, double productPrice) {
        this.productImage = productImage;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
    }

    //Getter and Setter

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
