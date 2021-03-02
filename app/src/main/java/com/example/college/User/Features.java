package com.example.college.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.college.R;

public class Features extends AppCompatActivity {

    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_features);

        backBtn = findViewById(R.id.back_pressed_icon);
        backBtn.setOnClickListener(new CardView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Features.super.onBackPressed();
            }
        });
    }
}