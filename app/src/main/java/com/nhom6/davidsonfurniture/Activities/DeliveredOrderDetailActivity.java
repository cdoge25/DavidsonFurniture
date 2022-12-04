package com.nhom6.davidsonfurniture.Activities;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nhom6.davidsonfurniture.Models.DeliveredOrder;
import com.nhom6.davidsonfurniture.R;

public class DeliveredOrderDetailActivity extends AppCompatActivity {

    TextView txtDetailName,txtDetailType, txtDetailColor, txtDetailPrice, txtDetailQuantity, txtDetailCode;
    ImageView imvDetailThumb;
    Toolbar toolbarOrderDetail;
    Button btnReturnOrder, btnComplete, btnCanCelComplete, btnConfirmComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered_order_detail);

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

        linkViews();
        addEvents();
        goBack();
    }

    private void linkViews() {
        toolbarOrderDetail = findViewById(R.id.toolbarDeliveredOrderDetail);
        btnReturnOrder = findViewById(R.id.btnReturnOrder);
        btnComplete = findViewById(R.id.btnComplete);

        imvDetailThumb = findViewById(R.id.imvDeliveredDetailThumb);
        txtDetailName = findViewById(R.id.txtDeliveredDetailName);
        txtDetailType = findViewById(R.id.txtDeliveredDetailType);
        txtDetailColor = findViewById(R.id.txtDeliveredDetailColor);
        txtDetailPrice = findViewById(R.id.txtDeliveredDetailPrice);
        txtDetailQuantity = findViewById(R.id.txtDeliveredDetailQuantity);
        txtDetailCode = findViewById(R.id.txtDeliveredDetailCode);
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
            DeliveredOrder deliveredOrder = (DeliveredOrder) bundle.get("object_delivered");

            imvDetailThumb.setImageResource(deliveredOrder.getDeliveredThumb());
            txtDetailName.setText(deliveredOrder.getDeliveredName());
            txtDetailType.setText(deliveredOrder.getDeliveredType());
            txtDetailColor.setText(deliveredOrder.getDeliveredColor());
            txtDetailPrice.setText(String.format("%.0f", deliveredOrder.getDeliveredPrice()) + "đ");
            txtDetailQuantity.setText(String.format("Số lượng: %s",deliveredOrder.getDeliveredQuantity()));
            txtDetailCode.setText(String.format("Mã đơn hàng: %s",deliveredOrder.getDeliveredCode()));
        }
    }

    private void addEvents() {
        btnReturnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliveredOrderDetailActivity.this, ReturnOrderActivity.class);
                startActivity(intent);
            }
        });

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(DeliveredOrderDetailActivity.this);
                dialog.setContentView(R.layout.dialog_complete_order);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                btnCanCelComplete = dialog.findViewById(R.id.btnCancelComplete);
                btnCanCelComplete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                btnConfirmComplete = dialog.findViewById(R.id.btnConfirmComplete);
                btnConfirmComplete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DeliveredOrderDetailActivity.this, OrderStatusActivity.class);
                        startActivity(intent);
                        //đổ dữ liệu sang màn hình lịch sử và xóa data bên này
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}