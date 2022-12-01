package com.nhom6.davidsonfurniture.Models;

public class DeliveredOrder {
    int deliveredThumb; //hình ảnh
    String deliveredName;
    String deliveredType;
    String deliveredColor;
    String deliveredPrice;
    String deliveredQuantity;

    public DeliveredOrder(int deliveredThumb, String deliveredName, String deliveredType, String deliveredColor, String deliveredPrice, String deliveredQuantity) {
        this.deliveredThumb = deliveredThumb;
        this.deliveredName = deliveredName;
        this.deliveredType = deliveredType;
        this.deliveredColor = deliveredColor;
        this.deliveredPrice = deliveredPrice;
        this.deliveredQuantity = deliveredQuantity;
    }

    public int getDeliveredThumb() {
        return deliveredThumb;
    }

    public void setDeliveredThumb(int deliveredThumb) {
        this.deliveredThumb = deliveredThumb;
    }

    public String getDeliveredName() {
        return deliveredName;
    }

    public void setDeliveredName(String deliveredName) {
        this.deliveredName = deliveredName;
    }

    public String getDeliveredType() {
        return deliveredType;
    }

    public void setDeliveredType(String deliveredType) {
        this.deliveredType = deliveredType;
    }

    public String getDeliveredColor() {
        return deliveredColor;
    }

    public void setDeliveredColor(String deliveredColor) {
        this.deliveredColor = deliveredColor;
    }

    public String getDeliveredPrice() {
        return deliveredPrice;
    }

    public void setDeliveredPrice(String deliveredPrice) {
        this.deliveredPrice = deliveredPrice;
    }

    public String getDeliveredQuantity() {
        return deliveredQuantity;
    }

    public void setDeliveredQuantity(String deliveredQuantity) {
        this.deliveredQuantity = deliveredQuantity;
    }
}
