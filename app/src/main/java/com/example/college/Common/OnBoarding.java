package com.example.college.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.college.HelperClasses.SliderAdapter;
import com.example.college.R;
import com.example.college.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {
    ViewPager viewPager;
    Animation animation;
    LinearLayout dotsLayout;
    Button letsGetStarted;
    int currentPosition;

    SliderAdapter sliderAdapter;
    TextView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        //Hooks
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);

        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

    }
    public void skip_function(View view){
        startActivity(new Intent(getApplicationContext(), UserDashboard.class));
    }
    public void next(View view){
        if(currentPosition!=1){
            viewPager.setCurrentItem(currentPosition+1);
        }
    }

    private void addDots(int position){
        dots = new TextView[2];
        dotsLayout.removeAllViews();

        for (int i=0;i<dots.length;i++){
            dots[i]= new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(25);
            dots[i].setTextColor(Color.parseColor("#FFFFFF"));

            dotsLayout.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(Color.parseColor(("#e600ac")));
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

            if (position!=1){
                letsGetStarted.setVisibility(View.INVISIBLE);
            }
            else {
                animation = AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}