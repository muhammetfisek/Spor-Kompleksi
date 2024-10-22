package com.example.sporkompleksi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Faydalar extends AppCompatActivity {
    Button anasayfa,fayda,uye,hk;
    NestedScrollView scrol;
    TextView text1,text2,text3,text4,text5,text6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faydalar);

        anasayfa=findViewById(R.id.btnAnasayfa);
        fayda=findViewById(R.id.btnFayda);
        uye=findViewById(R.id.btnUyeSorgu);
        hk=findViewById(R.id.btnHk);
        scrol = findViewById(R.id.disscroll);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);
        text4 = findViewById(R.id.text4);
        text5 = findViewById(R.id.text5);
        text6 = findViewById(R.id.text6);

        setTouchListener(text1);
        setTouchListener(text2);
        setTouchListener(text3);
        setTouchListener(text4);
        setTouchListener(text5);
        setTouchListener(text6);

    }
    /**
     * Belirli bir TextView için dokunma etkileşimlerini yöneten metod.
     * TextView üzerine dokunulduğunda, iç NestedScrollView'ın dokunma etkileşimini etkisiz hale getirir ve dış NestedScrollView'ın dokunma etkileşimini etkinleştirir.
     * TextView'dan el çekildiğinde, iç NestedScrollView'ın dokunma etkileşimini tekrar etkinleştirir.
     */
    private void setTouchListener(final TextView textView) {
        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // İç NestedScrollView'ın dokunma etkileşimini etkisiz hale getir
                scrol.requestDisallowInterceptTouchEvent(true);
                // Dış NestedScrollView'ın dokunma etkileşimini etkinleştir
                textView.getParent().requestDisallowInterceptTouchEvent(false);
                // Eğer dokunma işlemi bittiğinde
                if ((event.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
                    // İç NestedScrollView'ın dokunma etkileşimini tekrar etkinleştir
                    scrol.requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        });
    }

    public void btnAnasayfa(View view){
        Intent intent =new Intent(Faydalar.this, AnaSayfa.class);
        startActivity(intent);
    }
    public void btnFayda(View view){
        Intent intent =new Intent(Faydalar.this, Faydalar.class);
        startActivity(intent);
    }
    public void btnUyeSorgu(View view){
        Intent intent =new Intent(Faydalar.this, UyeSorgu.class);
        startActivity(intent);
    }
    public void btnHk(View view){
        Intent intent =new Intent(Faydalar.this, Hakkimizda.class);
        startActivity(intent);
    }
}