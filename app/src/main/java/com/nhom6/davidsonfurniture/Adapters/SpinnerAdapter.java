package com.nhom6.davidsonfurniture.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nhom6.davidsonfurniture.Models.SpinnerPrice;
import com.nhom6.davidsonfurniture.R;

import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<SpinnerPrice> {
    public SpinnerAdapter(@NonNull Context context, int resource, @NonNull List<SpinnerPrice> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_selected_spinner,parent,false);
        TextView Selected = convertView.findViewById(R.id.txt_Selected);

        SpinnerPrice spinnerPrice = this.getItem(position);
        if ( spinnerPrice != null) {
            Selected.setText(spinnerPrice.getPrice());
        }
        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spinner_price, parent, false);
        TextView ItemSpinner = convertView.findViewById(R.id.txt_ItemSpinner);

        SpinnerPrice spinnerPrice = this.getItem(position);
        if ( spinnerPrice != null) {
            ItemSpinner.setText(spinnerPrice.getPrice());
        }
        return convertView;
    }
}
