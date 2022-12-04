package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityAccountBinding;
import com.nhom6.davidsonfurniture.databinding.ActivityHomeBinding;

public class AccountActivity extends AppCompatActivity {

    ActivityAccountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_account);

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



        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navApp.setSelectedItemId(R.id.navAccount);
        navigationClick();

        toSettingAccount();
        toVoucher();
        toChangeLanguage();
        toCustomerService();
        toContact();
        toLogout();
        goback();
    }

    private void toLogout() {


        binding.llLogout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Dialog dialog = new Dialog(AccountActivity.this);
            dialog.setContentView(R.layout.dialog_logout);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            Button btnCanCelLogout = dialog.findViewById(R.id.btn_CancelLogout);
            btnCanCelLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            Button btnConfirmLogout = dialog.findViewById(R.id.btn_ConfirmLogout);
            btnConfirmLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AccountActivity.this, MainActivity.class);
                    startActivity(intent);
                    //đổ dữ liệu sang màn hình lịch sử và xóa data bên này
                    dialog.dismiss();
                }
            });
            dialog.show();
        }
    });
    }

    private void toContact() {
        binding.llContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, CustomerServiceActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toCustomerService() {
        binding.llCustomerService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, CustomerServiceActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toChangeLanguage() {
        binding.llChangeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, ChangeLanguageActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toVoucher() {
        binding.llVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, VoucherActivity.class);
                startActivity(intent);
            }
        });
    }

    private void goback() {
        binding.toolbarAccount.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void toSettingAccount() {
        binding.llSettingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccountActivity.this, SettingAccountActivity.class);
                startActivity(intent);
            }
        });
    }

    private void navigationClick() {
        binding.navApp.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.navHome:
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.navCart:
                    startActivity(new Intent(getApplicationContext(),CartActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.navOrder:
                    startActivity(new Intent(getApplicationContext(),OrderStatusActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.navAccount:
                    return true;
            }
            return false;
        });
    }
}