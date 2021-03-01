package com.example.college.Common;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.college.R;
import com.example.college.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
    ImageView backgroundImage;
    SharedPreferences onBoardingScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        backgroundImage = findViewById(R.id.splash_background);
        int SPLASH_TIMER = 3000;
        new Handler().postDelayed(() -> {
            onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
            boolean isFirstTime = onBoardingScreen.getBoolean("firstTime",true);
            if (isFirstTime){
                SharedPreferences.Editor editor= onBoardingScreen.edit();
                editor.putBoolean("firstTime",false);
                editor.apply();

                Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                startActivity(intent);
                finish();
            }
            else{
                Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMER);
    }
}