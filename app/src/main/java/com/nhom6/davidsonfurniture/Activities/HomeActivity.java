package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.nhom6.davidsonfurniture.Adapters.HomeNewAdapter;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    HomeNewAdapter homeNewAdapter;
    ArrayList<SlideModel> slideModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navApp.setSelectedItemId(R.id.navHome);
        navigationClick();

        loadBanners();
        loadNewData();

        toNotification();
        toNewProduct();
        toPopularProduct();
        toSofa();
    }

    private void loadBanners() {
        slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.img_banner_ez, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_banner_doclap, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img_banner_hobu, ScaleTypes.FIT));

        binding.imsSliderBanner.setImageList(slideModels, ScaleTypes.FIT);
    }

    private void loadNewData() {
        binding.rvNewProduct.setHasFixedSize(true);
        binding.rvNewProduct.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(R.drawable.img_sofabang_alice, "ALICE", "Sofa băng", "4.7", 4500000));
        products.add(new Product(R.drawable.img_ghelamviec_qile, "QILE", "Ghế làm việc", "4.7", 1590000));
        products.add(new Product(R.drawable.img_bancafe_luki, "LUKI", "Bàn Cafe", "4.7", 1350000));
        products.add(new Product(R.drawable.img_banan_honey,"HONEY", "Bàn ăn", "4.7", 2250000));

        homeNewAdapter = new HomeNewAdapter(products);
        binding.rvNewProduct.setAdapter(homeNewAdapter);
    }

    private void navigationClick() {
        binding.navApp.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.navHome:
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
                    startActivity(new Intent(getApplicationContext(),AccountActivity.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
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
        binding.llSofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, CategoriesProductActivity.class);
                startActivity(i);
            }
        });
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
}