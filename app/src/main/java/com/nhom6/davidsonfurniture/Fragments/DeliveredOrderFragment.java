package com.nhom6.davidsonfurniture.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Adapters.DeliveredOrderAdapter;
import com.nhom6.davidsonfurniture.Models.DeliveredOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;
import java.util.List;

public class DeliveredOrderFragment extends Fragment {

    RecyclerView rcvDelivered;
    DeliveredOrderAdapter deliveredAdapter;

    public DeliveredOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivered_order, container, false);
        rcvDelivered = view.findViewById(R.id.rcvDelivered);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcvDelivered.setLayoutManager(manager);
        rcvDelivered.setHasFixedSize(true);
        rcvDelivered.setItemAnimator(new DefaultItemAnimator());

        deliveredAdapter = new DeliveredOrderAdapter(getContext(),initData());
        rcvDelivered.setAdapter(deliveredAdapter);

        return view;
    }

    private List<DeliveredOrder> initData() {
        List<DeliveredOrder> deliveredOrders = new ArrayList<>();
        deliveredOrders.add(new DeliveredOrder(R.drawable.img_banan_honey, "DALAT", "Bàn ăn", "Đen", 4500000, 1, "DF987654320"));
        deliveredOrders.add(new DeliveredOrder(R.drawable.img_sofabang_alice, "ALICE", "Sofa băng", "Xám", 9000000, 2,"DF987654321"));
        return deliveredOrders;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(deliveredAdapter != null){
            deliveredAdapter.release();
        }
    }
}