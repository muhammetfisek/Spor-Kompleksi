package com.example.sporkompleksi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.sql.SQLData;


public class KayitOlSayfasi extends AppCompatActivity {
EditText kayıtemail,kayıtpassword;
RadioGroup cinsiyet;
CheckBox ev , salon;
SQLiteDatabase database;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ol_sayfasi);
        kayıtemail=findViewById(R.id.kayıt_email);
        kayıtpassword=findViewById(R.id.kayıt_password);
        cinsiyet=findViewById(R.id.radioGroup);
        ev=findViewById(R.id.checkEv);
        salon=findViewById(R.id.checkSalon);

        dbHelper = new DatabaseHelper(this);
        database = dbHelper.getWritableDatabase(); // Veritabanını yazma modunda aç
    }
    public void kytOl(View view){
        String kayıtemailStr = kayıtemail.getText().toString(); // 'kayıtemailStr' adında yeni bir değişken kullanıyoruz
        String kayıtpasswordStr = kayıtpassword.getText().toString(); // 'kayıtpasswordStr' adında yeni bir değişken kullanıyoruz
        String cinsiyetStr = ""; // cinsiyeti metin olarak saklamak için boş bir string oluştur
        boolean evDurumu = ev.isChecked(); // ev checkbox'ının durumunu al
        boolean salonDurumu = salon.isChecked(); // salon checkbox'ının durumunu al

        int secilenbuton = cinsiyet.getCheckedRadioButtonId();

        // Seçilen alanları bir metin olarak oluştur
        StringBuilder secilenAlanlar = new StringBuilder();
        if (evDurumu) {
            secilenAlanlar.append("Ev ");
        }
        if (salonDurumu) {
            secilenAlanlar.append("Salon ");
        }
        String alanlarStr = secilenAlanlar.toString(); // Boşlukları temizle


        if (secilenbuton == R.id.erkek) { // erkek seçildiyse
            cinsiyetStr = "Erkek";
        } else if (secilenbuton == R.id.kadin) { // kadın seçildiyse
            cinsiyetStr = "Kadın";
        }

        if (kayıtpasswordStr.isEmpty() || kayıtemailStr.isEmpty() || secilenbuton == -1 || (!evDurumu && !salonDurumu)) { // eğer boşsa hata mesajı veriyoruz
            new AlertDialog.Builder(KayitOlSayfasi.this)
                    .setTitle("Hata")
                    .setMessage("Lütfen bütün alanları doldurunuz!")
                    .setPositiveButton(android.R.string.yes, null)
                    .show();
        }
        else{ // değilse mesaj verdirip

            // Veritabanına ekleme işlemi
            ContentValues values = new ContentValues();
            values.put("email", kayıtemailStr);
            values.put("password", kayıtpasswordStr);
            values.put("cinsiyet", cinsiyetStr);// cinsiyeti metin olarak kaydet
            values.put("alan", alanlarStr); // seçilen alanları metin olarak kaydet
            long newRowId = database.insert("kullanici", null, values);


            AlertDialog.Builder mesaj= new AlertDialog.Builder(KayitOlSayfasi.this);
       mesaj.setTitle("TEBRİKLER"); //Dialog penceresinin başlığı
        mesaj.setMessage("Kayıt olma işlemi başarıyla gerçekleşti.");//Dialog penceresinin mesajı
       mesaj.setPositiveButton("TAMAM", null );
mesaj.show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // 5 saniye bekledikten sonra MainActivity'ye geçiş yap
                    Intent intent =new Intent(KayitOlSayfasi.this, MainActivity.class);
                    startActivity(intent);
                }
            }, 3000); // 5000 milisaniye = 5 saniye
    }
}

}