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

import com.nhom6.davidsonfurniture.Activities.PreparingOrderDetailActivity;
import com.nhom6.davidsonfurniture.Models.PreparingOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class PreparingOrderAdapter extends RecyclerView.Adapter<PreparingOrderAdapter.PreparingViewHolder> {

    List<PreparingOrder> preparingOrderList;
    Context context;

    public PreparingOrderAdapter(Context context, List<PreparingOrder> preparingOrderList) {
        this.preparingOrderList = preparingOrderList;
        this.context = context;
    }

    @NonNull
    @Override
    public PreparingOrderAdapter.PreparingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_preparing_order,parent,false);
        return new PreparingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PreparingOrderAdapter.PreparingViewHolder holder, int position) {
        PreparingOrder b = preparingOrderList.get(position);
        holder.imvThumb.setImageResource(b.getPreparingThumb());
        holder.txtName.setText(b.getPreparingName());
        holder.txtType.setText(b.getPreparingType());
        holder.txtColor.setText(b.getPreparingColor());
        holder.txtPrice.setText(String.format("%.0f", b.getPreparingPrice()) + "đ");
        holder.txtQuantity.setText(String.format("Số lượng: %s",b.getPreparingQuantity()));

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDetail(b);
            }
        });

        holder.layoutItemPreparing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDetail(b);
            }
        });
    }

    private void goToDetail(PreparingOrder b) {
        Intent intent = new Intent(context, PreparingOrderDetailActivity.class);
        //truyền dữ liệu
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_preparing", b);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return preparingOrderList.size();
    }

    public void release() { context = null;
    }

    public class PreparingViewHolder extends RecyclerView.ViewHolder {

        ImageView imvThumb;
        TextView txtName, txtType, txtPrice, txtColor, txtQuantity;
        Button btnDetail;
        RelativeLayout layoutItemPreparing;

        public PreparingViewHolder(View view) {
            super(view);
            imvThumb = view.findViewById(R.id.imvPreparingThumb);
            txtName = view.findViewById(R.id.txtPreparingName);
            txtType = view.findViewById(R.id.txtPreparingType);
            txtColor = view.findViewById(R.id.txtPreparingColor);
            txtPrice = view.findViewById(R.id.txtPreparingPrice);
            txtQuantity = view.findViewById(R.id.txtPreparingQuantity);
            btnDetail = view.findViewById(R.id.btnPreparingDetail);
            layoutItemPreparing = view.findViewById(R.id.layoutItemPreparing);
        }
    }
}
