package com.example.sporkompleksi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnaSayfa extends AppCompatActivity {
Button plan1,plan2,anasayfa,fayda,uye,hk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_sayfa);
        plan1=findViewById(R.id.planibaslat1);
        plan2=findViewById(R.id.planibaslat2);
        anasayfa=findViewById(R.id.btnAnasayfa);
        fayda=findViewById(R.id.btnFayda);
        uye=findViewById(R.id.btnUyeSorgu);
        hk=findViewById(R.id.btnHk);

    }
    public void btnAnasayfa(View view){
        Intent intent =new Intent(AnaSayfa.this, AnaSayfa.class);
        startActivity(intent);
    }
    public void btnFayda(View view){
        Intent intent =new Intent(AnaSayfa.this, Faydalar.class);
        startActivity(intent);
    }
    public void btnUyeSorgu(View view){
        Intent intent =new Intent(AnaSayfa.this, UyeSorgu.class);
        startActivity(intent);
    }
    public void btnHk(View view){
        Intent intent =new Intent(AnaSayfa.this, Hakkimizda.class);
        startActivity(intent);
    }
    public void plan1(View view){
        Intent intent =new Intent(AnaSayfa.this, SporSalonu.class);
        startActivity(intent);
    }
    public void plan2(View view){
        Intent intent =new Intent(AnaSayfa.this, Ev.class);
        startActivity(intent);
    }

}
