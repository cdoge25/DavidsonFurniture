package com.nhom6.davidsonfurniture.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Models.DetailProduct;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class DetailProductAdapter extends BaseAdapter {

    Activity activity;
    int item_detail_product; //view
    List<DetailProduct> product; // dữ liệu trong view

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ///Link views and binding data
        DetailProductAdapter.ViewHolder holder;
        if (view == null) {
            //Link views
            holder = new DetailProductAdapter.ViewHolder();

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_detail_product, null);

            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.txtProductCategory=view.findViewById(R.id.txtProductCategory);
            holder.txtRate = view.findViewById(R.id.txtRate);
            holder.txtPrice=view.findViewById(R.id.txtPrice);
            holder.txtSize = view.findViewById(R.id.txtSize);
            holder.txtMaterial = view.findViewById(R.id.txtMaterial);


            view.setTag(holder);

        } else {
            holder = (DetailProductAdapter.ViewHolder) view.getTag();
        }

        DetailProduct p = product.get(i);
        holder.imvThumb.setImageResource(p.getProductThumb());
        holder.txtName.setText(p.getProductName());
        holder.txtRate.setText(p.getProductRate());
        holder.txtProductCategory.setText(p.getProductCategory());
        holder.txtPrice.setText(String.valueOf(p.getProductPrice()));
        holder.txtSize = view.findViewById(R.id.txtSize);
        holder.txtMaterial = view.findViewById(R.id.txtMaterial);

        return view;

    }
    public static class ViewHolder {
        ImageView imvThumb;
        TextView txtName, txtProductCategory, txtRate,txtPrice, txtSize, txtMaterial;
        RadioButton radWhite, radGray, radBlack;

    }

}
