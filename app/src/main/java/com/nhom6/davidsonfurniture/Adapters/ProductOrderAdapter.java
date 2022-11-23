package com.nhom6.davidsonfurniture.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Models.ProductOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class ProductOrderAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<ProductOrder> OrderList;

    //Constructor
    public ProductOrderAdapter(Activity activity, int item_layout, List<ProductOrder> orderList) {
        this.activity = activity;
        this.item_layout = item_layout;
        OrderList = orderList;
    }

    @Override
    public int getCount() {
        return OrderList.size();
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
        ViewHolder holder;
        if(view==null){
            //Link View
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout,null);
            //Ánh xạ
            holder.imgProductOrder = view.findViewById(R.id.img_productOrder);
            holder.proOrderName = view.findViewById(R.id.txt_ProNameOrder);
            holder.proOrderType = view.findViewById(R.id.txt_ProTypeOrder);
            holder.proOrderColor = view.findViewById(R.id.txt_ProColorOrder);
            holder.proOrderPrice = view.findViewById(R.id.txt_ProPriceOrder);
            holder.proOrderQuantity = view.findViewById(R.id.txt_ProQuantityOrder);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        //Gán giá trị
        ProductOrder p = OrderList.get(i);
        holder.imgProductOrder.setImageResource(p.getProductImage());
        holder.proOrderName.setText(p.getProductName());
        holder.proOrderType.setText(p.getProductType());
        holder.proOrderColor.setText(p.getProductColor());
        holder.proOrderPrice.setText(String.valueOf(p.getProductPrice()));
        holder.proOrderQuantity.setText(String.valueOf(p.getProductQuantity()));

        return view;
    }

    public static class ViewHolder{
        ImageView imgProductOrder;
        TextView proOrderName, proOrderType, proOrderColor, proOrderPrice, proOrderQuantity;
    }

}
