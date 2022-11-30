package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityRegister2Binding;
import com.nhom6.davidsonfurniture.databinding.ActivityRegisterBinding;

public class RegisterActivity2 extends AppCompatActivity {

    ActivityRegister2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        binding = ActivityRegister2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toLogin();
    }

    private void toLogin() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (RegisterActivity2.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}