package com.nhom6.davidsonfurniture.Models;

import java.io.Serializable;

public class CompletedOrder implements Serializable {
    int completedID;
    int completedThumb;
    String completedName;
    String completedType;
    String completedColor;
    double completedPrice;
    int completedQuantity;
    String completedCode;

    public CompletedOrder(int completedThumb, String completedName, String completedType, String completedColor, double completedPrice, int completedQuantity, String completedCode) {
        this.completedThumb = completedThumb;
        this.completedName = completedName;
        this.completedType = completedType;
        this.completedColor = completedColor;
        this.completedPrice = completedPrice;
        this.completedQuantity = completedQuantity;
        this.completedCode = completedCode;
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

    public double getCompletedPrice() {
        return completedPrice;
    }

    public void setCompletedPrice(double completedPrice) {
        this.completedPrice = completedPrice;
    }

    public int getCompletedQuantity() {
        return completedQuantity;
    }

    public void setCompletedQuantity(int completedQuantity) {
        this.completedQuantity = completedQuantity;
    }

    public String getCompletedCode() {
        return completedCode;
    }

    public void setCompletedCode(String completedCode) {
        this.completedCode = completedCode;
    }

}
