package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;

import com.nhom6.davidsonfurniture.Adapters.ProductCartAdapter;
import com.nhom6.davidsonfurniture.Models.ProductInfor;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    ProductCartAdapter adapter;
    ArrayList<ProductInfor> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart);

        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
    }

    private void loadData() {
          productList = new ArrayList<>();
//        productList.add(new ProductInfor(R.drawable.img_bantrangdiem_mbinas,"MBINAS",
//                "bàn trang điểm",5000000,1,false));
//        productList.add(new ProductInfor(R.drawable.img_bancafe_luki,"LUKI",
//                "bàn cafe",4000000,2,false));
//        productList.add(new ProductInfor(R.drawable.img_ghean_noven,"NOVEN",
//                "ghế ăn",300000,0,false));
        productList.add(new ProductInfor(R.drawable.img_ghean_noven,"NOVEN",
                "bàn trang điểm",9000000));
        productList.add(new ProductInfor(R.drawable.img_bancafe_luki,"LUKI",
                "bàn cafe",10000000));
        productList.add(new ProductInfor(R.drawable.img_banan_honey,"HONEY",
                "bàn ăn",10000000));
        productList.add(new ProductInfor(R.drawable.img_bancafe_mushroom,"MUSHROOM",
                "bàn cafe",500000));

        adapter = new ProductCartAdapter(this,R.layout.item_productcart,productList);
        binding.lvProductCart.setAdapter(adapter);
    }




}