package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.WindowManager;
import android.widget.Adapter;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.nhom6.davidsonfurniture.Adapters.CartAdapter;
import com.nhom6.davidsonfurniture.Databases.DatabaseHelper;
import com.nhom6.davidsonfurniture.Models.ProductCart;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityCartBinding;

import java.util.ArrayList;
import java.util.Objects;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    CartAdapter adapter;
    ArrayList<ProductCart> products;
    DatabaseHelper db;
    String whatToDo = "addToCart";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart);

        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        binding.navApp.setSelectedItemId(R.id.navCart);
        navigationClick();

        createDb();
        getSentData();
        loadData();

    }

    private void navigationClick() {
        binding.navApp.setOnItemSelectedListener(item ->{
            switch (item.getItemId()){
                case R.id.navHome:
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.navCart:
                    return true;
                case R.id.navOrder:
                    startActivity(new Intent(getApplicationContext(),OrderStatusActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                case R.id.navAccount:
                    startActivity(new Intent(getApplicationContext(),AccountActivity.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });
    }

    private void createDb() {
        db = new DatabaseHelper(CartActivity.this);
    }

    private void getSentData() {
        Intent intent = getIntent();
        if (Objects.equals(whatToDo, intent.getStringExtra("whatToDo"))){
            int dbThumb;
            String dbName, dbType, dbColor, dbPrice, dbQuantity;

            dbThumb = intent.getIntExtra("image",0);
            dbName = intent.getStringExtra("name");
            dbType = intent.getStringExtra("type");
            dbColor = intent.getStringExtra("color");
            dbPrice = intent.getStringExtra("price");
            dbQuantity = intent.getStringExtra("quantity");

            db.execSQL("INSERT INTO " + DatabaseHelper.TBL_NAME
                    + " VALUES(null, '" + dbThumb
                    + "', '" + dbName
                    + "', '" + dbType
                    + "', '" + dbColor
                    + "', '" + Integer.parseInt(dbPrice)
                    + "', '" + Integer.parseInt(dbQuantity) + "')"
            );
            loadData();
        };
    }

    private void loadData() {
        products = new ArrayList<>();
        Cursor c = db.getData("SELECT * FROM " + DatabaseHelper.TBL_NAME);
        while (c.moveToNext()){
            products.add(new ProductCart(c.getInt(0),
                    c.getInt(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getInt(5),
                    c.getInt(6)));
        }
        c.close();
        adapter = new CartAdapter(CartActivity.this, R.layout.item_productcart, products);
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
                db.queryData("DELETE FROM " + DatabaseHelper.TBL_NAME
                        + " WHERE " + DatabaseHelper.COL_ID
                        + " = '" + p.getProductId() + "'"
                );
                loadData();
                dialog.dismiss();
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