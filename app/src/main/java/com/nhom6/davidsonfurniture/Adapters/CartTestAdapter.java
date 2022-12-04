package com.nhom6.davidsonfurniture.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nhom6.davidsonfurniture.Activities.CartActivity;
import com.nhom6.davidsonfurniture.Models.ProductCart;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;
import java.util.List;

public class CartTestAdapter extends ArrayAdapter<ProductCart> {
    CartActivity context;
    ArrayList<ProductCart> arrayList;
    int item_layout;

    public CartTestAdapter( Context context, int resource,ArrayList<ProductCart>objects) {
        super(context, resource, objects);
        this.context = (CartActivity) context;
        this.arrayList = objects;
        this.item_layout = resource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        CartAdapter.ViewHolder holder;
        if(convertView ==null){
            //Link View
            holder = new CartAdapter.ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(item_layout,null);
            //Ánh xạ
            holder.imgProduct = convertView.findViewById(R.id.img_product);
            holder.proName = convertView.findViewById(R.id.txt_ProductName);
            holder.proType = convertView.findViewById(R.id.txt_ProductType);
            holder.proPrice = convertView.findViewById(R.id.txt_ProductPrice);
            holder.proColor = convertView.findViewById(R.id.txt_ProductColor);
            holder.proNumber = convertView.findViewById(R.id.txt_NumberInCart);
            holder.btnDelete = convertView.findViewById(R.id.btn_deleteCart);
            holder.btnPlus = convertView.findViewById(R.id.btn_plus);
            holder.btnMinus = convertView.findViewById(R.id.btn_minus);
            holder.chkSelect = convertView.findViewById(R.id.chk_select);

            convertView.setTag(holder);
        }else{
            holder = (CartAdapter.ViewHolder) convertView.getTag();
        }

        //Gán giá trị
        ProductCart p = arrayList.get(position);
        holder.imgProduct.setImageResource(p.getProductThumb());
        holder.proName.setText(p.getProductName());
        holder.proType.setText(p.getProductType());
        holder.proPrice.setText(String.valueOf(p.getProductPrice()));
        holder.proColor.setText(p.getProductColor());
        holder.proNumber.setText(p.getProductQuantity());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogDelete(p);

            }
        });
        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.chkSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.proColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogColor();
            }
        });
        //Intent

        return convertView;
    }
    public static class ViewHolder {
        ImageView imgProduct;
        TextView proName, proType, proPrice, proColor, proNumber;
        ImageButton btnDelete, btnPlus, btnMinus;
        CheckBox chkSelect;
    }
}

