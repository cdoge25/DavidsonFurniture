package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityForgetPassword2Binding;

public class ForgetPasswordActivity2 extends AppCompatActivity {

    ActivityForgetPassword2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
//        setContentView(R.layout.activity_forget_password2);
        binding = ActivityForgetPassword2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        moveBack();
        toForget3();
    }

    private void moveBack() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPasswordActivity2.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toForget3() {
        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPasswordActivity2.this, ForgetPasswordActivity3.class);
                startActivity(intent);
            }
        });
    }
}