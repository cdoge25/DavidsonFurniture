package com.nhom6.davidsonfurniture.Models;

public class PreparingOrder {
    int preparingThumb;
    String preparingName;
    String preparingType;
    String preparingColor;
    String preparingPrice;
    String preparingQuantity;

    public PreparingOrder(int preparingThumb, String preparingName, String preparingType, String preparingColor, String preparingPrice, String preparingQuantity) {
        this.preparingThumb = preparingThumb;
        this.preparingName = preparingName;
        this.preparingType = preparingType;
        this.preparingColor = preparingColor;
        this.preparingPrice = preparingPrice;
        this.preparingQuantity = preparingQuantity;
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

    public String getPreparingPrice() {
        return preparingPrice;
    }

    public void setPreparingPrice(String preparingPrice) {
        this.preparingPrice = preparingPrice;
    }

    public String getPreparingQuantity() {
        return preparingQuantity;
    }

    public void setPreparingQuantity(String preparingQuantity) {
        this.preparingQuantity = preparingQuantity;
    }
}
