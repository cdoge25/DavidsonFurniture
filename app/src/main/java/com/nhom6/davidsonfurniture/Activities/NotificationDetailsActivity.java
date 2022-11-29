package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityNotificationDetailsBinding;

public class NotificationDetailsActivity extends AppCompatActivity {

    ActivityNotificationDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_notification_details);

        binding = ActivityNotificationDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        toNotifications();
    }

    private void toNotifications() {
        binding.toolbarNotificationDetails.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotificationDetailsActivity.this, NotificationsActivity.class);
                startActivity(intent);
            }
        });
    }
}