package com.example.sporkompleksi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class SporSalonu extends AppCompatActivity {
    Button anasayfa,fayda,uye,hk;
    ImageSlider imageSlider1, imageSlider2, imageSlider3, imageSlider4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spor_salonu);
        anasayfa=findViewById(R.id.btnAnasayfa);
        fayda=findViewById(R.id.btnFayda);
        uye=findViewById(R.id.btnUyeSorgu);
        hk=findViewById(R.id.btnHk);
        imageSlider1 = findViewById(R.id.cardImage1);
        imageSlider2 = findViewById(R.id.cardImage2);
        imageSlider3 = findViewById(R.id.cardImage3);
        imageSlider4 = findViewById(R.id.cardImage4);

        ArrayList<SlideModel> SlideModels1=new ArrayList<>();
        SlideModels1.add(new SlideModel(R.drawable.spbir, ScaleTypes.FIT));
        SlideModels1.add(new SlideModel(R.drawable.spbiriki, ScaleTypes.FIT));
        SlideModels1.add(new SlideModel(R.drawable.spbiruc, ScaleTypes.FIT));
        SlideModels1.add(new SlideModel(R.drawable.spbirdort , ScaleTypes.FIT));
        imageSlider1.setImageList(SlideModels1, ScaleTypes.FIT);

        ArrayList<SlideModel> slideModels2 = new ArrayList<>();
        slideModels2.add(new SlideModel(R.drawable.spikibir, ScaleTypes.FIT));
        slideModels2.add(new SlideModel(R.drawable.spikiiki, ScaleTypes.FIT));
        slideModels2.add(new SlideModel(R.drawable.spikiuc, ScaleTypes.FIT));
        imageSlider2.setImageList(slideModels2, ScaleTypes.FIT);

        ArrayList<SlideModel> slideModels3 = new ArrayList<>();
        slideModels3.add(new SlideModel(R.drawable.spucbir, ScaleTypes.FIT));
        slideModels3.add(new SlideModel(R.drawable.spuciki, ScaleTypes.FIT));
        slideModels3.add(new SlideModel(R.drawable.spucuc, ScaleTypes.FIT));
        slideModels3.add(new SlideModel(R.drawable.spucdort, ScaleTypes.FIT));
        imageSlider3.setImageList(slideModels3, ScaleTypes.FIT);

        ArrayList<SlideModel> slideModels4 = new ArrayList<>();
        slideModels4.add(new SlideModel(R.drawable.spdortbir, ScaleTypes.FIT));
        slideModels4.add(new SlideModel(R.drawable.spdortiki, ScaleTypes.FIT));
        slideModels4.add(new SlideModel(R.drawable.spdortuc, ScaleTypes.FIT));
        imageSlider4.setImageList(slideModels4, ScaleTypes.FIT);
    }


    public void btnAnasayfa(View view){
        Intent intent =new Intent(SporSalonu.this, AnaSayfa.class);
        startActivity(intent);
    }
    public void btnFayda(View view){
        Intent intent =new Intent(SporSalonu.this, Faydalar.class);
        startActivity(intent);
    }
    public void btnUyeSorgu(View view){
        Intent intent =new Intent(SporSalonu.this, UyeSorgu.class);
        startActivity(intent);
    }
    public void btnHk(View view){
        Intent intent =new Intent(SporSalonu.this, Hakkimizda.class);
        startActivity(intent);
    }
}