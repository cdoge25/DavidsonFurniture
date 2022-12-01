package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.nhom6.davidsonfurniture.Adapters.ProductAdapter;
import com.nhom6.davidsonfurniture.Adapters.SearchProductAdapter;
import com.nhom6.davidsonfurniture.Constants.Constant;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;

import java.util.ArrayList;

public class SearchProductActivity extends AppCompatActivity implements SearchProductAdapter.SelectedProduct {

    private GridView gvNearly;
    private Toolbar toolbar;
    private SearchView searchView;
    ArrayList<Product> dataList;
    ProductAdapter adapter;

    private LinearLayout lnRecent;
    private RecyclerView rcvSearch;
    ArrayList<Product> products, productList;
    SearchProductAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        linkViews();
        initData();
        addAdapter();
        addEvents();
        searchProduct();

        searchView.requestFocus();
    }

    private void addEvents() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addAdapter() {
        adapter= new ProductAdapter(this, R.layout.item_search, dataList);
        gvNearly.setAdapter(adapter);

    }

    private void initData() {
        dataList= new ArrayList<>();
        dataList.add(new Product(R.drawable.img_sofabang_anastasia,"ANASTASIA", "Sofa Bằng", "4.7", 8500000));
        dataList.add (new Product(R.drawable.img_banan_honey,"HONEY", "Bàn ăn", "4.7", 2859000));
        dataList.add(new Product(R.drawable.img_guongtoanthan_patax,"PATAX", "Gương toàn thân", "4.7",2690000));
        dataList.add(new Product(R.drawable.img_nemngoi_candy,"CANDY", "Nệm ngồi", "4.7", 10500000));
    }

    private void linkViews() {
        gvNearly= findViewById(R.id.gvNearlySearch);
        toolbar= findViewById(R.id.toolbarSearch);
        searchView= findViewById(R.id.svSearchActivity);

        lnRecent = findViewById(R.id.lnRecent);
        rcvSearch = findViewById(R.id.rcvSearch);
    }


    private void searchProduct() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(SearchProductActivity.this, LinearLayoutManager.VERTICAL, false);
        rcvSearch.setLayoutManager(layoutManager);
        productList = MainActivity.productList;
        products = new ArrayList<>();
        for(Product p : productList){
            products.add(p);
        }

        searchAdapter = new SearchProductAdapter(SearchProductActivity.this, R.layout.item_product, products, this);
        rcvSearch.setAdapter(searchAdapter);

        searchView.setFocusable(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(!s.equals("")){
                    lnRecent.setVisibility(View.GONE);
                    rcvSearch.setVisibility(View.VISIBLE);
                    searchAdapter.getFilter().filter(s);
                }else {
                    lnRecent.setVisibility(View.VISIBLE);
                    rcvSearch.setVisibility(View.GONE);
                }
                return false;
            }
        });


    }

    @Override
    public void selectedProduct(Product product) {
      Intent intent = new Intent(SearchProductActivity.this, DetailProductActivity.class);
//        intent.putExtra("isSearch", true);
//      intent.putExtra (Constant.ID_PRODUCT, product);
//        startActivity(intent);
   }
}