package com.zaid.guessy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DBAdapter {

    private final Context context;
    private SQLiteDatabaseHelper dbHelper;
    private SQLiteDatabase db;
    private String[] semuaKolom = {SQLiteDatabaseHelper.KOLOM_ID,
            SQLiteDatabaseHelper.KOLOM_USERNAME,
            SQLiteDatabaseHelper.KOLOM_SCORE};

    public DBAdapter(Context context) {
        this.context = context;
        dbHelper = new SQLiteDatabaseHelper(this.context);
    }

    public DBAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long insertData(String nama, int skor) {
        ContentValues values = new ContentValues();
        values.put(SQLiteDatabaseHelper.KOLOM_USERNAME, nama);
        values.put(SQLiteDatabaseHelper.KOLOM_SCORE, skor);

        return db.insert(SQLiteDatabaseHelper.TABLE_NAME, null, values);
    }

    public ArrayList<String> getAllData() {
        ArrayList<String> allData = new ArrayList<String>();
        Cursor cursor = db.query(SQLiteDatabaseHelper.TABLE_NAME, semuaKolom, null, null, null, null, SQLiteDatabaseHelper.KOLOM_SCORE + " DESC");
        cursor.moveToFirst();
        while(! cursor.isAfterLast()) {
            String data = cursor.getString(1).concat("\t|\t" + cursor.getString(2));
            Log.w("INFO", "username = " + data);
            allData.add(data);
            cursor.moveToNext();
        }
        cursor.close();

        return allData;
    }
}
