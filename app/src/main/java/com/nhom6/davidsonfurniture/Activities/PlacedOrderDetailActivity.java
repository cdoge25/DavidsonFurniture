package com.nhom6.davidsonfurniture.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.nhom6.davidsonfurniture.Fragments.PlacedOrderFragment;
import com.nhom6.davidsonfurniture.Models.PlacedOrder;
import com.nhom6.davidsonfurniture.R;

public class PlacedOrderDetailActivity extends AppCompatActivity {

    int orderID;
    TextView txtDetailName,txtDetailType, txtDetailColor, txtDetailPrice, txtDetailQuantity, txtDetailCode;
    ImageView imvDetailThumb;
    Toolbar toolbarCancelOrder, toolbarOrderDetail;
    Button btnCancelOrder, btnCancelConfirm, btnBackHome, btnConfirmSuccess;
    RadioGroup radGroupCancel;
    BottomSheetDialog sheetDialogCancelOrder, sheetDialogCancelSuccess;

    PlacedOrderFragment placedOrderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placed_order_detail);

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

        createCancelOrderDialog();

        linkViews();
        addEvents();
        goBack();
    }

    private void linkViews() {
        toolbarOrderDetail = findViewById(R.id.toolbarPlacedOrderDetail);
        btnCancelOrder = findViewById(R.id.btnCancelOrder);

        imvDetailThumb = findViewById(R.id.imvDetailThumb);
        txtDetailName = findViewById(R.id.txtDetailName);
        txtDetailType = findViewById(R.id.txtDetailType);
        txtDetailColor = findViewById(R.id.txtDetailColor);
        txtDetailPrice = findViewById(R.id.txtDetailPrice);
        txtDetailQuantity = findViewById(R.id.txtDetailQuantity);
        txtDetailCode = findViewById(R.id.txtDetailCode);
    }

    private void goBack(){
        toolbarOrderDetail.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        //nhận dữ liệu
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            PlacedOrder placedOrder = (PlacedOrder) bundle.get("object_placed");

            orderID = placedOrder.getPlacedID();
            imvDetailThumb.setImageResource(placedOrder.getPlacedThumb());
            txtDetailName.setText(placedOrder.getPlacedName());
            txtDetailType.setText(placedOrder.getPlacedType());
            txtDetailColor.setText(placedOrder.getPlacedColor());
            txtDetailPrice.setText(String.format("%.0f", placedOrder.getPlacedPrice()) + "đ");
            txtDetailQuantity.setText(String.format("Số lượng: %s",placedOrder.getPlacedQuantity()));
            txtDetailCode.setText(String.format("Mã đơn hàng: %s",placedOrder.getPlacedCode()));
        }
    }

    private void addEvents() {
        btnCancelOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheetDialogCancelOrder.show();
            }
        });
    }

    private void createCancelOrderDialog() {
        sheetDialogCancelOrder = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_cancel_order,null);

        sheetDialogCancelOrder.setContentView(view);
        sheetDialogCancelOrder.setCancelable(false);
        sheetDialogCancelOrder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                setBackgroundDrawableResource(android.R.color.transparent);

        btnCancelConfirm = view.findViewById(R.id.btnCancelConfirm);
        toolbarCancelOrder = view.findViewById(R.id.toolbarCancelOrder);
        radGroupCancel = view.findViewById(R.id.radGroupCancel);

        toolbarCancelOrder.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.menuCancel){
                    sheetDialogCancelOrder.dismiss();
                }
                return false;
            }
        });

        btnCancelConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radId = radGroupCancel.getCheckedRadioButtonId();
                if(radId == -1){
                    Toast.makeText(getApplicationContext(), "Vui lòng chọn lý do hủy đơn", Toast.LENGTH_SHORT).show();
                    return;
                }
                createCanCelSuccessDialog();
                sheetDialogCancelOrder.dismiss();
            }
        });
    }

    private void createCanCelSuccessDialog() {
        sheetDialogCancelSuccess = new BottomSheetDialog(this);
        View view1 = LayoutInflater.from(PlacedOrderDetailActivity.this).inflate(R.layout.bottom_sheet_cancel_success, null);
        sheetDialogCancelSuccess.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        sheetDialogCancelOrder.setCancelable(false);
        sheetDialogCancelSuccess.setCanceledOnTouchOutside(false);
        sheetDialogCancelSuccess.setContentView(view1);

        sheetDialogCancelSuccess.show();

        btnConfirmSuccess = view1.findViewById(R.id.btnConfirmSuccess);
        btnConfirmSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlacedOrderDetailActivity.this, OrderStatusActivity.class);
                intent.putExtra("detailName", String.valueOf(txtDetailName));
                startActivity(intent);
                sheetDialogCancelSuccess.dismiss();
            }
        });

        btnBackHome = view1.findViewById(R.id.btnBackHome);
        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlacedOrderDetailActivity.this, HomeActivity.class);
                startActivity(intent);
                sheetDialogCancelSuccess.dismiss();
            }
        });

//        placedOrderFragment.deleteOrder(orderID);
    }
}
