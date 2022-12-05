package com.nhom6.davidsonfurniture.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.nhom6.davidsonfurniture.Activities.CartActivity;
import com.nhom6.davidsonfurniture.Activities.DetailProductActivity;
import com.nhom6.davidsonfurniture.Models.ProductCart;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class CartAdapter extends BaseAdapter {
    CartActivity activity;
    int item_layout;
    List<ProductCart> product;
    int quantity, price, finalPrice, originalPrice, totalPrice;
    int total = 0;

    //Constructor
    public CartAdapter(CartActivity activity, int item_layout, List<ProductCart> product) {
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
        return product.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CartAdapter.ViewHolder holder;
        if(convertView ==null){
            //Link View
            holder = new CartAdapter.ViewHolder();

            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(item_layout,null);

            //Ánh xạ
            holder.imgProduct = convertView.findViewById(R.id.img_product);
            holder.proName = convertView.findViewById(R.id.txt_ProductName);
            holder.proType = convertView.findViewById(R.id.txt_ProductType);
            holder.proPrice = convertView.findViewById(R.id.txt_ProductPrice);
            holder.proColor = convertView.findViewById(R.id.txt_ProductColor);
            holder.proNumber = convertView.findViewById(R.id.txt_NumberInCart);
            holder.btnDelete = convertView.findViewById(R.id.btn_deleteCart);
            holder.btnPlus = convertView.findViewById(R.id.btn_plus);
            holder.btnMinus = convertView.findViewById(R.id.btn_minus);
            holder.chkSelect = convertView.findViewById(R.id.chk_select);
            holder.cvProductColor = convertView.findViewById(R.id.cvProductColor);

            convertView.setTag(holder);
        }else{
            holder = (CartAdapter.ViewHolder) convertView.getTag();
        }

        //Gán giá trị
        ProductCart p = product.get(position);
        holder.imgProduct.setImageResource(p.getProductThumb());
        holder.proName.setText(p.getProductName());
        holder.proType.setText(p.getProductType());
        holder.proPrice.setText(String.valueOf(p.getProductPrice()));
        holder.proColor.setText(p.getProductColor());
        holder.proNumber.setText(String.valueOf(p.getProductQuantity()));

        //Gán Số lượng, Tiền vào biến
        quantity = p.getProductQuantity();
        price = p.getProductPrice();
        originalPrice = price / quantity;


        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DialogDelete(p);
            }
        });

        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.btnPlus.getId() == R.id.btn_plus){
                    quantity += 1;
                }
                holder.proNumber.setText(Integer.toString(quantity));
                finalPrice = quantity * originalPrice;
                holder.proPrice.setText(String.valueOf(finalPrice));
            }
        });

        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.btnMinus.getId() == R.id.btn_minus){
                    if (quantity > 1) {
                        quantity -= 1;
                    }
                }
                holder.proNumber.setText(Integer.toString(quantity));
                finalPrice = quantity * originalPrice;
                holder.proPrice.setText(String.valueOf(finalPrice));
            }
        });

//        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int sum = 0, i;
//                if(holder.btnPlus.getId() == R.id.btn_plus){
//                int qnt = product.get(position).getProductQuantity();
//                qnt ++;
//                product.get(position).setProductQuantity(qnt);
//                //Tính tổng tiền
//                    for(i=0; i< product.size(); i++){
//                        sum += product.get(i).getProductPrice() * product.get(i).getProductQuantity();
//                    }
//                }
//                holder.proPrice.setText(String.valueOf(sum));
//                activity.EventUltils(sum);
//            }
//        });
//
//        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int sum = 0, i;
//                if(holder.btnPlus.getId() == R.id.btn_plus){
//                    int qnt = product.get(position).getProductQuantity();
//                    qnt --;
//                    product.get(position).setProductQuantity(qnt);
//                    //Tính tổng tiền
//                    for(i=0; i< product.size(); i++){
//                        sum += product.get(i).getProductPrice() * product.get(i).getProductQuantity();
//                    }
//                }
//                holder.proPrice.setText(String.valueOf(sum));
//                activity.EventUltils(sum);
//            }
//        });
//        holder.chkSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int sum = 0, i;
//                for(i=0;i<product.size();i++){
//                    sum = sum + (product.get(i).getProductPrice() * product.get(i).getProductQuantity());
//                };
//                activity.EventUltils(sum);
//            }
//        });

//        for(int i = 0; i < product.size(); i++){
//            if(p.get)
//
//        }


//        holder.chkSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(!(isChecked)){
//                    for(int i = 0; i < product.size(); i++){
//                        total += finalPrice;
//                    }
//                    activity.EventUltils(total);
//                } else {
//                    total -= finalPrice;
//                    activity.EventUltils(total);
//                }
//            }
//        });


//        holder.chkSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                    activity.EventUltils(finalPrice);
//            }
//        });

//        holder.chkSelect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int sum = 0, i;
//                for(i=0;i<product.size();i++)
//                    sum = sum + (product.get(i).getProductPrice() * product.get(i).getProductQuantity());
//                    activity.EventUltils(sum);
//            }
//        });

//        holder.chkSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//
//
//            }
//        });

        holder.cvProductColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.DialogColor(p);
            }
        });


        return convertView;
    }

//    public void updatePrice(){
//        int sum = 0, i;
//        for(i=0; i< product.size(); i++){
//            sum += product.get(i).getProductPrice() * product.get(i).getProductQuantity();
//        }
//
//    }





    public static class ViewHolder {
        ImageView imgProduct;
        TextView proName, proType, proPrice, proColor, proNumber;
        ImageButton btnDelete, btnPlus, btnMinus;
        CheckBox chkSelect;
        MaterialCardView cvProductColor;
    }
}