package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nhom6.davidsonfurniture.Adapters.ProductOrderAdapter;
import com.nhom6.davidsonfurniture.Models.ProductOrder;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    ProductOrderAdapter adapter;
    ArrayList<ProductOrder> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_order);

        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
        //Init Data
        orderList = new ArrayList<>();
        orderList.add(new ProductOrder("LUKI","Bàn cafe","Đen",
                "1000000","2",R.drawable.img_bancafe_luki));
        orderList.add(new ProductOrder("MBINAS","Bàn trang điểm","Xám",
                "2000000","1",R.drawable.img_bantrangdiem_mbinas));
        orderList.add(new ProductOrder("NOVEN","Ghế ăn","Vàng",
                "200000","4",R.drawable.img_ghean_noven));

        //Init Adapter
        adapter = new ProductOrderAdapter(this,R.layout.item_productorder,orderList);
        binding.lvProductOrder.setAdapter(adapter);

    }
}