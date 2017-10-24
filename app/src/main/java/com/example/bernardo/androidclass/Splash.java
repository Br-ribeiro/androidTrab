package com.example.bernardo.androidclass;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash extends AppCompatActivity {

    private Animation animationFadeIn;
    private ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


       animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        ivSplash = (ImageView)findViewById(R.id.ivSplash);
        ivSplash.startAnimation(animationFadeIn);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;
                SharedPreferences prefs = getSharedPreferences("com.example.bernardo.androidclass", Context.MODE_PRIVATE);
                if(prefs.getString("user", null) == null || prefs.getString("passwd", null) == null || !prefs.getBoolean("status", false)){
                    intent = new Intent(Splash.this, Login.class);
                } else{
                    intent = new Intent(Splash.this, MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },5000);
    }
}
