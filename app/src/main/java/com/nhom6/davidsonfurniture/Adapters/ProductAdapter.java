package com.nhom6.davidsonfurniture.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    Activity activity;
    int item_product; //view
    List <Product> product; // dữ liệu trong view

    public ProductAdapter(Activity activity, int item_product, List<Product> product) {
        this.activity = activity;
        this.item_product = item_product;
        this.product = product;
    }

    @Override
    public int getCount() {
        return product.size();
    }

    @Override
    public Object getItem(int i) {
        return product.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ///Link views and binding data
        ViewHolder holder;
        if (view == null) {
            //Link views
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_product, null);

            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtProductCategory=view.findViewById(R.id.txtProductCategory);
            holder.txtRate = view.findViewById(R.id.txtRate);
            holder.txtPrice=view.findViewById(R.id.txtPrice);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        Product p = product.get(i);
        holder.imvThumb.setImageResource(p.getProductThumb());
        holder.txtName.setText(p.getProductName());
        holder.txtRate.setText(p.getProductRate());
        holder.txtProductCategory.setText(p.getProductCategory());
        holder.txtPrice.setText(String.valueOf(p.getProductPrice()));

        return view;

    }
    public static class ViewHolder {
        ImageView imvThumb;
        TextView txtName, txtProductCategory, txtRate,txtPrice;

    }

}
