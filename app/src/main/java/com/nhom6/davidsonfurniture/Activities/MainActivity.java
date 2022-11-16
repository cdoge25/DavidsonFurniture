package com.nhom6.davidsonfurniture.Activities;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.nhom6.davidsonfurniture.R;
import com.nhom6.davidsonfurniture.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIMER=2000;

    ActivityMainBinding binding;
    ImageView imvLogoSplash;
    Animation fadeInAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fadeInAnim = AnimationUtils.loadAnimation(this,R.anim.fade_in_anim);
        binding.imvLogoSplash.setAnimation(fadeInAnim);
    }
}