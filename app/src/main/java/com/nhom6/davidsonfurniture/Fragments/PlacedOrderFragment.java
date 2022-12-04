package com.nhom6.davidsonfurniture.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Activities.OrderStatusActivity;
import com.nhom6.davidsonfurniture.Models.PlacedOrder;
import com.nhom6.davidsonfurniture.Adapters.PlacedOrderAdapter;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlacedOrderFragment extends Fragment {

    RecyclerView rcvPlaced;
    PlacedOrderAdapter placedAdapter;

    String detailName;
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

        OrderStatusActivity activity = (OrderStatusActivity) getActivity();
        detailName = activity.getDetailName();

        placedAdapter = new PlacedOrderAdapter(getContext(),initData());
        rcvPlaced.setAdapter(placedAdapter);

        return view;
    }
    private List<PlacedOrder> initData() {
        List<PlacedOrder> placedOrders = new ArrayList<>();
        placedOrders.add(new PlacedOrder(1, R.drawable.img_bancafe_luki, "LUKI", "Bàn cafe", "Đen", 1350000, 1, "DF123456789"));
        placedOrders.add(new PlacedOrder(2,R.drawable.img_densan_noti, "NOTI", "Đèn sàn", "Đen", 990000, 2, "DF123456788"));

        if (Objects.equals(detailName, "LUKI")){
            placedOrders.remove(0);
        }
        else if (Objects.equals(detailName, "NOTI")){
            placedOrders.remove(1);
        }
        return placedOrders;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(placedAdapter != null){
            placedAdapter.release();
        }
    }

    public void deleteOrder(int i){
        List<PlacedOrder> placedOrders = new ArrayList<>();
        placedOrders.remove(i);
    }
}

