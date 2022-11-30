package com.nhom6.davidsonfurniture.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.nhom6.davidsonfurniture.Adapters.ViewPagerOrderStatusAdapter;
import com.nhom6.davidsonfurniture.R;

public class OrderStatusActivity extends AppCompatActivity {

    private TabLayout dTabLayout;
    private ViewPager2 dViewPager;
    private ViewPagerOrderStatusAdapter ViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_status);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
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
}