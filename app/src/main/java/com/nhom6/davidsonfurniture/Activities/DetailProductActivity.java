package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.nhom6.davidsonfurniture.Adapters.DetailProductAdapter;
import com.nhom6.davidsonfurniture.Adapters.ProductAdapter;
import com.nhom6.davidsonfurniture.Constants.Constant;
import com.nhom6.davidsonfurniture.Models.DetailProduct;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityDetailProductBinding;
import com.nhom6.davidsonfurniture.databinding.ActivityNewProductBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailProductActivity extends AppCompatActivity {


    ActivityDetailProductBinding binding;
    DetailProductAdapter adapter;
    ArrayList<DetailProduct> productList;

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

    binding = ActivityDetailProductBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    Intent intent = getIntent();

    loadData();
    addEvent();
}

    private void addEvent() {
        binding.svOrderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent intent = new Intent(DetailProductActivity.this, MainActivity.class);
//                intent.putExtra("Name", productList.get(i).getProductName());
//                intent.putExtra("Image", productList.get(i).getProductThumb());
//                intent.putExtra("Price", productList.get(i).getProductPrice());
//                intent.putExtra("Rate", productList.get(i).getProductRate());
//                intent.putExtra("Category", productList.get(i).getProductCategory());
//                intent.putExtra("Size", productList.get(i).getProductSize());
//                intent.putExtra("Material", productList.get(i).getProductMaterial());
//                startActivity(intent);
            }
        });

    }
    private void loadData() {
        productList = new ArrayList<>();
//        productList.add(new Product(R.drawable.img_sofabang_alice, "ALICE", "Sofa Bằng", "4.7", 4500000));
//        productList.add(new Product(R.drawable.img_ghelamviec_qile, "QILE", "Ghế làm việc", "4.7", 1590000));
//        productList.add(new Product(R.drawable.img_bancafe_luki, "LUKI", "Bàn Cafe", "4.7", 1350000));
//        productList.add(new Product(R.drawable.img_banan_honey,"HONEY", "Bàn ăn", "4.7", 2250000));
//        productList.add(new Product(R.drawable.img_giuongngu_lullaby, "LULLABY", "Giường gỗ", "4.7", 10500000));
//        productList.add(new Product(R.drawable.img_guongdeban_coba, "COBA", "Gương để bàn", "4.7", 1220000));
//        productList.add(new Product(R.drawable.img_guongtoanthan_patax, "PATAX", "Gương toàn thân", "4.7",2690000));
//        productList.add(new Product(R.drawable.img_guongtoanthan_tama, "TAMA", "Gương toàn thân", "4.7",2690000));

//        adapter = new ProductAdapter(DetailProductActivity.this, R.layout.item_product,  productList);
//        binding.svOrderDetails.setAdapter(adapter);

    }
}