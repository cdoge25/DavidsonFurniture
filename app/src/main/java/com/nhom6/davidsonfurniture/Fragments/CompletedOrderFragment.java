package com.nhom6.davidsonfurniture.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Adapters.CompletedOrderAdapter;
import com.nhom6.davidsonfurniture.Models.CompletedOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;
import java.util.List;

public class CompletedOrderFragment extends Fragment {

    RecyclerView rcvCompleted;
    CompletedOrderAdapter completedAdapter;

    public CompletedOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_completed_order, container, false);
        rcvCompleted = view.findViewById(R.id.rcvCompleted);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcvCompleted.setLayoutManager(manager);
        rcvCompleted.setHasFixedSize(true);
        rcvCompleted.setItemAnimator(new DefaultItemAnimator());

        completedAdapter = new CompletedOrderAdapter(getContext(),initData());
        rcvCompleted.setAdapter(completedAdapter);
        return view;
    }

    private List<CompletedOrder> initData() {
        List<CompletedOrder> completedOrders = new ArrayList<>();
        completedOrders.add(new CompletedOrder(R.drawable.img_sofabang_anastasia, "ANASTASIA", "Sofa băng", "Đen", 8450000, 1, "DF887654320", 0));
        completedOrders.add(new CompletedOrder(R.drawable.img_guongdeban_coba, "COBA", "Gương để bàn", "Đen", 1220000, 1, "DF857654320", 1));
        completedOrders.add(new CompletedOrder(R.drawable.img_kedungdo_ez, "PAMITI", "Kệ đựng đồ", "Trắng", 1220000, 1, "DF867654320", 1));
        return completedOrders;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(completedAdapter != null){
            completedAdapter.release();
        }
    }
}