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

import com.nhom6.davidsonfurniture.Activities.ReviewActivity;
import com.nhom6.davidsonfurniture.Models.CompletedOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class CompletedOrderAdapter extends RecyclerView.Adapter<CompletedOrderAdapter.CompletedViewHolder>{

    List<CompletedOrder> completedOrderList;
    Context context;

    public CompletedOrderAdapter(Context context, List<CompletedOrder> completedOrderList) {
        this.completedOrderList = completedOrderList;
        this.context = context;
    }

    @NonNull
    @Override
    public CompletedOrderAdapter.CompletedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_completed_order,parent,false);
        return new CompletedOrderAdapter.CompletedViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CompletedOrderAdapter.CompletedViewHolder holder, int position) {
        CompletedOrder b = completedOrderList.get(position);
        holder.imvCompletedThumb.setImageResource(b.getCompletedThumb());
        holder.txtCompletedName.setText(b.getCompletedName());
        holder.txtCompletedType.setText(b.getCompletedType());
        holder.txtCompletedColor.setText(b.getCompletedColor());
        holder.txtCompletedPrice.setText(String.format("%.0f", b.getCompletedPrice()) + "đ");
        holder.txtCompletedQuantity.setText(String.format("Số lượng: %s",b.getCompletedQuantity()));
//        holder.txtCompletedStatusReview.setText(b.getCompleteStatusReview());

        if (holder.txtCompletedStatusReview.getText().toString() == "1"){
            holder.btnReview.setClickable(false);
        }

        holder.btnReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { goToReview(b);
            }
        });

        holder.layoutItemCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToReview(b);
            }
        });
    }

    private void goToReview(CompletedOrder b) {
        Intent intent = new Intent(context, ReviewActivity.class);
        //truyền dữ liệu
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_completed", b);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return completedOrderList.size();
    }

    public void release() {
    }

    public class CompletedViewHolder extends RecyclerView.ViewHolder {
        ImageView imvCompletedThumb;
        TextView txtCompletedName, txtCompletedPrice, txtCompletedType, txtCompletedColor, txtCompletedQuantity, txtCompletedStatusReview;
        Button btnReview;
        RelativeLayout layoutItemCompleted;

        public CompletedViewHolder(View view) {
            super(view);
            imvCompletedThumb = view.findViewById(R.id.imvCompletedThumb);
            txtCompletedName = view.findViewById(R.id.txtCompletedName);
            txtCompletedType = view.findViewById(R.id.txtCompletedType);
            txtCompletedColor = view.findViewById(R.id.txtCompletedColor);
            txtCompletedPrice = view.findViewById(R.id.txtCompletedPrice);
            txtCompletedQuantity = view.findViewById(R.id.txtCompletedQuantity);
            txtCompletedStatusReview = view.findViewById(R.id.txtCompletedStatusReview);
            btnReview = view.findViewById(R.id.btnReview);
            layoutItemCompleted = view.findViewById(R.id.layoutItemCompleted);
        }
    }
}
