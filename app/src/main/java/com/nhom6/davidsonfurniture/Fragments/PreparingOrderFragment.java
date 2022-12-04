package com.nhom6.davidsonfurniture.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Adapters.PreparingOrderAdapter;
import com.nhom6.davidsonfurniture.Models.PreparingOrder;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;
import java.util.List;

public class PreparingOrderFragment extends Fragment {

    RecyclerView rcvPreparing;
    PreparingOrderAdapter preparingAdapter;

    public PreparingOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_preparing_order, container, false);
        rcvPreparing = view.findViewById(R.id.rcvPreparing);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcvPreparing.setLayoutManager(manager);
        rcvPreparing.setHasFixedSize(true);
        rcvPreparing.setItemAnimator(new DefaultItemAnimator());

        preparingAdapter = new PreparingOrderAdapter(getContext(),initData());
        rcvPreparing.setAdapter(preparingAdapter);
        return view;
    }

    private List<PreparingOrder> initData() {
        List<PreparingOrder> preparingOrders = new ArrayList<>();
        preparingOrders.add(new PreparingOrder(R.drawable.img_bancafe_mushroom, "MUSHROOM", "Bàn cafe", "Đen", 3750000, 1, "DF123456785"));
        preparingOrders.add(new PreparingOrder(R.drawable.img_densan_logly, "LOGLY", "Đèn sàn", "Đen", 990000, 1, "DF123456785"));
        return preparingOrders;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(preparingAdapter != null){
            preparingAdapter.release();
        }
    }
}