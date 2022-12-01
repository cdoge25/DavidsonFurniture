package com.nhom6.davidsonfurniture.Models;

public class DeliveringOrder {
    int deliveringThumb; //hình ảnh
    String deliveringName;
    String deliveringType;
    String deliveringColor;
    String deliveringPrice;
    String deliveringQuantity;

    public DeliveringOrder(int deliveringThumb, String deliveringName, String deliveringType, String deliveringColor, String deliveringPrice, String deliveringQuantity) {
        this.deliveringThumb = deliveringThumb;
        this.deliveringName = deliveringName;
        this.deliveringType = deliveringType;
        this.deliveringColor = deliveringColor;
        this.deliveringPrice = deliveringPrice;
        this.deliveringQuantity = deliveringQuantity;
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

    public String getDeliveringPrice() {
        return deliveringPrice;
    }

    public void setDeliveringPrice(String deliveringPrice) {
        this.deliveringPrice = deliveringPrice;
    }

    public String getDeliveringQuantity() {
        return deliveringQuantity;
    }

    public void setDeliveringQuantity(String deliveringQuantity) {
        this.deliveringQuantity = deliveringQuantity;
    }

}
