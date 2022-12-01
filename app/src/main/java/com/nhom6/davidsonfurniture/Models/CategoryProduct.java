package com.nhom6.davidsonfurniture.Models;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.squareup.picasso.Picasso;

public class CategoryProduct {

    String ProductThumb, ProductName;
    int id;

    public String getProductThumb() {
        return ProductThumb;
    }

    public void setProductThumb(String productThumb) {
        ProductThumb = productThumb;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
