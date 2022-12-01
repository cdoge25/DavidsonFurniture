package com.nhom6.davidsonfurniture.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Models.DeliveringOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class DeliveringOrderAdapter extends RecyclerView.Adapter<DeliveringOrderAdapter.DeliveringViewHolder> {

    List<DeliveringOrder> deliveringOrderList;
    Context context;

    public DeliveringOrderAdapter(Context context, List<DeliveringOrder> deliveringOrderList) {
        this.deliveringOrderList = deliveringOrderList;
        this.context = context;
    }

    @NonNull
    @Override
    public DeliveringOrderAdapter.DeliveringViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delivering_order,parent,false);
        return new DeliveringOrderAdapter.DeliveringViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveringOrderAdapter.DeliveringViewHolder holder, int position) {
        DeliveringOrder b = deliveringOrderList.get(position);
        holder.imvThumb.setImageResource(b.getDeliveringThumb());
        holder.txtName.setText(b.getDeliveringName());
        holder.txtType.setText(b.getDeliveringType());
        holder.txtColor.setText(b.getDeliveringColor());
        holder.txtPrice.setText(b.getDeliveringPrice());
        holder.txtQuantity.setText(b.getDeliveringQuantity());
    }

    @Override
    public int getItemCount() {
        return deliveringOrderList.size();
    }

    public void release() {
    }

    public class DeliveringViewHolder extends RecyclerView.ViewHolder {
        ImageView imvThumb;
        TextView txtName, txtType, txtColor, txtPrice, txtQuantity;

        public DeliveringViewHolder(View view) {
            super(view);
            imvThumb = view.findViewById(R.id.imvDeliveringThumb);
            txtName = view.findViewById(R.id.txtDeliveringName);
            txtType = view.findViewById(R.id.txtDeliveringType);
            txtColor = view.findViewById(R.id.txtDeliveringColor);
            txtPrice = view.findViewById(R.id.txtDeliveringPrice);
            txtQuantity = view.findViewById(R.id.txtDeliveringQuantity);
        }
    }
}
