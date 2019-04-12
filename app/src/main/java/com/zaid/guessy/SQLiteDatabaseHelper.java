package com.zaid.guessy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db_guess.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "score_board";
    public static final String KOLOM_ID = "id_score";
    public static final String KOLOM_USERNAME = "username";
    public static final String KOLOM_SCORE = "skor";

    public SQLiteDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " ( " +
                KOLOM_ID + " INTEGER NOT NULL AUTOINCREMENT PRIMARY KEY, " +
                KOLOM_USERNAME + " VARCHAR(100) NOT NULL, " +
                KOLOM_SCORE + " INTEGER NOT NULL " +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("DB Adapter", "Upgrade database dari versi " + oldVersion + " ke " +
                newVersion + ", akan menghapus semua data lama ?");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
