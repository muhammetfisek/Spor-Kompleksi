package com.example.sporkompleksi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Hakkimizda extends AppCompatActivity {
Button anasayfa,fayda,uye,hk;
Button btnebyu,btngithub,btninsta,sendButton;
RatingBar ratingBar;
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkimizda);
        btnebyu=findViewById(R.id.ebyu);
        btngithub=findViewById(R.id.github);
        btninsta=findViewById(R.id.insta);
        anasayfa=findViewById(R.id.btnAnasayfa);
        fayda=findViewById(R.id.btnFayda);
        uye=findViewById(R.id.btnUyeSorgu);
        hk=findViewById(R.id.btnHk);
        txt=findViewById(R.id.text11);
        ratingBar = findViewById(R.id.ratingBar);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                Toast.makeText(Hakkimizda.this, "Bizi değerlendirdiğiniz için Teşekkürler " + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void txt(View view){
// EBÜ web sitesi URL'si
        String ebyuWebsites = "https://muhendislik.ebyu.edu.tr/as/bilgisayar-muhendisligi/";

        // Web sayfasını açmak için intent oluştur
        Intent ebyuIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ebyuWebsites));

        // Web tarayıcısını aç
        startActivity(ebyuIntent);
    }
    public void btnebyu(View view){
// EBÜ web sitesi URL'si
        String ebyuWebsite = "https://muhendislik.ebyu.edu.tr/as/bilgisayar-muhendisligi/";

        // Web sayfasını açmak için intent oluştur
        Intent ebyuIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ebyuWebsite));

        // Web tarayıcısını aç
        startActivity(ebyuIntent);
    }
    public void btngithub(View view){
        String githubProfile = "https://github.com/muhammetfisek";
        // GitHub uygulamasını açmak için intent oluştur
        Intent githubIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubProfile));

        // GitHub uygulaması cihazda yüklüyse, onu kullanarak aç
        if (githubIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(githubIntent);
        } else {
            // GitHub uygulaması yoksa, web tarayıcıda aç
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(githubProfile)));
        }
    }
    public void btninsta(View view){
        String instagramProfile = "https://www.instagram.com/muhammetfisekk";


        // Instagram uygulamasını açmak için intent oluştur
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramProfile));

        // Instagram uygulaması cihazda yüklüyse, onu kullanarak aç
        if (instagramIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(instagramIntent);
        } else {
            // Instagram uygulaması yoksa, web tarayıcıda aç
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(instagramProfile)));
        }

        // Tıklama olaylarını ayarlama
        btnebyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnebyu(v);
            }
        });

        btngithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btngithub(v);
            }
        });

        btninsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btninsta(v);
            }
        });
    }
    public void btnAnasayfa(View view){
        Intent intent =new Intent(Hakkimizda.this, AnaSayfa.class);
        startActivity(intent);
    }
    public void btnFayda(View view){
        Intent intent =new Intent(Hakkimizda.this, Faydalar.class);
        startActivity(intent);
    }
    public void btnUyeSorgu(View view){
        Intent intent =new Intent(Hakkimizda.this, UyeSorgu.class);
        startActivity(intent);
    }
    public void btnHk(View view){
        Intent intent =new Intent(Hakkimizda.this, Hakkimizda.class);
        startActivity(intent);
    }
}