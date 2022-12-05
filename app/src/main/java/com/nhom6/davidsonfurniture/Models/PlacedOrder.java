package com.nhom6.davidsonfurniture.Models;

import java.io.Serializable;

public class PlacedOrder implements Serializable {
    int placedID;
    int placedThumb;
    String placedName;
    String placedType;
    String placedColor;
    double placedPrice;
    int placedQuantity;
    String placedCode;

    public PlacedOrder(int placedID, int placedThumb, String placedName, String placedType, String placedColor, double placedPrice, int placedQuantity, String placedCode) {
        this.placedID = placedID;
        this.placedThumb = placedThumb;
        this.placedName = placedName;
        this.placedType = placedType;
        this.placedColor = placedColor;
        this.placedPrice = placedPrice;
        this.placedQuantity = placedQuantity;
        this.placedCode = placedCode;
    }

    public int getPlacedID() {
        return placedID;
    }

    public void setPlacedID(int placedID) {
        this.placedID = placedID;
    }

    public int getPlacedThumb() {
        return placedThumb;
    }

    public void setPlacedThumb(int placedThumb) {
        this.placedThumb = placedThumb;
    }

    public String getPlacedName() {
        return placedName;
    }

    public void setPlacedName(String placedName) {
        this.placedName = placedName;
    }

    public String getPlacedType() {
        return placedType;
    }

    public void setPlacedType(String placedType) {
        this.placedType = placedType;
    }

    public String getPlacedColor() {
        return placedColor;
    }

    public void setPlacedColor(String placedColor) {
        this.placedColor = placedColor;
    }

    public double getPlacedPrice() {
        return placedPrice;
    }

    public void setPlacedPrice(double placedPrice) {
        this.placedPrice = placedPrice;
    }

    public int getPlacedQuantity() {
        return placedQuantity;
    }

    public void setPlacedQuantity(int placedQuantity) {
        this.placedQuantity = placedQuantity;
    }

    public String getPlacedCode() {
        return placedCode;
    }

    public void setPlacedCode(String placedCode) {
        this.placedCode = placedCode;
    }

}


