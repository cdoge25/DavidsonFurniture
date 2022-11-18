package com.nhom6.davidsonfurniture.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nhom6.davidsonfurniture.Adapters.SliderAdapter;
import com.nhom6.davidsonfurniture.R;

import org.w3c.dom.Text;

public class OnBoardingActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button btnStart, btnSkip;
    ImageButton btnNext;
    Animation fadeInAnim, fadeOutAnim;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        btnStart = findViewById(R.id.btnStart);
        btnNext = findViewById(R.id.btnNext);
        btnSkip = findViewById(R.id.btnSkip);

        //Init Adapter
        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip (View view){
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    public void next (View view){
        viewPager.setCurrentItem(currentPosition+1);
    }

    private void addDots(int position) {
        dots = new TextView[3];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.orange));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPosition = position;

            if (position == 0) {
                btnStart.setVisibility(View.INVISIBLE);
                btnSkip.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                dotsLayout.setVisibility(View.VISIBLE);
            } else if (position == 1) {
                btnStart.setVisibility(View.INVISIBLE);
                btnSkip.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                dotsLayout.setVisibility(View.VISIBLE);
            } else {
                fadeInAnim = AnimationUtils.loadAnimation(OnBoardingActivity.this, R.anim.fade_in_anim);
                btnStart.setAnimation(fadeInAnim);
                btnStart.setVisibility(View.VISIBLE);
                btnStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(OnBoardingActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                });

                fadeOutAnim = AnimationUtils.loadAnimation(OnBoardingActivity.this, R.anim.fade_out_anim);
                btnSkip.setAnimation(fadeOutAnim);
                btnSkip.setVisibility(View.INVISIBLE);
                btnNext.setAnimation(fadeOutAnim);
                btnNext.setVisibility(View.INVISIBLE);
                dotsLayout.setAnimation(fadeOutAnim);
                dotsLayout.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}