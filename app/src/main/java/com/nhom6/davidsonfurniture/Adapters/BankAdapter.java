package com.nhom6.davidsonfurniture.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Models.Bank;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class BankAdapter extends BaseAdapter {
    Activity activity;
    int item_layout;
    List<Bank> bankList;

    //Constructor

    public BankAdapter(Activity activity, int item_layout, List<Bank> bankList) {
        this.activity = activity;
        this.item_layout = item_layout;
        this.bankList = bankList;
    }

    @Override
    public int getCount() {
        return bankList.size();
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
            //Link view
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            //Ánh xạ
            holder.imv_bankAva = view.findViewById(R.id.bank_ava);
            holder.txt_bankName = view.findViewById(R.id.txt_bankName);

            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }

        //Gán giá trị
        Bank b = bankList.get(i);
        holder.imv_bankAva.setImageResource(b.getImageBank());
        holder.txt_bankName.setText(b.getBankName());

        return view;
    }

    public static class ViewHolder {
        ImageView imv_bankAva;
        TextView txt_bankName;
    }
}
