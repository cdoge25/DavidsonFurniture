package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toolbar;

import com.nhom6.davidsonfurniture.Adapters.ProductAdapter;
import com.nhom6.davidsonfurniture.Adapters.ProductCategoryAdapter;
import com.nhom6.davidsonfurniture.Interfaces.OnClickInterface;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityCategoriesProductBinding;

import java.util.ArrayList;

public class CategoriesProductActivity extends AppCompatActivity {

    ActivityCategoriesProductBinding binding;
    ProductAdapter adapter;
    ArrayList<Product> productList;

    String[] items={"Tất cả", "Dưới 1 triệu", "Từ 1-5 triệu", "Từ 5-10 triệu", "Trên 10 triệu"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter <String> adapterItems;

    //TextView txtCategoryName;
//    Spinner spinnerCategory;

     String[] price = {"Tất cả","Dưới 1.000.000","Từ 1.000.000 đến 5.000.000","Từ 5.000.000 đến 10.000.000","Từ 10. 000.000 trở lên"};

   ArrayList<Product>products;
    GridView gvCategoryProduct;
    OnClickInterface onClickInterface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_categories_product)

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
        

        binding = ActivityCategoriesProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        loadData();
        addEvent();
        FilterPrice();
        goBack();
        toDetail();
    }

    private void toDetail() {
        binding.gvCategoryProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CategoriesProductActivity.this, DetailProductActivity.class);
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
        productList.add(new Product(R.drawable.img_sofabang_alice,"ALICE", "Sofa bằng", "4.7", 4500000));
        productList.add(new Product(R.drawable.img_sofabang_jasmin,"JASMIN", "Sofa Bằng", "4.7", 10850000));
        productList.add(new Product(R.drawable.img_sofabang_aurora,"AURORA", "Sofa bằng", "4.7", 3290000));
        productList.add(new Product(R.drawable.img_sofabang_elena,"ELENA", "Sofa Bằng", "4.7", 5850000));
        productList.add(new Product(R.drawable.img_sofabang_muscle,"ALICE", "Sofa bằng", "4.7", 5850000));

        adapter = new ProductAdapter(CategoriesProductActivity.this, R.layout.item_product,  productList);
        binding.gvCategoryProduct.setAdapter(adapter);
    }
    private  void  addEvent(){

        binding.gvCategoryProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CategoriesProductActivity.this, MainActivity.class);
                intent.putExtra("Name", productList.get(i).getProductName());
                intent.putExtra("Image", productList.get(i).getProductThumb());
                intent.putExtra("Price", productList.get(i).getProductPrice());
                intent.putExtra("Rate", productList.get(i).getProductRate());
                intent.putExtra("Category", productList.get(i).getProductCategory());
                startActivity(intent);
            }
        });
    }

    private void FilterPrice() {
        //Add Filter
        autoCompleteTextView = findViewById(R.id.txt_auto_complete);
        adapterItems = new ArrayAdapter<String>(this, R.layout.item_list_price, items);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void goBack() {
        binding.toolbarCategoryProduct.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

//    private void linkViews() {
//        toolbarCategoryProduct = findViewById(R.id.toolbarCategoryProduct);
//        txtCategoryName = findViewById(R.id.txtCategoryName);
//        spinnerCategory = findViewById(R.id.spinnerCategory);
////        rcvProductCategory = findViewById(R.id.rcvCategoryProduct);
//
//
//    }
//

//    private void addEventProductList() {
//        LinearLayoutManager layoutManager = new LinearLayoutManager(CategoryProductActivity.this, LinearLayoutManager.VERTICAL, false);
//        rcvProductCategory.setLayoutManager(layoutManager);
//
//        getData();
//
//        rcvProductCategory.setAdapter(new ProductCategoryAdapter(CategoryProductActivity.this, R.layout.item_product, products, onClickInterface));
//
//        onClickInterface = number -> {
//            Intent intent = new Intent(this, DetailProductActivity.class);
//            intent.putExtra(Constant.ID_PRODUCT, number);
//            startActivity(intent);
//        };
//    }
//    private void getData(){
//        productList = MainActivity.productList;
//        products = new ArrayList<>();
//        Intent intent = getIntent();
//        if (intent != null) {
//            String number = String.valueOf(intent.getExtras().getInt("id"));
//            for (Product p : productList) {
//                if (p.getProductCategory().equals(number)) {
//                    products.add(p);
//                }
//            }
//            //set Title
//            txtCategoryName.setText(intent.getExtras().getString("category"));
//        }
//    }
//
//    private void addEventSpinner() {
//        //creating array adapter
//        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_categories_product, items);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        autoCompleteTextView.setAdapter(adapter);
//
//        //Filter product


//        autoCompleteTextView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                getData();
//                ArrayList<Product> productsFilter = new ArrayList<>();
//                switch (i) {
//                    case 0:
//                        productsFilter = products;
//                        break;
//                    case 1:
//                        for (Product p2 : products) {
//                            if (p2.getProductPrice() < 1000000) {
//                                productsFilter.add(p2);
//                            }
//                        }
//                        break;
//                    case 2:
//                        for (Product p3 : products) {
//                            if (p3.getProductPrice() >= 1000000 && p3.getProductPrice() < 5000000) {
//                                productsFilter.add(p3);
//                            }
//                        }
//                        break;
//                    case 3:
//                        for (Product p4 : products) {
//                            if (p4.getProductPrice() >= 5000000 && p4.getProductPrice() < 10000000) {
//                                productsFilter.add(p4);
//                            }
//                        }
//                        break;
//                    case 4:
//                        for (Product p5 : products) {
//                            if (p5.getProductPrice() >= 10000000) {
//                                productsFilter.add(p5);
//                            }
//                        }
//                        break;
//                }
//                gvCategoryProduct.setAdapter(new ProductAdapter(CategoriesProductActivity.this, R.layout.item_product, productsFilter, onClickInterface));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//    }
}