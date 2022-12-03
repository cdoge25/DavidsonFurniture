package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.nhom6.davidsonfurniture.Adapters.CartAdapter;
import com.nhom6.davidsonfurniture.Models.ProductCart;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    CartAdapter adapter;
    ArrayList<ProductCart> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart);

        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    private void loadData() {
          productList = new ArrayList<>();
//        productList.add(new ProductInfor(R.drawable.img_bantrangdiem_mbinas,"MBINAS",
//                "bàn trang điểm",5000000,1,false));
//        productList.add(new ProductInfor(R.drawable.img_bancafe_luki,"LUKI",
//                "bàn cafe",4000000,2,false));
//        productList.add(new ProductInfor(R.drawable.img_ghean_noven,"NOVEN",
//                "ghế ăn",300000,0,false));

        productList.add(new ProductCart(R.drawable.img_ghean_noven,"Noven","Ghế ăn"
        ,"1000000","Đỏ","5"));
        productList.add(new ProductCart(R.drawable.img_bancafe_mushroom,"Mushroom","Bàn cafe"
                ,"3000000","Xám","3"));
        productList.add(new ProductCart(R.drawable.img_banan_honey,"Honey","Bàn ăn"
                ,"300000","Trắng","10"));

        adapter = new CartAdapter(this,R.layout.item_productcart, productList);
        binding.lvProductCart.setAdapter(adapter);


    }

    //========================= DialogDelete =========================
    public void DialogDelete(ProductCart p){
        //Truyền Dialog
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_delete_cart);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //Khai báo các thành phần
        Button btnCancel, btnConfirm;

        //Ánh xạ
        btnCancel = dialog.findViewById(R.id.btn_CancelDeleteCart);
        btnConfirm = dialog.findViewById(R.id.btn_ConfirmDeleteCart);

        //Xử lý event
       btnCancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dialog.dismiss();

           }
       });
        dialog.show();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });
        dialog.show();
    };

    //==========================DialogColor===========================
    public void DialogColor(){
//        //Truyền Dialog
//        Dialog dialog = new Dialog(this);
//        dialog.setContentView(R.layout.dialog_color_cart);
//        dialog.show();
//
//
//
//        //Khai báo các thành phần
//        RadioButton radioBlack, radioGrey, radioWhite;
//
//        //Ánh xạ
//        radioBlack = dialog.findViewById(R.id.radio_black);
//        radioGrey = dialog.findViewById(R.id.radio_grey);
//        radioWhite = dialog.findViewById(R.id.radio_white);
//
//        //Xử lý event
//        radioBlack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        radioGrey.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        radioWhite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.bottomsheetlayout);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        //Khai báo các thành phần
        RadioButton radioBlack, radioGrey, radioWhite;
        //Ánh xạ
        radioBlack = dialog.findViewById(R.id.radio_black);
        radioGrey = dialog.findViewById(R.id.radio_grey);
        radioWhite = dialog.findViewById(R.id.radio_white);
        //Xử lý event
        radioBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }



}