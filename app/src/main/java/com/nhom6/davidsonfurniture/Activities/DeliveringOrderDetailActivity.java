package com.nhom6.davidsonfurniture.Activities;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nhom6.davidsonfurniture.Models.DeliveringOrder;
import com.nhom6.davidsonfurniture.R;

public class DeliveringOrderDetailActivity extends AppCompatActivity {

    TextView txtDetailName,txtDetailType, txtDetailColor, txtDetailPrice, txtDetailQuantity, txtDetailCode;
    ImageView imvDetailThumb;
    Toolbar toolbarOrderDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivering_order_detail);

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
        toolbarOrderDetail = findViewById(R.id.toolbarDeliveringOrderDetail);

        imvDetailThumb = findViewById(R.id.imvDeliveringDetailThumb);
        txtDetailName = findViewById(R.id.txtDeliveringDetailName);
        txtDetailType = findViewById(R.id.txtDeliveringDetailType);
        txtDetailColor = findViewById(R.id.txtDeliveringDetailColor);
        txtDetailPrice = findViewById(R.id.txtDeliveringDetailPrice);
        txtDetailQuantity = findViewById(R.id.txtDeliveringDetailQuantity);
        txtDetailCode = findViewById(R.id.txtDeliveringDetailCode);
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
            DeliveringOrder preparingOrder = (DeliveringOrder) bundle.get("object_delivering");

            imvDetailThumb.setImageResource(preparingOrder.getDeliveringThumb());
            txtDetailName.setText(preparingOrder.getDeliveringName());
            txtDetailType.setText(preparingOrder.getDeliveringType());
            txtDetailColor.setText(preparingOrder.getDeliveringColor());
            txtDetailPrice.setText(String.format("%.0f", preparingOrder.getDeliveringPrice()) + "đ");
            txtDetailQuantity.setText(String.format("Số lượng: %s",preparingOrder.getDeliveringQuantity()));
            txtDetailCode.setText(String.format("Mã đơn hàng: %s",preparingOrder.getDeliveringCode()));
        }
    }
}