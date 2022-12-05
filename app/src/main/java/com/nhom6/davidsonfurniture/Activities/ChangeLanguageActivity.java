package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityAccountBinding;
import com.nhom6.davidsonfurniture.databinding.ActivityChangeLanguageBinding;

public class ChangeLanguageActivity extends AppCompatActivity {

    ActivityChangeLanguageBinding binding;

    RadioGroup radGroupLanguage;
    RadioButton radTiengViet, radEnglish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_change_language);

        //hide status and action bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        binding = ActivityChangeLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        radGroupLanguage = findViewById(R.id.radGroupLanguage);

        radTiengViet = findViewById(R.id.rad_TiengViet);
        radEnglish = findViewById(R.id.rad_English);

        addEvent();

        goBack();
    }

    private void addEvent() {
        radTiengViet.setTextColor(getResources().getColor(R.color.orange));

        radGroupLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rad_TiengViet) {
                    radTiengViet.setTextColor(getResources().getColor(R.color.orange));
                    radEnglish.setTextColor(getResources().getColor(R.color.black));
                } else if (i == R.id.rad_English) {
                    radEnglish.setTextColor(getResources().getColor(R.color.orange));
                    radTiengViet.setTextColor(getResources().getColor(R.color.black));
                }
            }

        });
    }

    private void goBack() {
        binding.toolbarChangeLanguage.getChildAt(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}