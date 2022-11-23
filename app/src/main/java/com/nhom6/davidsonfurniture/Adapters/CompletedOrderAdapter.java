package com.nhom6.davidsonfurniture.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Models.CompletedOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class CompletedOrderAdapter extends BaseAdapter {

    Activity activity;
    int item_layout;
    List<CompletedOrder> completedorders;

    public CompletedOrderAdapter(Activity activity, int item_layout, List<CompletedOrder> completedorders) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.completedorders = completedorders;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //link views and binding data: ánh xạ textview
        CompletedOrderAdapter.ViewHolder holder;
        if (view == null){
            holder = new CompletedOrderAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.imvCompletedThumb = view.findViewById(R.id.imvCompletedThumb);
            holder.txtCompletedName = view.findViewById(R.id.txtCompletedName);
            holder.txtCompletedType = view.findViewById(R.id.txtCompletedType);
            holder.txtCompletedPrice = view.findViewById(R.id.txtCompletedPrice);
            holder.txtCompletedColor = view.findViewById(R.id.txtCompletedColor);
            holder.txtCompletedQuantity = view.findViewById(R.id.txtCompletedQuantity);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        //binding data: nạp dữ liệu
        CompletedOrder b = completedorders.get(i);
        holder.imvCompletedThumb.setImageResource(b.getCompletedThumb());
        holder.txtCompletedName.setText(b.getCompletedName());
        holder.txtCompletedType.setText(b.getCompletedType());
        holder.txtCompletedPrice.setText(b.getCompletedPrice());
        holder.txtCompletedColor.setText(b.getCompletedColor());
        holder.txtCompletedQuantity.setText(b.getCompletedQuantity());
        return view;
    }

    public static class ViewHolder{
        ImageView imvCompletedThumb;
        TextView txtCompletedName, txtCompletedPrice, txtCompletedType, txtCompletedColor, txtCompletedQuantity;
    }
}
