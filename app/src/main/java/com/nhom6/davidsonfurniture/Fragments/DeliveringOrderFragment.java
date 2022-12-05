package com.nhom6.davidsonfurniture.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Adapters.DeliveringOrderAdapter;
import com.nhom6.davidsonfurniture.Models.DeliveringOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;
import java.util.List;

public class DeliveringOrderFragment extends Fragment {

    RecyclerView rcvDelivering;
    DeliveringOrderAdapter deliveringAdapter;

    public DeliveringOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivering_order, container, false);
        rcvDelivering = view.findViewById(R.id.rcvDelivering);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcvDelivering.setLayoutManager(manager);
        rcvDelivering.setHasFixedSize(true);
        rcvDelivering.setItemAnimator(new DefaultItemAnimator());

        deliveringAdapter = new DeliveringOrderAdapter(getContext(),initData());
        rcvDelivering.setAdapter(deliveringAdapter);

        return view;
    }

    private List<DeliveringOrder> initData() {
        List<DeliveringOrder> deliveringOrders = new ArrayList<>();
        deliveringOrders.add(new DeliveringOrder(R.drawable.img_bantrangdiem_mbinas, "MBINAS", "Bàn trang điểm", "Đen", 2750000, 1, "DF234567891"));
        deliveringOrders.add(new DeliveringOrder(R.drawable.img_sofabang_aurora, "AURORA", "Sofa giường", "Be", 3290000, 2, "DF234567892"));
        return deliveringOrders;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(deliveringAdapter != null){
            deliveringAdapter.release();
        }
    }
}