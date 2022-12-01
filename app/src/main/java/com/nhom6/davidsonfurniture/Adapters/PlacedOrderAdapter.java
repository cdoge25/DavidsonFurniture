package com.nhom6.davidsonfurniture.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Models.PlacedOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class PlacedOrderAdapter extends RecyclerView.Adapter<PlacedOrderAdapter.PlacedViewHolder>{

    List<PlacedOrder> placedOrderList;
    Context context;

    public PlacedOrderAdapter(Context context, List<PlacedOrder> placedOrderList) {
        this.placedOrderList = placedOrderList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlacedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_placed_order,parent,false);
        return new PlacedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlacedOrderAdapter.PlacedViewHolder holder, int position) {
        PlacedOrder b = placedOrderList.get(position);
        holder.imvThumb.setImageResource(b.getOrderThumb());
        holder.txtName.setText(b.getOrderName());
        holder.txtType.setText(b.getOrderType());
        holder.txtColor.setText(b.getOrderColor());
        holder.txtPrice.setText(b.getOrderPrice());
        holder.txtQuantity.setText(b.getOrderQuantity());
    }

    public void release(){
        context = null;
    }

    @Override
    public int getItemCount() {
        return placedOrderList.size();
    }

    public class PlacedViewHolder extends RecyclerView.ViewHolder {
        ImageView imvThumb;
        TextView txtName, txtType, txtPrice, txtColor, txtQuantity;

        public PlacedViewHolder(View view) {
            super(view);
            imvThumb = view.findViewById(R.id.imvOrderThumb);
            txtName = view.findViewById(R.id.txtOrderName);
            txtType = view.findViewById(R.id.txtType);
            txtColor = view.findViewById(R.id.txtColor);
            txtPrice = view.findViewById(R.id.txtOrderDetailPrice);
            txtQuantity = view.findViewById(R.id.txtQuantity);
        }
    }
}

