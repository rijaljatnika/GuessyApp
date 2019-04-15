package com.zaid.guessy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Class untuk Membantu dalam Pengolahan Isi database Game
public class SQLiteDatabaseHelper extends SQLiteOpenHelper {
    // Nama Database
    private static final String DATABASE_NAME = "db_guess.db";
    // Versi Database
    private static final int DATABASE_VERSION = 1;
    // Nama Table SKOR
    public static final String TABLE_NAME = "score_board";
    // kolom ID
    public static final String KOLOM_ID = "id_score";
    // kolom USERNAME
    public static final String KOLOM_USERNAME = "username";
    // kolom SCORE
    public static final String KOLOM_SCORE = "skor";

//    // Nama Table Player
//    public static final String TABLE_USER = "player";
//    // kolom Password
//    public static final String KOLOM_PASSWORD = "skor";

    public SQLiteDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Skrip SQL untuk membuat Table SKOR Jika Belum ada
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( " +
                KOLOM_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                KOLOM_USERNAME + " VARCHAR(100) NOT NULL, " +
                KOLOM_SCORE + " INTEGER NOT NULL" +
                ")";
        // Mengekseskusi Skrip
        db.execSQL(sql);

//        // Skrip SQL untuk membuat Table PLAYER Jika Belum ada
//        sql = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + " ( " +
//                KOLOM_USERNAME + " VARCHAR(100) NOT NULL PRIMARY KEY, " +
//                KOLOM_PASSWORD + " VARCHAR(50) NOT NULL" +
//                ")";
//        // Mengekseskusi Skrip
//        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("DB Adapter", "Upgrade database dari versi " + oldVersion + " ke " +
                newVersion + ", akan menghapus semua data lama ?");
        // Menghapus TABLE SKOR
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//        // Menghapus TABLE PLAYER
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        onCreate(db);
    }
}