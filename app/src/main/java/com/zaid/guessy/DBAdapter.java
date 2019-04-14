package com.zaid.guessy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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

//    public void search(String table, String nama, String fromTable int skor) {
//        Cursor cursor = db.rawQuery("SELECT * FROM " + table +
//                " WHERE " +  + " = " +  + " AND ",null);
//        cursor.moveToFirst();
//        String hasil;
//        while(! cursor.isAfterLast()) {
//            hasil = cursor.getString(cursor.getColumnIndex(SQLiteDatabaseHelper.KOLOM_SCORE));
//        }
//
//        return hasil;
//    }

    public ArrayList<Player> readData() {
        Cursor cursor = db.query(SQLiteDatabaseHelper.TABLE_NAME, semuaKolom, null, null, null, null, SQLiteDatabaseHelper.KOLOM_SCORE + " DESC");
        cursor.moveToFirst();

        ArrayList<Player> allData = new ArrayList<>();

        while(! cursor.isAfterLast()) {
            Player dataPlayer = new Player(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    Integer.parseInt(cursor.getString(2))

            );
            Log.w("INFO", "username = " + dataPlayer.toString());
            allData.add(dataPlayer);
            cursor.moveToNext();
        }
        cursor.close();

        return allData;
    }

    public ArrayList<String> getAllData() {

        Cursor cursor = db.query(SQLiteDatabaseHelper.TABLE_NAME, semuaKolom, null, null, null, null, SQLiteDatabaseHelper.KOLOM_SCORE + " DESC");
        cursor.moveToFirst();

        ArrayList<String> allData = new ArrayList<>();

        while(! cursor.isAfterLast()) {
            String data = cursor.getString(1).concat("\t|\t".concat(cursor.getString(2)));
            Log.w("INFO", "username = " + data);
            allData.add(data);
            cursor.moveToNext();
        }
        cursor.close();

        return allData;
    }
}
