package com.example.sporkompleksi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;


public class SplashEkrani extends AppCompatActivity {
Timer timer ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_ekrani);
        timer = new  Timer();
        timer.schedule(new TimerTask(){
            @Override
            public void run() {
                Intent intent = new Intent(SplashEkrani.this, MainActivity.class);
                startActivity(intent);
            }
            }, 3000);
    }
}