package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nhom6.davidsonfurniture.Adapters.PlacedOrderAdapter;
import com.nhom6.davidsonfurniture.Models.PlacedOrder;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityPlacedOrderBinding;

import java.util.ArrayList;

public class PlacedOrderActivity extends AppCompatActivity {

    ActivityPlacedOrderBinding binding;
    PlacedOrderAdapter adapter;
    ArrayList<PlacedOrder> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_placed_order);

        //nạp giao diện ứng với màn hình
        binding = ActivityPlacedOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData(){
        //init data
        orderList = new ArrayList<>();
        orderList.add(new PlacedOrder(R.drawable.img_bancafe_luki,"LUKI","Bàn cafe","Đen","1,350,000đ","Số lượng: 1"));
        orderList.add(new PlacedOrder(R.drawable.img_densan_noti,"NOTI","Đèn sàn","Đen","990,000đ","Số lượng: 2"));

        //init adapter
        adapter = new PlacedOrderAdapter(PlacedOrderActivity.this, R.layout.item_placed_order, orderList);
        binding.lvOrder.setAdapter(adapter);
    }
}