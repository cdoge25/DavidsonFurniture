package com.nhom6.davidsonfurniture.Models;

public class CompletedOrder {

    int completedThumb;
    String completedName;
    String completedType;
    String completedColor;
    String completedPrice;
    String completedQuantity;

    public CompletedOrder(int completedThumb, String completedName, String completedType, String completedColor, String completedPrice, String completedQuantity) {
        this.completedThumb = completedThumb;
        this.completedName = completedName;
        this.completedType = completedType;
        this.completedColor = completedColor;
        this.completedPrice = completedPrice;
        this.completedQuantity = completedQuantity;
    }

    public int getCompletedThumb() {
        return completedThumb;
    }

    public void setCompletedThumb(int completedThumb) {
        this.completedThumb = completedThumb;
    }

    public String getCompletedName() {
        return completedName;
    }

    public void setCompletedName(String completedName) {
        this.completedName = completedName;
    }

    public String getCompletedType() {
        return completedType;
    }

    public void setCompletedType(String completedType) {
        this.completedType = completedType;
    }

    public String getCompletedColor() {
        return completedColor;
    }

    public void setCompletedColor(String completedColor) {
        this.completedColor = completedColor;
    }

    public String getCompletedPrice() {
        return completedPrice;
    }

    public void setCompletedPrice(String completedPrice) {
        this.completedPrice = completedPrice;
    }

    public String getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(String completedQuantity) {
        this.completedQuantity = completedQuantity;
    }
}
