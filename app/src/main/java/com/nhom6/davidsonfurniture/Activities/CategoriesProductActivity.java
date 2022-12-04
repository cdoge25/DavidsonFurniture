package com.nhom6.davidsonfurniture.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.nhom6.davidsonfurniture.Adapters.ProductAdapter;
import com.nhom6.davidsonfurniture.Adapters.ProductCategoryAdapter;
import com.nhom6.davidsonfurniture.Interfaces.OnClickInterface;
import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityCategoriesProductBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CategoriesProductActivity extends AppCompatActivity {

    ActivityCategoriesProductBinding binding;
    ProductAdapter adapter;
    ArrayList<Product> productList;
    String category;


    ArrayList<Product> products;


//    OnClickInterface onClickInterface;

    // Spinner
//    ArrayAdapter<Filter> filteradapter;
//    GridView gvProduct;
    Spinner spinner;
    String[] price = {"Tất cả", "Dưới 1 triệu", "Từ 1-5 triệu", "Từ 5-10 triệu", "Trên 10 triệu"};


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

        category = intent.getStringExtra("category");

        addEvent();

//        FilterPrice();

        goBack();

        toDetail();

        loadData();

        initializeViews();
    }


   //Intialite gidview and spinner, set adapters and listen to spinner itemSelected

    private  void initializeViews() {
        spinner = findViewById(R.id.spFilterPrice);
        spinner.setAdapter(new ArrayAdapter<String>(this,R.layout.item_list_price, price));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
}

    //Create Adapter for ArrayAdapter

    private void loadData() {

        if (Objects.equals(category, "sofa")){
            productList = new ArrayList<>();
            productList.add(new Product(R.drawable.img_sofabang_anastasia,"ANASTASIA", "Sofa Băng", "4.7", 8500000));
            productList.add(new Product(R.drawable.img_sofabang_alice,"ALICE", "Sofa băng", "4.7", 4500000));
            productList.add(new Product(R.drawable.img_sofabang_jasmin,"JASMIN", "Sofa Băng", "4.7", 10850000));
            productList.add(new Product(R.drawable.img_sofabang_aurora,"AURORA", "Sofa băng", "4.7", 3290000));
            productList.add(new Product(R.drawable.img_sofabang_elena,"ELENA", "Sofa Băng", "4.7", 5850000));
            productList.add(new Product(R.drawable.img_sofabang_muscle,"ALICE", "Sofa băng", "4.7", 5850000));
            binding.txtCategoryName.setText("Sofa");
        }
        else if (Objects.equals(category, "ghe")){
            productList = new ArrayList<>();
            productList.add(new Product(R.drawable.img_ghelamviec_qile,"QILE", "Ghế làm việc", "4.7", 1590000));
            productList.add(new Product(R.drawable.img_ghean_astu,"ASTU", "Ghế ăn", "4.7", 594000));
            productList.add(new Product(R.drawable.img_ghean_noven,"NOVEN", "Ghế ăn", "4.7", 2850000));
            productList.add(new Product(R.drawable.img_ghebanh_moana,"MOANA", "Ghế bành", "4.7", 7950000));
            productList.add(new Product(R.drawable.img_ghedon_michau,"MICHAU", "Ghế đôn", "4.7", 4250000));
            productList.add(new Product(R.drawable.img_ghelamviec_miti,"MITI", "Ghế làm việc", "4.7", 2490000));
            binding.txtCategoryName.setText("Ghế");
        }
        else if (Objects.equals(category, "ban")){
            productList = new ArrayList<>();
            productList.add(new Product(R.drawable.img_banan_honey,"HONEY", "Bàn ăn", "4.7", 1150000));
            productList.add(new Product(R.drawable.img_banlamviec_builder,"BUILDER", "Bàn làm việc", "4.7", 2850000));
            productList.add(new Product(R.drawable.img_bancafe_luki,"LUKI", "Bàn cafe", "4.7", 1350000));
            productList.add(new Product(R.drawable.img_banan_lehi,"LEHI", "Bàn ăn", "4.7", 5490000));
            productList.add(new Product(R.drawable.img_bancafe_mushroom,"MUSHROOM", "Bàn cafe", "4.7", 3750000));
            productList.add(new Product(R.drawable.img_bantrangdiem_mbinas,"MBINAS", "Bàn trang điểm", "4.7", 2750000));
            binding.txtCategoryName.setText("Bàn");
        }
        else if (Objects.equals(category, "guong")){
            productList = new ArrayList<>();
            productList.add(new Product(R.drawable.img_guongnho_arou,"AROU", "Gương nhỏ", "4.7", 1250000));
            productList.add(new Product(R.drawable.img_guongnho_mibo,"MIBO", "Gương nhỏ", "4.7", 1250000));
            productList.add(new Product(R.drawable.img_guongtoanthan_tama,"TAMA", "Gương toàn thân", "4.7", 2690000));
            productList.add(new Product(R.drawable.img_guongdeban_coba,"COBA", "Gương để bàn", "4.7", 1220000));
            productList.add(new Product(R.drawable.img_guongtoanthan_patax,"PATAX", "Gương toàn thân", "4.7", 2690000));
            productList.add(new Product(R.drawable.img_guongdeban_utu,"UTU", "Gương để bàn", "4.7", 390000));
            binding.txtCategoryName.setText("Gương");
        }
        else if (Objects.equals(category, "den")){
            productList = new ArrayList<>();
            productList.add(new Product(R.drawable.img_denban_feeca,"FEECA", "Đèn bàn", "4.7", 449000));
            productList.add(new Product(R.drawable.img_densan_logly,"LOGLY", "Đèn sàn", "4.7", 990000));
            productList.add(new Product(R.drawable.img_dentrangtri_firefly,"FIREFLY", "Đèn trang trí", "4.7", 199000));
            productList.add(new Product(R.drawable.img_densan_noti,"NOTI", "Đèn sàn", "4.7", 990000));
            productList.add(new Product(R.drawable.img_denban_quiin,"QUIIN", "Đèn bàn", "4.7", 399000));
            productList.add(new Product(R.drawable.img_dentrangtri_lampy,"LAMPY", "Đèn trang trí", "4.7", 245000));
            binding.txtCategoryName.setText("Đèn");
        }
        else if (Objects.equals(category, "ketu")){
            productList = new ArrayList<>();
            productList.add(new Product(R.drawable.img_kedungdo_ez,"EZ", "Kệ đựng đồ", "4.7", 490000));
            productList.add(new Product(R.drawable.img_ketugiay_johy,"JOHY", "Kệ, tủ giày", "4.7", 2850000));
            productList.add(new Product(R.drawable.img_ketuquanao_quada,"QUADA", "Kệ, tử quần áo", "4.7", 22200000));
            productList.add(new Product(R.drawable.img_ketugiay_lam,"LAM", "Kệ, tủ giày", "4.7", 1920000));
            productList.add(new Product(R.drawable.img_ketuquanao_tasota,"TASOTA", "Kệ, tử quần áo", "4.7", 485000));
            productList.add(new Product(R.drawable.img_ketutv_hobu,"HOBU", "Kệ, tủ TV", "4.7", 2800000));
            binding.txtCategoryName.setText("Kệ tủ");
        }
        else if (Objects.equals(category, "trangtri")){
            productList = new ArrayList<>();
            productList.add(new Product(R.drawable.img_ttdongho_queen,"QUEEN", "Đồng hồ", "4.7", 799000));
            productList.add(new Product(R.drawable.img_tttranhanh_moon,"MOON", "Tranh ảnh", "4.7", 199000));
            productList.add(new Product(R.drawable.img_ttvanphongpham_khaydungghichu,"Khay đựng ghi chú", "Văn phòng phẩm", "4.7", 59000));
            productList.add(new Product(R.drawable.img_ttdongho_king,"King", "Đồng hồ", "4.7", 899000));
            productList.add(new Product(R.drawable.img_tttranhanh_you,"YOU", "Tranh ảnh", "4.7", 199000));
            productList.add(new Product(R.drawable.img_ttvanphongpham_ongdungbut,"Ống đựng bút", "Văn phòng phẩm", "4.7", 59000));
            binding.txtCategoryName.setText("Trang trí");
        }
        else  if (Objects.equals(category, "giuong")){
            productList = new ArrayList<>();
            productList.add(new Product(R.drawable.img_giuongngu_hano,"HANO", "Giường ngủ", "4.7", 13950000));
            productList.add(new Product(R.drawable.img_nemngoi_lollipop,"LOLLIPOP", "Nệm ngồi", "4.7", 169000));
            productList.add(new Product(R.drawable.img_nemcaosu_springvenus,"SPRING VENUS", "Nệm cao su", "4.7", 7314000));
            productList.add(new Product(R.drawable.img_giuongngu_lullaby,"LULLABY", "Giường ngủ", "4.7", 10500000));
            productList.add(new Product(R.drawable.img_nemngoi_candy,"CANDY", "Nệm ngồi", "4.7", 199000));
            productList.add(new Product(R.drawable.img_giuongngu_dalatgrace,"DALAT GRACE", "Giường ngủ", "4.7", 9850000));
            binding.txtCategoryName.setText("Giường");
        }

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

    private void goBack() {
        binding.toolbarCategoryProduct.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


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
