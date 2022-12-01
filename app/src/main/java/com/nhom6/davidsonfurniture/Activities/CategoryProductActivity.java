package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Adapters.ProductCategoryAdapter;
import com.nhom6.davidsonfurniture.Constants.Constant;
import com.nhom6.davidsonfurniture.Interfaces.OnClickInterface;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;

public class CategoryProductActivity extends AppCompatActivity {

    Toolbar toolbarCategoryProduct;
    TextView txtCategoryName;
    Spinner spinnerCategory;
    String[] price = {"Tất cả","Dưới 1.000.000","Từ 1.000.000 đến 5.000.000","Từ 5.000.000 đến 10.000.000","Từ 10. 000.000 trở lên"};
    ArrayList<Product> productList, products;
    RecyclerView rcvProductCategory;
    OnClickInterface onClickInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_categories_product);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();}

        linkViews();
        addEventBack();
        addEventProductList();
        addEventSpinner();
    }

    private void linkViews() {
        toolbarCategoryProduct = findViewById(R.id.toolbarCategoryProduct);
        txtCategoryName = findViewById(R.id.txtCategoryName);
        spinnerCategory = findViewById(R.id.spinnerCategory);
        rcvProductCategory = findViewById(R.id.rcvCategoryProduct);
    }

    private void addEventBack() {
        setSupportActionBar(toolbarCategoryProduct);
        if(getSupportActionBar() != null)
            getSupportActionBar().setTitle(null);
        toolbarCategoryProduct.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addEventProductList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(CategoryProductActivity.this, LinearLayoutManager.VERTICAL, false);
        rcvProductCategory.setLayoutManager(layoutManager);

        getData();

        rcvProductCategory.setAdapter(new ProductCategoryAdapter(CategoryProductActivity.this, R.layout.item_product, products, onClickInterface));

        onClickInterface = number -> {
            Intent intent = new Intent(this, DetailProductActivity.class);
            intent.putExtra(Constant.ID_PRODUCT, number);
            startActivity(intent);
        };
    }
    private void getData(){
        productList = MainActivity.productList;
        products = new ArrayList<>();
        Intent intent = getIntent();
        if (intent != null) {
            String number = String.valueOf(intent.getExtras().getInt("id"));
            for (Product p : productList) {
                if (p.getProductCategory().equals(number)) {
                    products.add(p);
                }
            }
            //set Title
            txtCategoryName.setText(intent.getExtras().getString("category"));
        }
    }

    private void addEventSpinner() {
        //creating array adapter
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item_spinner, price);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);

        //Filter product
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getData();
                ArrayList<Product> productsFilter = new ArrayList<>();
                switch (i) {
                    case 0:
                        productsFilter = products;
                        break;
                    case 1:
                        for (Product p2 : products) {
                            if (p2.getProductPrice() < 1000000) {
                                productsFilter.add(p2);
                            }
                        }
                        break;
                    case 2:
                        for (Product p3 : products) {
                            if (p3.getProductPrice() >= 1000000 && p3.getProductPrice() < 5000000) {
                                productsFilter.add(p3);
                            }
                        }
                        break;
                    case 3:
                        for (Product p4 : products) {
                            if (p4.getProductPrice() >= 5000000 && p4.getProductPrice() < 10000000) {
                                productsFilter.add(p4);
                            }
                        }
                        break;
                    case 4:
                        for (Product p5 : products) {
                            if (p5.getProductPrice() >= 10000000) {
                                productsFilter.add(p5);
                            }
                        }
                        break;
                }
                rcvProductCategory.setAdapter(new ProductCategoryAdapter(CategoryProductActivity.this, R.layout.item_product, productsFilter, onClickInterface));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}