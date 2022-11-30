package com.nhom6.davidsonfurniture.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Models.DeliveredOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class DeliveredOrderAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<DeliveredOrder> deliveredorders;

    public DeliveredOrderAdapter(Activity activity, int item_layout, List<DeliveredOrder> orders) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.deliveredorders = orders;
    }

    @Override
    public int getCount() {
        return deliveredorders.size();
    }

    @Override
    public Object getItem(int i) {
        return deliveredorders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //link views and binding data: ánh xạ textview
        DeliveredOrderAdapter.ViewHolder holder;
        if (view == null){
            holder = new DeliveredOrderAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.imvDeliveredThumb = view.findViewById(R.id.imvDeliveredThumb);
            holder.txtDeliveredName = view.findViewById(R.id.txtDeliveredName);
            holder.txtDeliveredType = view.findViewById(R.id.txtDeliveredType);
            holder.txtDeliveredColor = view.findViewById(R.id.txtDeliveredColor);
            holder.txtDeliveredPrice = view.findViewById(R.id.txtDeliveredPrice);
            holder.txtDeliveredQuantity = view.findViewById(R.id.txtDeliveredQuantity);

            view.setTag(holder);
        }
        else{
            holder = (DeliveredOrderAdapter.ViewHolder) view.getTag();
        }
        //binding data: nạp dữ liệu
        DeliveredOrder b = deliveredorders.get(i);
        holder.imvDeliveredThumb.setImageResource(b.getDeliveredThumb());
        holder.txtDeliveredName.setText(b.getDeliveredName());
        holder.txtDeliveredType.setText(b.getDeliveredType());
        holder.txtDeliveredColor.setText(b.getDeliveredColor());
        holder.txtDeliveredPrice.setText(b.getDeliveredPrice());
        holder.txtDeliveredQuantity.setText(b.getDeliveredQuantity());
        return view;
    }

    public static class ViewHolder{
        ImageView imvDeliveredThumb;
        TextView txtDeliveredName, txtDeliveredType, txtDeliveredColor, txtDeliveredPrice, txtDeliveredQuantity;
    }
}
