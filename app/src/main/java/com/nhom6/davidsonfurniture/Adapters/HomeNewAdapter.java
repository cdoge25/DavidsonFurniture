package com.nhom6.davidsonfurniture.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Activities.DetailProductActivity;
import com.nhom6.davidsonfurniture.Models.DetailProduct;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;

public class HomeNewAdapter extends RecyclerView.Adapter<HomeNewAdapter.HomeNewViewHolder> {

    ArrayList<Product> products;
    Context context;
    public HomeNewAdapter (Context context, ArrayList<Product> products){
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeNewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_new, parent, false);
        HomeNewViewHolder homeNewViewHolder = new HomeNewViewHolder(view);
        return homeNewViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull HomeNewViewHolder holder, int position) {
        Product p = products.get(position);

        int thumb, price;
        String name, rate, category;

        thumb = p.getProductThumb();
        name = p.getProductName();
        rate = p.getProductRate();
        category = p.getProductCategory();
        price = p.getProductPrice();

        holder.imvThumb.setImageResource(p.getProductThumb());
        holder.txtName.setText(p.getProductName());
        holder.txtRate.setText(p.getProductRate());
        holder.txtProductCategory.setText(p.getProductCategory());
        holder.txtPrice.setText(String.valueOf(p.getProductPrice()));
        holder.layoutProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailProductActivity.class);
                intent.putExtra("Image", thumb);
                intent.putExtra("Name", name);
                intent.putExtra("Rate", rate);
                intent.putExtra("Category", category);
                intent.putExtra("Price", price);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class HomeNewViewHolder extends RecyclerView.ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtProductCategory, txtRate,txtPrice;
        CardView layoutProduct;

        public HomeNewViewHolder(@NonNull View view){
            super(view);
            imvThumb = view.findViewById(R.id.imvThumb);
            txtName = view.findViewById(R.id.txtName);
            txtProductCategory=view.findViewById(R.id.txtCategory);
            txtRate = view.findViewById(R.id.txtRate);
            txtPrice = view.findViewById(R.id.txtPrice);
            layoutProduct = view.findViewById(R.id.layoutHomeProduct);
        }

    }
}
