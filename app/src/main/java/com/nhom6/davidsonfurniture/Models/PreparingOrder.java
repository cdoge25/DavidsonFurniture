package com.nhom6.davidsonfurniture.Models;

import java.io.Serializable;

public class PreparingOrder implements Serializable {
    int preparingID;
    int preparingThumb;
    String preparingName;
    String preparingType;
    String preparingColor;
    double preparingPrice;
    int preparingQuantity;
    String preparingCode;

    public int getPreparingID() {
        return preparingID;
    }

    public PreparingOrder(int preparingThumb, String preparingName, String preparingType, String preparingColor, double preparingPrice, int preparingQuantity, String preparingCode) {
        this.preparingThumb = preparingThumb;
        this.preparingName = preparingName;
        this.preparingType = preparingType;
        this.preparingColor = preparingColor;
        this.preparingPrice = preparingPrice;
        this.preparingQuantity = preparingQuantity;
        this.preparingCode = preparingCode;
    }

    public int getPreparingThumb() {
        return preparingThumb;
    }

    public void setPreparingThumb(int preparingThumb) {
        this.preparingThumb = preparingThumb;
    }

    public String getPreparingName() {
        return preparingName;
    }

    public void setPreparingName(String preparingName) {
        this.preparingName = preparingName;
    }

    public String getPreparingType() {
        return preparingType;
    }

    public void setPreparingType(String preparingType) {
        this.preparingType = preparingType;
    }

    public String getPreparingColor() {
        return preparingColor;
    }

    public void setPreparingColor(String preparingColor) {
        this.preparingColor = preparingColor;
    }

    public double getPreparingPrice() {
        return preparingPrice;
    }

    public void setPreparingPrice(double preparingPrice) {
        this.preparingPrice = preparingPrice;
    }

    public int getPreparingQuantity() {
        return preparingQuantity;
    }

    public void setPreparingQuantity(int preparingQuantity) {
        this.preparingQuantity = preparingQuantity;
    }

    public String getPreparingCode() {
        return preparingCode;
    }

    public void setPreparingCode(String preparingCode) {
        this.preparingCode = preparingCode;
    }
}
