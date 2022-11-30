package com.nhom6.davidsonfurniture.Models;

public class PlacedOrder {
    int orderThumb;
    String orderName;
    String orderType;
    String orderColor;
    String orderPrice;
    String orderQuantity;

    public PlacedOrder(int orderThumb, String orderName, String orderType, String orderColor, String orderPrice, String orderQuantity) {
        this.orderThumb = orderThumb;
        this.orderName = orderName;
        this.orderType = orderType;
        this.orderColor = orderColor;
        this.orderPrice = orderPrice;
        this.orderQuantity = orderQuantity;
    }

    public int getOrderThumb() {
        return orderThumb;
    }

    public void setOrderThumb(int orderThumb) {
        this.orderThumb = orderThumb;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderColor() {
        return orderColor;
    }

    public void setOrderColor(String orderColor) {
        this.orderColor = orderColor;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }


}
