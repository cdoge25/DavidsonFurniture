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

import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityPaymentMethodBinding;

public class PaymentMethodActivity extends AppCompatActivity {
    ActivityPaymentMethodBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_payment_method);

        binding = ActivityPaymentMethodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //full screen
//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        loadData();
        Events();

        //hide status and action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        binding.toolbarPaymentMethod.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

    private void Events() {
        //Nhận data từ Intent
        Intent intent = getIntent();
        int imagebank = intent.getIntExtra("image",0);
        String bankname = intent.getStringExtra("name");
        binding.imvChosenBank.setImageResource(imagebank);
        binding.txtChosenBank.setText(bankname);

    }

    private void loadData() {
        binding.btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogSuccessOrder();
            }
        });

        binding.btnSeeBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(PaymentMethodActivity.this, ChooseBankActivity.class);
                startActivity(a);
            }
        });
    }
    //=============================DIALOG======================
    private void DialogSuccessOrder(){
        //Truyền Dialog
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_successful_order);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //Khai báo các thành phần
        Button btnhomepage, btnviewOrder;

        //Ánh xạ
        btnhomepage = dialog.findViewById(R.id.btn_showHomePage);
        btnviewOrder = dialog.findViewById(R.id.btn_showOrder);

        //Xử lý event
        btnhomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PaymentMethodActivity.this, HomeActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnviewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PaymentMethodActivity.this, OrderStatusActivity.class );
                startActivity(i);
                finish();
            }
        });
    }
}

