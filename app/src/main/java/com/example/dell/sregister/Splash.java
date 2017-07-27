package com.example.dell.sregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen screen=new EasySplashScreen(Splash.this)
                .withFullScreen()
                .withSplashTimeOut(4000)
                .withBackgroundResource(R.drawable.my)
                .withTargetActivity(MainActivity.class);
        View v=screen.create();
        setContentView(v);

    }
}
