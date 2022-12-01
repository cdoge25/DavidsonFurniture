package com.nhom6.davidsonfurniture.Adapters;

public class SexAdapter {
    private String sex;

    public SexAdapter(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    @Override
    public String toString() {
        return this.getSex();
    }
}
