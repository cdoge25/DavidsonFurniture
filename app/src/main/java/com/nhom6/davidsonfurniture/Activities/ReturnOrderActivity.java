package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.nhom6.davidsonfurniture.R;

public class ReturnOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_order);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}