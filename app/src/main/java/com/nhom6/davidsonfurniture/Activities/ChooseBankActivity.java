package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.nhom6.davidsonfurniture.Adapters.BankAdapter;
import com.nhom6.davidsonfurniture.Models.Bank;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityChooseBankBinding;

import java.util.ArrayList;

public class ChooseBankActivity extends AppCompatActivity {
    ActivityChooseBankBinding binding;
    BankAdapter adapter;
    ArrayList<Bank> bankList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_choose_bank);

        binding = ActivityChooseBankBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadData();

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }

    private void loadData() {
        bankList = new ArrayList<>();
        bankList.add(new Bank(R.drawable.img_bank_acb,"ACB - Ngân hàng ACB"));
        bankList.add(new Bank(R.drawable.img_bank_agribank,"Agribank - Ngân hàng Nông Nghiệp"));
        bankList.add(new Bank(R.drawable.img_bank_bidv,"BIDV - Ngân hàng đầu tư và phát triển"));
        bankList.add(new Bank(R.drawable.img_bank_dongabank,"Đông Á Bank - Ngân hàng Đông Á"));
        bankList.add(new Bank(R.drawable.img_bank_eximbank,"Eximbank - Ngân hàng Eximbank"));
        bankList.add(new Bank(R.drawable.img_bank_hdbank,"HDBank - Ngân hàng HDBank"));
        bankList.add(new Bank(R.drawable.img_bank_mbbank,"MBBank - Ngân hàng Quân Đội "));
        bankList.add(new Bank(R.drawable.img_bank_ocb,"OCB - Ngân hàng Phương Đông"));
        bankList.add(new Bank(R.drawable.img_bank_viettinbank,"Viettin Bank - Ngân hàng Công Thương"));

        //Init Adapter
        adapter = new BankAdapter(ChooseBankActivity.this, R.layout.item_bank, bankList);
        binding.lvBank.setAdapter(adapter);


        //Dialog
        binding.lvBank.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent a = new Intent(ChooseBankActivity.this, PaymentMethodActivity.class);
                startActivity(a);
            }
        });
    }
}