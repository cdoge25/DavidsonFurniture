package com.nhom6.davidsonfurniture.Models;

import java.io.Serializable;

public class DeliveredOrder implements Serializable {
    int deliveredID;
    int deliveredThumb; //hình ảnh
    String deliveredName;
    String deliveredType;
    String deliveredColor;
    double deliveredPrice;
    int deliveredQuantity;
    String deliveredCode;

    public int getDeliveredID() {
        return deliveredID;
    }

    public DeliveredOrder(int deliveredThumb, String deliveredName, String deliveredType, String deliveredColor, double deliveredPrice, int deliveredQuantity, String deliveredCode) {
        this.deliveredThumb = deliveredThumb;
        this.deliveredName = deliveredName;
        this.deliveredType = deliveredType;
        this.deliveredColor = deliveredColor;
        this.deliveredPrice = deliveredPrice;
        this.deliveredQuantity = deliveredQuantity;
        this.deliveredCode = deliveredCode;
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

    public double getDeliveredPrice() {
        return deliveredPrice;
    }

    public void setDeliveredPrice(double deliveredPrice) {
        this.deliveredPrice = deliveredPrice;
    }

    public int getDeliveredQuantity() {
        return deliveredQuantity;
    }

    public void setDeliveredQuantity(int deliveredQuantity) {
        this.deliveredQuantity = deliveredQuantity;
    }

    public String getDeliveredCode() {
        return deliveredCode;
    }

    public void setDeliveredCode(String deliveredCode) {
        this.deliveredCode = deliveredCode;
    }
}
