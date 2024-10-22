package com.example.sporkompleksi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UyeSorgu extends AppCompatActivity {
    Button anasayfa,fayda,uye,hk;
    DatabaseHelper dbHelper;
    EditText editTextSearch;
    ListView listViewResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uye_sorgu);
        anasayfa=findViewById(R.id.btnAnasayfa);
        fayda=findViewById(R.id.btnFayda);
        uye=findViewById(R.id.btnUyeSorgu);
        hk=findViewById(R.id.btnHk);

        dbHelper = new DatabaseHelper(this);
        editTextSearch = findViewById(R.id.signup_password);
        listViewResults = findViewById(R.id.liste);

        editTextSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    searchUsers(editTextSearch.getText().toString());
                    return true;
                }
                return false;
            }
        });

    }
    public void btnAnasayfa(View view){
        Intent intent =new Intent(UyeSorgu.this, AnaSayfa.class);
        startActivity(intent);
    }
    public void btnFayda(View view){
        Intent intent =new Intent(UyeSorgu.this, Faydalar.class);
        startActivity(intent);
    }
    public void btnUyeSorgu(View view){
        Intent intent =new Intent(UyeSorgu.this, UyeSorgu.class);
        startActivity(intent);
    }
    public void btnHk(View view){
        Intent intent =new Intent(UyeSorgu.this, Hakkimizda.class);
        startActivity(intent);
    }

    private void searchUsers(String query) {
        Cursor cursor = null;
        try {
            cursor = dbHelper.searchUsers(query);
            ArrayList<String> dataList = new ArrayList<>();

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String email = cursor.getString(cursor.getColumnIndexOrThrow("email"));
                    String password = cursor.getString(cursor.getColumnIndexOrThrow("password"));
                    String cinsiyet = cursor.getString(cursor.getColumnIndexOrThrow("cinsiyet"));
                    String alan = cursor.getString(cursor.getColumnIndexOrThrow("alan"));
                    dataList.add("Email: " + email + " - Password: " + password + " - Cinsiyet: " + cinsiyet + " - Alan: " + alan);
                } while (cursor.moveToNext());
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);
            listViewResults.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Veri arama işlemi sırasında bir hata oluştu: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}