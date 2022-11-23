package com.nhom6.davidsonfurniture.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Models.ProductInfor;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class ProductCartAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<ProductInfor> product;

    //Constructor
    public ProductCartAdapter(Activity activity, int item_layout, List<ProductInfor> product) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.product = product;
    }

    @Override
    public int getCount() {
        return product.size();
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

        if(view ==null){
            //Link View
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout,null);
            //Ánh xạ
            holder.imgProduct = view.findViewById(R.id.img_product);
            holder.proName = view.findViewById(R.id.txt_ProductName);
            holder.proType = view.findViewById(R.id.txt_ProductType);
            holder.proPrice = view.findViewById(R.id.txt_ProductPrice);

//            holder.chkSelect = view.findViewById(R.id.chk_select);

            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        //Gán giá trị
        ProductInfor p = product.get(i);
        holder.imgProduct.setImageResource(p.getProductImage());
        holder.proName.setText(p.getProductName());
        holder.proType.setText(p.getProductType());
//      holder.proPrice.setText((int) p.getProductPrice());
        holder.proPrice.setText(String.valueOf(p.getProductPrice()));

        //holder.chkSelect.set....

        return view;
    }

    public static class ViewHolder {
        ImageView imgProduct;
        TextView proName, proType, proPrice;
    }
}
