package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;

import com.nhom6.davidsonfurniture.Adapters.ProductCartAdapter;
import com.nhom6.davidsonfurniture.Models.ProductInfor;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    ProductCartAdapter adapter;
    ArrayList<ProductInfor> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart);

        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        binding.navApp.setSelectedItemId(R.id.navCart);
        navigationClick();


        loadData();
    }

    private void navigationClick() {
        binding.navApp.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.navHome:
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.navCart:
                    return true;
                case R.id.navOrder:
                    startActivity(new Intent(getApplicationContext(),OrderStatusActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.navAccount:
                    startActivity(new Intent(getApplicationContext(),AccountActivity.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
    }

    private void loadData() {
          productList = new ArrayList<>();
//        productList.add(new ProductInfor(R.drawable.img_bantrangdiem_mbinas,"MBINAS",
//                "bàn trang điểm",5000000,1,false));
//        productList.add(new ProductInfor(R.drawable.img_bancafe_luki,"LUKI",
//                "bàn cafe",4000000,2,false));
//        productList.add(new ProductInfor(R.drawable.img_ghean_noven,"NOVEN",
//                "ghế ăn",300000,0,false));
        productList.add(new ProductInfor(R.drawable.img_ghean_noven,"NOVEN",
                "Bàn trang điểm",9000000));
        productList.add(new ProductInfor(R.drawable.img_bancafe_luki,"LUKI",
                "Bàn cafe",10000000));
        productList.add(new ProductInfor(R.drawable.img_banan_honey,"HONEY",
                "Bàn ăn",10000000));
        productList.add(new ProductInfor(R.drawable.img_bancafe_mushroom,"MUSHROOM",
                "Bàn cafe",500000));

        adapter = new ProductCartAdapter(this,R.layout.item_productcart,productList);
        binding.lvProductCart.setAdapter(adapter);
    }
}