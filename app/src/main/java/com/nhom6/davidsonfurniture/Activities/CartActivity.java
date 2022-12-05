package com.nhom6.davidsonfurniture.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.nhom6.davidsonfurniture.Adapters.CartAdapter;
import com.nhom6.davidsonfurniture.Databases.DatabaseHelper;
import com.nhom6.davidsonfurniture.Models.ProductCart;
import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityCartBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class CartActivity extends AppCompatActivity {
    ActivityCartBinding binding;
    CartAdapter adapter;
    ArrayList<ProductCart> products;
    DatabaseHelper db;
    String whatToDo = "addToCart";
    public static ArrayList<ProductCart> manggiohang;
    String color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_cart);

        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


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

        binding.navApp.setSelectedItemId(R.id.navCart);
        navigationClick();

        createDb();
        getSentData();
        loadData();

        binding.btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartActivity.this, OrderActivity.class);
                startActivity(i);
            }
        });
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
    public void DialogColor(ProductCart p){

        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.bottomsheetlayout);
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

        //Khai báo các thành phần
        RadioButton radioBlack, radioGrey, radioWhite;
        RadioButton radioButton;
        ImageButton btnClose;
        Button btnConfirm;
        String a =p.getProductColor();

        //Ánh xạ
        radioBlack = dialog.findViewById(R.id.radio_black);
        radioGrey = dialog.findViewById(R.id.radio_grey);
        radioWhite = dialog.findViewById(R.id.radio_white);
        RadioGroup radiogroup = dialog.findViewById(R.id.radgroup_color);

        btnClose = dialog.findViewById(R.id.btn_closeBottomSheet);
        btnConfirm = dialog.findViewById(R.id.btn_confirmColorCart);

        // get selected radio button from radioGroup
        int selectedId = radiogroup.getCheckedRadioButtonId();
        // find the radiobutton by returned id
        radioButton = (RadioButton) findViewById(selectedId);

        if(a.equals("Đen")){
            radioBlack.setChecked(true);
        } else if(a.equals("Xám")){
            radioGrey.setChecked(true);
        } else{
            radioWhite.setChecked(true);
        }

        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radio_white:
                        color = "Trắng";
                        break;
                    case R.id.radio_black:
                        color = "Đen";
                        break;
                    case R.id.radio_grey:
                        color = "Xám";
                        break;
                }
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.queryData("UPDATE " + DatabaseHelper.TBL_NAME +  " SET " + DatabaseHelper.COL_COLOR + " = '"
                        + color + "' WHERE " + DatabaseHelper.COL_ID + " = '" + p.getProductId() + "'");
                loadData();
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    //================================TỔNG TIỀN ===========================
    public void EventUltils(int totalPrice){
//        for(int i =0; i <binding.lvProductCart.getCount(); i++){
//            totalPrice += binding.lvProductCart.getPositionForView().g
//        }

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        binding.txtTotalPriceCart.setText(decimalFormat.format(totalPrice));
    }








}