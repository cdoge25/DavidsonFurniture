package com.nhom6.davidsonfurniture.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Activities.CartActivity;
import com.nhom6.davidsonfurniture.Models.ProductCart;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class CartAdapter extends BaseAdapter {
    CartActivity activity;
    int item_layout;
    List<ProductCart> product;

    //Constructor
    public CartAdapter(CartActivity activity, int item_layout, List<ProductCart> product) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.product = product;
    }

    @Override
    public int getCount() {
        return product.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CartAdapter.ViewHolder holder;
        if(convertView ==null){
            //Link View
            holder = new CartAdapter.ViewHolder();

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        ProductCart p = product.get(position);
        holder.imgProduct.setImageResource(p.getProductImage());
        holder.proName.setText(p.getProductName());
        holder.proType.setText(p.getProductType());
        holder.proPrice.setText(String.valueOf(p.getProductPrice()));
        holder.proColor.setText(p.getProductColor());
        holder.proNumber.setText(p.getProductQuantity());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DialogDelete(p);

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
                activity.DialogColor();
            }
        });
        return convertView;

    }

    public static class ViewHolder {
        ImageView imgProduct;
        TextView proName, proType, proPrice, proColor, proNumber;
        ImageButton btnDelete, btnPlus, btnMinus;
        CheckBox chkSelect;
    }
}
