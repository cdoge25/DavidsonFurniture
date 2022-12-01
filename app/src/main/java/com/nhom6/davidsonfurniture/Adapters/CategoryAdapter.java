package com.nhom6.davidsonfurniture.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//import com.squareup.picasso.Picasso;
import com.nhom6.davidsonfurniture.Models.CategoryProduct;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<CategoryProduct> dataList;

    public CategoryAdapter(Context context, int layout, ArrayList<CategoryProduct> dataList) {
        this.context = context;
        this.layout = layout;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder{
        TextView txtName;
        ImageView imvImage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(layout,null);
            holder= new ViewHolder();
            holder.imvImage= convertView.findViewById(R.id.imvThumb);
            holder.txtName= convertView.findViewById(R.id.txtName);
            convertView.setTag(holder);
        }
        else{
            holder= (ViewHolder) convertView.getTag();
        }
        CategoryProduct data= dataList.get(position);
        //Picasso.get().load(data.getProductThumb()).into(holder.imvImage);
        holder.txtName.setText(data.getProductName());
        return convertView;
    }
}
