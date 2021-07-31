package com.example.firstapp.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.firstapp.R;
import com.example.firstapp.ui.auth.entry.EntryActivity;
import com.example.firstapp.ui.tab_layout.TabLayoutActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        String yacht = "https://artpostergallery.ru/userdata/image/thumbs/21/00/2100c1708865a8ed8a46d0e38d146a88_2.jpg";

        ImageView imageView = findViewById(R.id.yacht_home_screen);
        Glide.with(this).load(yacht).into(imageView);

        loading();
    }
    private void loading() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, /*EntryActivity*/TabLayoutActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }, 2000);
    }
}