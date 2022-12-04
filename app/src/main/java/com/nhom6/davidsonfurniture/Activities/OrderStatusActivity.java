package com.nhom6.davidsonfurniture.Activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.nhom6.davidsonfurniture.Adapters.ViewPagerOrderStatusAdapter;
import com.nhom6.davidsonfurniture.R;

public class OrderStatusActivity extends AppCompatActivity {

    private TabLayout dTabLayout;
    private ViewPager2 dViewPager;
    private ViewPagerOrderStatusAdapter ViewPagerAdapter;
    String detailName;

    Toolbar toolbarOrderStatus;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

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

        goBack();

        if(getIntent().getStringExtra("detailName")!= null){
            detailName = getIntent().getStringExtra("detailName");
            dTabLayout = findViewById(R.id.tab_layout);
            dViewPager = findViewById(R.id.view_pager);

            ViewPagerAdapter = new ViewPagerOrderStatusAdapter(this);
            dViewPager.setAdapter(ViewPagerAdapter);

            new TabLayoutMediator(dTabLayout, dViewPager, (tab, position) -> {
                switch (position){
                    case 0:
                        tab.setText("Chờ xác nhận");
                        break;
                    case 1:
                        tab.setText("Đang chuẩn bị");
                        break;
                    case 2:
                        tab.setText("Đang giao");
                        break;
                    case 3:
                        tab.setText("Đã giao");
                        break;
                    case 4:
                        tab.setText("Lịch sử");
                        break;
                }
            }).attach();
        }

        //khởi tạo
        dTabLayout = findViewById(R.id.tab_layout);
        dViewPager = findViewById(R.id.view_pager);

        ViewPagerAdapter = new ViewPagerOrderStatusAdapter(this);
        dViewPager.setAdapter(ViewPagerAdapter);

        new TabLayoutMediator(dTabLayout, dViewPager, (tab, position) -> {
            switch (position){
                case 0:
                    tab.setText("Chờ xác nhận");
                    break;
                case 1:
                    tab.setText("Đang chuẩn bị");
                    break;
                case 2:
                    tab.setText("Đang giao");
                    break;
                case 3:
                    tab.setText("Đã giao");
                    break;
                case 4:
                    tab.setText("Lịch sử");
                    break;
            }
        }).attach();

    }
    public String getDetailName() {
        return detailName;
    }

    private void goBack(){
        toolbarOrderStatus = findViewById(R.id.toolbarOrderStatus);
        toolbarOrderStatus.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}