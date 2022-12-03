package com.nhom6.davidsonfurniture.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
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
import com.nhom6.davidsonfurniture.Models.ProductCart;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityDetailProductBinding;
import com.nhom6.davidsonfurniture.databinding.ActivityNewProductBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailProductActivity extends AppCompatActivity {


    ActivityDetailProductBinding binding;
    DetailProductAdapter adapter;
    ArrayList<DetailProduct> productList;
   Toolbar toolbar;
    ImageButton imbAdd, imbSubtract;
    int quantity = 1;
    TextView txtQuantity;

    int image_url;
    String name, type, price, color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_new_product);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        binding = ActivityDetailProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        showData();

        toFeedback();

        adjustQuantity();

        addToCart();

    }

    @SuppressLint("SetTextI18N")
    private void showData() {

        Intent intent = getIntent();
        binding.imvProductDetailThumb.setImageResource(intent.getIntExtra("Image", 0));
        binding.txtProductName.setText(intent.getStringExtra("Name"));
        binding.txtProductCategory.setText(intent.getStringExtra("Category"));
        binding.txtProductPrice.setText(String.valueOf(intent.getIntExtra("Price", 0)));
        binding.txtRate.setText(intent.getStringExtra("Rate"));

        //Get intent for passing
        image_url = intent.getIntExtra("Image",0);
        name = intent.getStringExtra("Name");
        type = intent.getStringExtra("Category");
        price = String.valueOf(intent.getIntExtra("Price", 0));
//                String color
    }


    private void addToCart() {
        binding.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailProductActivity.this, "Đã thêm sản phẩm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailProductActivity.this, CartActivity.class);

                intent.putExtra("name",name);
                intent.putExtra("image",image_url);
                intent.putExtra("type",type);
                intent.putExtra("price",price);
//                intent.putExtra("color",color);
                startActivity(intent);
            }
        });
    }


    private void adjustQuantity() {

        ImageButton imbAdd = findViewById(R.id.imbAdd);
        ImageButton imbSubtract = findViewById(R.id.imbSubtract);
        TextView txtQuantity = findViewById(R.id.txtProductQuantity);

        imbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imbAdd.getId() == R.id.imbAdd) {
                    quantity += 1;
                }
                txtQuantity.setText(Integer.toString(quantity));
            }
        });

        imbSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imbSubtract.getId() == R.id.imbSubtract) {
                    if (quantity > 1) {
                        quantity -= 1;
                    } else {
                        Toast.makeText(DetailProductActivity.this, "Số lượng sản phẩm phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
                    }
                }
                txtQuantity.setText(Integer.toString(quantity));
            };
        });
    }

    private void toFeedback() {
            binding.btnSeeReview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(DetailProductActivity.this, FeedbackProductActivity.class);
                    startActivity(i);
                }
            });
        }

}


