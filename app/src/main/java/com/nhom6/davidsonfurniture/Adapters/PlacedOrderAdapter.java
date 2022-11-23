package com.nhom6.davidsonfurniture.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Models.PlacedOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class PlacedOrderAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<PlacedOrder> orders;

    public PlacedOrderAdapter(Activity activity, int item_layout, List<PlacedOrder> orders) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.orders = orders;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int i) {
        return orders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //link views and binding data: ánh xạ textview
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.imvThumb = view.findViewById(R.id.imvOrderDetailThumb);
            holder.txtName = view.findViewById(R.id.txtOrderDetailName);
            holder.txtType = view.findViewById(R.id.txtType);
            holder.txtColor = view.findViewById(R.id.txtColor);
            holder.txtOrderDetailPrice = view.findViewById(R.id.txtOrderDetailPrice);
            holder.txtQuantity = view.findViewById(R.id.txtQuantity);

            view.setTag(holder);
        }
        else{
            holder = (ViewHolder) view.getTag();
        }
        //binding data: nạp dữ liệu
        PlacedOrder b = orders.get(i);
        holder.imvThumb.setImageResource(b.getOrderThumb());
        holder.txtName.setText(b.getOrderName());
        holder.txtType.setText(b.getOrderType());
        holder.txtColor.setText(b.getOrderColor());
        holder.txtOrderDetailPrice.setText(b.getOrderPrice());
        holder.txtQuantity.setText(b.getOrderQuantity());
        return view;
    }

    public static class ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtType, txtOrderDetailPrice, txtColor, txtQuantity;
    }
}

