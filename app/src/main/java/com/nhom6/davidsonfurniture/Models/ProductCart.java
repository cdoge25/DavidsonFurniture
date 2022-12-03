package com.nhom6.davidsonfurniture.Models;

public class ProductCart {
    int productImage;
    String productName;
    String productType;
    String productPrice;
    String productColor;
    String productQuantity;

    //Constructor

    public ProductCart(int productImage, String productName, String productType, String productPrice, String productColor, String productQuantity) {
        this.productImage = productImage;
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productColor = productColor;
        this.productQuantity = productQuantity;
    }

    //Getter and setter
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

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }
}
