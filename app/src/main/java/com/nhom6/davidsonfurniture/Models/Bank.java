package com.nhom6.davidsonfurniture.Models;

public class Bank {
    int imageBank;
    String bankName;

    //Constructor
    public Bank(int imageBank, String bankName) {
        this.imageBank = imageBank;
        this.bankName = bankName;
    }

    //Getter and setter

    public int getImageBank() {
        return imageBank;
    }

    public void setImageBank(int imageBank) {
        this.imageBank = imageBank;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
