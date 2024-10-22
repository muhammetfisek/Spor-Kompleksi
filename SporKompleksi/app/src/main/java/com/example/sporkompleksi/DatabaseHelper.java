package com.example.sporkompleksi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "kullanici_veritabani.db";
    private static final int DATABASE_VERSION = 1;

    // Tablo oluşturma SQL ifadesi
    private static final String CREATE_TABLE_KULLANICI =
            "CREATE TABLE kullanici (" +
                    "alan TEXT)";
    public Cursor getMemberByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM kullanici WHERE email LIKE ?";
        String[] selectionArgs = new String[]{ "%" + name + "%" };
        return db.rawQuery(query, selectionArgs);

        //Üye Sorgulama Metodu Ekleme
    }
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Tabloyu oluştur
        db.execSQL(CREATE_TABLE_KULLANICI);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS kullanici");
        onCreate(db);
    }

    // Kullanıcı girişini kontrol eden metod
    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM kullanici WHERE email = ? AND password = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password});
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }

    // Kullanıcı arama metodu
    public Cursor searchUsers(String query) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = { "email", "password", "cinsiyet", "alan" };
        String selection = "email LIKE ?";
        String[] selectionArgs = { "%" + query + "%" };
        return db.query("kullanici", projection, selection, selectionArgs, null, null, null);
    }
}