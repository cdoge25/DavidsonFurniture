package com.nhom6.davidsonfurniture.Models;

import java.io.Serializable;

public class DeliveringOrder implements Serializable {
    int deliveringID;
    int deliveringThumb; //hình ảnh
    String deliveringName;
    String deliveringType;
    String deliveringColor;
    double deliveringPrice;
    int deliveringQuantity;
    String deliveringCode;

    public int getPreparingID() {
        return deliveringID;
    }

    public DeliveringOrder(int deliveringThumb, String deliveringName, String deliveringType, String deliveringColor, double deliveringPrice, int deliveringQuantity, String deliveringCode) {
        this.deliveringThumb = deliveringThumb;
        this.deliveringName = deliveringName;
        this.deliveringType = deliveringType;
        this.deliveringColor = deliveringColor;
        this.deliveringPrice = deliveringPrice;
        this.deliveringQuantity = deliveringQuantity;
        this.deliveringCode = deliveringCode;
    }

    public int getDeliveringThumb() {
        return deliveringThumb;
    }

    public void setDeliveringThumb(int deliveringThumb) {
        this.deliveringThumb = deliveringThumb;
    }

    public String getDeliveringName() {
        return deliveringName;
    }

    public void setDeliveringName(String deliveringName) {
        this.deliveringName = deliveringName;
    }

    public String getDeliveringType() {
        return deliveringType;
    }

    public void setDeliveringType(String deliveringType) {
        this.deliveringType = deliveringType;
    }

    public String getDeliveringColor() {
        return deliveringColor;
    }

    public void setDeliveringColor(String deliveringColor) {
        this.deliveringColor = deliveringColor;
    }

    public double getDeliveringPrice() {
        return deliveringPrice;
    }

    public void setDeliveringPrice(double deliveringPrice) {
        this.deliveringPrice = deliveringPrice;
    }

    public int getDeliveringQuantity() {
        return deliveringQuantity;
    }

    public void setDeliveringQuantity(int deliveringQuantity) {
        this.deliveringQuantity = deliveringQuantity;
    }

    public String getDeliveringCode() {
        return deliveringCode;
    }

    public void setDeliveringCode(String deliveringCode) {
        this.deliveringCode = deliveringCode;
    }
}
