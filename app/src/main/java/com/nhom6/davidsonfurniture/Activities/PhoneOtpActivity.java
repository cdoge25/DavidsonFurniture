package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityPhoneOtpBinding;
import com.nhom6.davidsonfurniture.databinding.ActivityRegister2Binding;

public class PhoneOtpActivity extends AppCompatActivity {

    ActivityPhoneOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_phone_otp);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        binding = ActivityPhoneOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        closeScreen();
    }

    private void closeScreen() {
        binding.btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhoneOtpActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}