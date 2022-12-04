package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.nhom6.davidsonfurniture.databinding.ActivitySettingAccountBinding;

public class SettingAccountActivity extends AppCompatActivity {

    ActivitySettingAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_setting_account);

        //hide status and action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        binding = ActivitySettingAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toPersonalInfo();
        toChangeEmail();
        toChangeNumberPhone();
        toChangePassword();
        toAddress();

        goback();
    }

    private void toAddress() {
        binding.llAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingAccountActivity.this, ChangeAddressActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toChangePassword() {
        binding.llChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingAccountActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toChangeNumberPhone() {
        binding.llChangeNumberPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingAccountActivity.this, ChangeNumberPhoneActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toChangeEmail() {
        binding.llChangeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingAccountActivity.this, ChangeEmailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toPersonalInfo() {
        binding.llPersonalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingAccountActivity.this, PersonalInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void goback() {
        binding.toolbarSettingAccount.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}