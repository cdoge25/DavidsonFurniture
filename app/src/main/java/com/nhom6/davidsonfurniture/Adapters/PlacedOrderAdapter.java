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

import com.nhom6.davidsonfurniture.Activities.PlacedOrderDetailActivity;
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
        holder.imvThumb.setImageResource(b.getPlacedThumb());
        holder.txtName.setText(b.getPlacedName());
        holder.txtType.setText(b.getPlacedType());
        holder.txtColor.setText(b.getPlacedColor());
        holder.txtPrice.setText(String.format("%.0f", b.getPlacedPrice()) + "đ");
        holder.txtQuantity.setText(String.format("Số lượng: %s",b.getPlacedQuantity()));

        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { goToDetail(b);
            }
        });

        holder.layoutItemPlaced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDetail(b);
            }
        });
    }

    private void goToDetail(PlacedOrder b) {
        Intent intent = new Intent(context, PlacedOrderDetailActivity.class);
        //truyền dữ liệu
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_placed", b);
        intent.putExtras(bundle);
        context.startActivity(intent);
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
        Button btnDetail;
        RelativeLayout layoutItemPlaced;

        public PlacedViewHolder(View view) {
            super(view);
            imvThumb = view.findViewById(R.id.imvPlacedThumb);
            txtName = view.findViewById(R.id.txtPlacedName);
            txtType = view.findViewById(R.id.txtPlacedType);
            txtColor = view.findViewById(R.id.txtPlacedColor);
            txtPrice = view.findViewById(R.id.txtPlacedPrice);
            txtQuantity = view.findViewById(R.id.txtPlacedQuantity);
            btnDetail = view.findViewById(R.id.btnDetail);
            layoutItemPlaced = view.findViewById(R.id.layoutItemPlaced);
        }
    }

//    public void deletePlacedOrder(int i){
//        placedOrderList.remove(i);
//    }
}

