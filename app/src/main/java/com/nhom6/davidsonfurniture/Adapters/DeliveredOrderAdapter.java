package com.nhom6.davidsonfurniture.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Models.DeliveredOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class DeliveredOrderAdapter extends RecyclerView.Adapter<DeliveredOrderAdapter.DeliveredViewHolder> {

    List<DeliveredOrder> deliveredOrderList;
    Context context;

    public DeliveredOrderAdapter(Context context, List<DeliveredOrder> deliveredOrderList) {
        this.deliveredOrderList = deliveredOrderList;
        this.context = context;
    }

    @NonNull
    @Override
    public DeliveredOrderAdapter.DeliveredViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delivered_order,parent,false);
        return new DeliveredOrderAdapter.DeliveredViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveredOrderAdapter.DeliveredViewHolder holder, int position) {
            DeliveredOrder b = deliveredOrderList.get(position);
            holder.imvThumb.setImageResource(b.getDeliveredThumb());
            holder.txtName.setText(b.getDeliveredName());
            holder.txtType.setText(b.getDeliveredType());
            holder.txtColor.setText(b.getDeliveredColor());
            holder.txtPrice.setText(b.getDeliveredPrice());
            holder.txtQuantity.setText(b.getDeliveredQuantity());
    }

    @Override
    public int getItemCount() {
           return deliveredOrderList.size();
    }

    public void release() {
    }

    public class DeliveredViewHolder extends RecyclerView.ViewHolder {
        ImageView imvThumb;
        TextView txtName, txtType, txtColor, txtPrice, txtQuantity;

        public DeliveredViewHolder(View view) {
            super(view);
            imvThumb = view.findViewById(R.id.imvDeliveredThumb);
            txtName = view.findViewById(R.id.txtDeliveredName);
            txtType = view.findViewById(R.id.txtDeliveredType);
            txtColor = view.findViewById(R.id.txtDeliveredColor);
            txtPrice = view.findViewById(R.id.txtDeliveredPrice);
            txtQuantity = view.findViewById(R.id.txtDeliveredQuantity);
        }
    }
}
