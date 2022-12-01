package com.nhom6.davidsonfurniture.Adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Interfaces.OnClickInterface;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryAdapter extends RecyclerView.Adapter<ProductCategoryAdapter.ViewHolder> {
    Context context;
    ArrayList<Product> products;
    OnClickInterface onClickInterface;

    public ProductCategoryAdapter(Context context, int item_product, ArrayList<Product> products, OnClickInterface onClickInterface) {
        this.context = context;
        this.products = products;
        this.onClickInterface = onClickInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Picasso.get().load(products.get(position).getProductThumb()).into(holder.imvThumb);
        holder.txtName.setText(products.get(position).getProductName());
        holder.txtPrice.setText(String.format("%.0f",products.get(position).getProductPrice()) + "đ");
        holder.txtRate.setText(String.valueOf(products.get(position).getProductRate()));
        holder.txtCategory.setText(products.get(position).getProductCategory());

        holder.layoutProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
///////////////               onClickInterface.setClick(products.get(position).getProductId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtPrice, txtRate, txtCategory;
        LinearLayout layoutProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvThumb= itemView.findViewById(R.id.imvThumb);
            txtName= itemView.findViewById(R.id.txtName);
            txtPrice= itemView.findViewById(R.id.txtPrice);
            txtRate= itemView.findViewById(R.id.txtRate);
            txtCategory=itemView.findViewById(R.id.txtProductCategory);
            layoutProduct= itemView.findViewById(R.id.layoutProduct);


        }
    }
}