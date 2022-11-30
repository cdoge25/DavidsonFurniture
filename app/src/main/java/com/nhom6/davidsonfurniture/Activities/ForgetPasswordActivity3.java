package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityForgetPassword2Binding;
import com.nhom6.davidsonfurniture.databinding.ActivityForgetPassword3Binding;
import com.nhom6.davidsonfurniture.databinding.ActivityForgetPasswordBinding;

public class ForgetPasswordActivity3 extends AppCompatActivity {

    ActivityForgetPassword3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
//        setContentView(R.layout.activity_forget_password2);
        binding = ActivityForgetPassword3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toLogin();
    }

    private void toLogin() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgetPasswordActivity3.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}