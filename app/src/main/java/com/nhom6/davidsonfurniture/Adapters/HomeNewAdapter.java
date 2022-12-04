package com.nhom6.davidsonfurniture.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;

public class HomeNewAdapter extends RecyclerView.Adapter<HomeNewAdapter.HomeNewViewHolder> {

    ArrayList<Product> products;

    public HomeNewAdapter (ArrayList<Product> products){
        this.products = products;
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
        holder.imvThumb.setImageResource(p.getProductThumb());
        holder.txtName.setText(p.getProductName());
        holder.txtRate.setText(p.getProductRate());
        holder.txtProductCategory.setText(p.getProductCategory());
        holder.txtPrice.setText(String.valueOf(p.getProductPrice()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class HomeNewViewHolder extends RecyclerView.ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtProductCategory, txtRate,txtPrice;

        public HomeNewViewHolder(@NonNull View view){
            super(view);
            imvThumb = view.findViewById(R.id.imvThumb);
            txtName = view.findViewById(R.id.txtName);
            txtProductCategory=view.findViewById(R.id.txtCategory);
            txtRate = view.findViewById(R.id.txtRate);
            txtPrice=view.findViewById(R.id.txtPrice);
        }

    }
}
