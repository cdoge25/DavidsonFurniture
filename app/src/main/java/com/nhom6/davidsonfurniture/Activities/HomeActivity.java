package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.nhom6.davidsonfurniture.Adapters.ProductAdapter;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    ProductAdapter adapter;
    ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//        }
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toNotification();
        toNewProduct();
        toPopularProduct();
        toSofa();

        loadNewProduct();
    }


    private void toNotification() {
        binding.btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toSofa() {
    }

    private void toNewProduct() {
        binding.btnViewAllNewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NewProductActivity.class);
                startActivity(intent);
            }
        });
    }

    private void toPopularProduct() {
        binding.btnViewAllPopularProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, PopularProductActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadNewProduct() {
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.img_sofabang_alice, "ALICE", "Sofa Bằng", "4.7", 4500000));
        productList.add(new Product(R.drawable.img_ghelamviec_qile, "QILE", "Ghế làm việc", "4.7", 1590000));
        productList.add(new Product(R.drawable.img_bancafe_luki, "LUKI", "Bàn Cafe", "4.7", 1350000));
        productList.add(new Product(R.drawable.img_banan_honey,"HONEY", "Bàn ăn", "4.7", 2250000));

        adapter = new ProductAdapter(HomeActivity.this, R.layout.item_new_product,  productList);
        binding.lvNewProduct.setAdapter(adapter);
    }
}