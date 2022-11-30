package com.nhom6.davidsonfurniture.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Models.PlacedOrder;
import com.nhom6.davidsonfurniture.Adapters.PlacedOrderAdapter;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;
import java.util.List;

public class PlacedOrderFragment extends Fragment {

    RecyclerView rcvPlaced;
    PlacedOrderAdapter placedAdapter;

    public PlacedOrderFragment() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_placed_order, container, false);
        rcvPlaced = view.findViewById(R.id.rcvPlaced);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcvPlaced.setLayoutManager(manager);
        rcvPlaced.setHasFixedSize(true);
        rcvPlaced.setItemAnimator(new DefaultItemAnimator());

        placedAdapter = new PlacedOrderAdapter(getContext(),initData());
        rcvPlaced.setAdapter(placedAdapter);
        return view;
    }

    private List<PlacedOrder> initData() {
        List<PlacedOrder> placedOrders = new ArrayList<>();
        placedOrders.add(new PlacedOrder(R.drawable.img_bancafe_luki, "LUKI", "Bàn cafe", "Đen", "1,350,000đ", "Số lượng: 1"));
        placedOrders.add(new PlacedOrder(R.drawable.img_densan_noti, "NOTI", "Đèn sàn", "Đen", "990,000đ", "Số lượng: 2"));
        return placedOrders;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(placedAdapter != null){
            placedAdapter.release();
        }
    }
}

