package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.nhom6.davidsonfurniture.Adapters.ProductAdapter;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityNewProductBinding;

import java.util.ArrayList;

public class NewProductActivity extends AppCompatActivity {

    ActivityNewProductBinding binding;
    ProductAdapter adapter;
    ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_new_product);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        binding = ActivityNewProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        loadData();
        addEvent();
    }

    private void addEvent() {
        binding.gvNewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NewProductActivity.this, MainActivity.class);
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
        productList.add(new Product(R.drawable.img_sofabang_alice, "ALICE", "Sofa Bằng", "4.7", 4500000));
        productList.add(new Product(R.drawable.img_ghelamviec_qile, "QILE", "Ghế làm việc", "4.7", 1590000));
        productList.add(new Product(R.drawable.img_bancafe_luki, "LUKI", "Bàn Cafe", "4.7", 1350000));
        productList.add(new Product(R.drawable.img_banan_honey,"HONEY", "Bàn ăn", "4.7", 2250000));
        productList.add(new Product(R.drawable.img_giuongngu_lullaby, "LULLABY", "Giường gỗ", "4.7", 10500000));
        productList.add(new Product(R.drawable.img_guongdeban_coba, "COBA", "Gương để bàn", "4.7", 1220000));
        productList.add(new Product(R.drawable.img_guongtoanthan_patax, "PATAX", "Gương toàn thân", "4.7",2690000));
        productList.add(new Product(R.drawable.img_guongtoanthan_tama, "TAMA", "Gương toàn thân", "4.7",2690000));

        adapter = new ProductAdapter(NewProductActivity.this, R.layout.item_product,  productList);
        binding.gvNewProduct.setAdapter(adapter);

    }
}