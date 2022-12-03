package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Toolbar;

import com.nhom6.davidsonfurniture.Adapters.ProductAdapter;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityPopularProductBinding;

import java.util.ArrayList;

public class PopularProductActivity extends AppCompatActivity {

    ActivityPopularProductBinding binding;
    ProductAdapter adapter;
    ArrayList<Product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_popular_product);

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

        binding = ActivityPopularProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        loadData();

        addEvent();

        goBack();
    }

    private void goBack() {
        binding.toolbarPopularProduct.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void addEvent() {
        binding.gvPopularProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PopularProductActivity.this, DetailProductActivity.class);
                intent.putExtra("Name", productList.get(i).getProductName());
                intent.putExtra("Image", productList.get(i).getProductThumb());
                intent.putExtra("Price", productList.get(i).getProductPrice());
                intent.putExtra("Rate", productList.get(i).getProductRate());
                intent.putExtra("Category", productList.get(i).getProductCategory());
                startActivity(intent);
            }
        });

    }
    private void loadData() {
        productList = new ArrayList<>();
        productList.add(new Product(R.drawable.img_sofabang_anastasia,"ANASTASIA", "Sofa Bằng", "4.7", 8500000));
        productList.add(new Product(R.drawable.img_banan_honey,"HONEY", "Bàn ăn", "4.7", 2859000));
        productList.add(new Product(R.drawable.img_banlamviec_builder,"BUILDER", "Bàn làm việc", "4.7", 1350000));
        productList.add(new Product(R.drawable.img_nemngoi_candy,"CANDY", "Nệm ngồi", "4.7", 10500000));
        productList.add(new Product(R.drawable.img_ttdongho_king,"KING", "Đồng hồ", "4.7", 8990000));
        productList.add(new Product(R.drawable.img_ttdongho_queen,"QUEEN", "Đồng hồ", "4.7", 799000));
        productList.add(new Product(R.drawable.img_guongtoanthan_patax,"PATAX", "Gương toàn thân", "4.7",2690000));
        productList.add(new Product(R.drawable.img_guongtoanthan_tama,"TAMA", "Gương toàn thân", "4.7",2690000));

        adapter = new ProductAdapter(PopularProductActivity.this, R.layout.item_product,  productList);
        binding.gvPopularProduct.setAdapter(adapter);
    }
}