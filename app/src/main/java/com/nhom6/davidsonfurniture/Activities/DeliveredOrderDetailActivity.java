package com.nhom6.davidsonfurniture.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nhom6.davidsonfurniture.R;

public class DeliveredOrderDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered_order_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}