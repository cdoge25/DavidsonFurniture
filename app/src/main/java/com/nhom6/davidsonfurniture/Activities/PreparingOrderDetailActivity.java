package com.nhom6.davidsonfurniture.Activities;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nhom6.davidsonfurniture.Models.PreparingOrder;
import com.nhom6.davidsonfurniture.R;

public class PreparingOrderDetailActivity extends AppCompatActivity {

    TextView txtDetailName,txtDetailType, txtDetailColor, txtDetailPrice, txtDetailQuantity, txtDetailCode;
    ImageView imvDetailThumb;
    Toolbar toolbarOrderDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparing_order_detail);

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
        goBack();
    }

    private void linkViews() {
        toolbarOrderDetail = findViewById(R.id.toolbarPreparingOrderDetail);

        imvDetailThumb = findViewById(R.id.imvPreparingDetailThumb);
        txtDetailName = findViewById(R.id.txtPreparingDetailName);
        txtDetailType = findViewById(R.id.txtPreparingDetailType);
        txtDetailColor = findViewById(R.id.txtPreparingDetailColor);
        txtDetailPrice = findViewById(R.id.txtPreparingDetailPrice);
        txtDetailQuantity = findViewById(R.id.txtPreparingDetailQuantity);
        txtDetailCode = findViewById(R.id.txtPreparingDetailCode);
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
            PreparingOrder preparingOrder = (PreparingOrder) bundle.get("object_preparing");

            imvDetailThumb.setImageResource(preparingOrder.getPreparingThumb());
            txtDetailName.setText(preparingOrder.getPreparingName());
            txtDetailType.setText(preparingOrder.getPreparingType());
            txtDetailColor.setText(preparingOrder.getPreparingColor());
            txtDetailPrice.setText(String.format("%.0f", preparingOrder.getPreparingPrice()) + "đ");
            txtDetailQuantity.setText(String.format("Số lượng: %s",preparingOrder.getPreparingQuantity()));
            txtDetailCode.setText(String.format("Mã đơn hàng: %s",preparingOrder.getPreparingCode()));
        }
    }
}