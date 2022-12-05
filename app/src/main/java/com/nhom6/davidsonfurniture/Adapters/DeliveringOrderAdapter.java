package com.nhom6.davidsonfurniture.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Activities.DeliveringOrderDetailActivity;
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
        holder.txtPrice.setText(String.format("%.0f", b.getDeliveringPrice()) + "đ");
        holder.txtQuantity.setText(String.format("Số lượng: %s",b.getDeliveringQuantity()));

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDetail(b);
            }
        });

        holder.layoutItemDelivering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDetail(b);
            }
        });
    }

    private void goToDetail(DeliveringOrder b) {
        Intent intent = new Intent(context, DeliveringOrderDetailActivity.class);
        //truyền dữ liệu
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_delivering", b);
        intent.putExtras(bundle);
        context.startActivity(intent);
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
        Button btnDetail;
        RelativeLayout layoutItemDelivering;

        public DeliveringViewHolder(View view) {
            super(view);
            imvThumb = view.findViewById(R.id.imvDeliveringThumb);
            txtName = view.findViewById(R.id.txtDeliveringName);
            txtType = view.findViewById(R.id.txtDeliveringType);
            txtColor = view.findViewById(R.id.txtDeliveringColor);
            txtPrice = view.findViewById(R.id.txtDeliveringPrice);
            txtQuantity = view.findViewById(R.id.txtDeliveringQuantity);
            btnDetail = view.findViewById(R.id.btnDeliveringDetail);
            layoutItemDelivering = view.findViewById(R.id.layoutItemDelivering);
        }
    }
}
