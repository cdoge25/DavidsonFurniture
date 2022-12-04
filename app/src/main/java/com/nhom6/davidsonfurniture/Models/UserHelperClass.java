package com.nhom6.davidsonfurniture.Models;

public class UserHelperClass {
    String name, mail, phone, password;

    public UserHelperClass(){}

    public UserHelperClass(String name, String mail, String phone, String password) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
