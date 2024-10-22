package com.example.sporkompleksi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText mail,sifre;

DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=findViewById(R.id.signup_email);
      sifre=findViewById(R.id.signup_password);
        dbHelper = new DatabaseHelper(this);
        // Şifre EditText'ine dokunma olayı dinleyicisini ekleyin
        sifre.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2; // drawableEnd için belirli bir konum
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (sifre.getRight() - sifre.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // İkonun olduğu alana dokunulduğunda
                        if (sifre.getTransformationMethod() == PasswordTransformationMethod.getInstance()) {
                            // Şifre gizliyse, göster
                            sifre.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        } else {
                            // Şifre görünürse, gizle
                            sifre.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                        return true;
                    }
                }
                return false;
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        // giriş sayfasına geri dönüldüğünde e-mail ve şifre alanlarını temizler
        sifre.setText("");
       mail.setText("");
    }
    public void Giris(View view){

        String mailStr = mail.getText().toString(); // 'kayıtemailStr' adında yeni bir değişken kullanıyoruz
        String sifreStr = sifre.getText().toString(); // 'kayıtpasswordStr' adında yeni bir değişken kullanıyoruz

        if (mailStr.isEmpty() || sifreStr.isEmpty()) { // eğer boşsa hata mesajı veriyoruz
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Hata")
                    .setMessage("Email veya şifre boş bırakılamaz!")
                    .setPositiveButton(android.R.string.yes, null)
                    .show();
        } else {
            boolean isValid = dbHelper.checkUser(mailStr, sifreStr);
            if (isValid) {
                Intent intent = new Intent(MainActivity.this, AnaSayfa.class);
                startActivity(intent);
            } else {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Hata")
                        .setMessage("Hatalı kullanıcı adı veya şifre!")
                        .setPositiveButton(android.R.string.yes, null)
                        .show();
            }
        }
    }

    public void KayıtOl(View view){
        Intent intent=new Intent(MainActivity.this, KayitOlSayfasi.class);
        startActivity(intent);
    }
}