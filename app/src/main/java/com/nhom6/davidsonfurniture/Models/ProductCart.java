package com.nhom6.davidsonfurniture.Models;

public class ProductCart {
    int productId, productThumb;
    String productName;
    String productType;
    String productColor;
    int productPrice, productQuantity;

    //Constructor

    public ProductCart(int productId, int productThumb, String productName, String productType, String productColor, int productPrice, int productQuantity) {
        this.productId = productId;
        this.productThumb = productThumb;
        this.productName = productName;
        this.productType = productType;
        this.productColor = productColor;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    //Getter and Setter

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
