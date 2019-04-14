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
    // Context Database Adapter
    private final Context context;
    // helper untuk membantu mengolah Database GAME
    private SQLiteDatabaseHelper dbHelper;
    // Database SQLITE
    private SQLiteDatabase db;
    // Kolom dalam Table
    private String[] semuaKolom = {SQLiteDatabaseHelper.KOLOM_ID,
            SQLiteDatabaseHelper.KOLOM_USERNAME,
            SQLiteDatabaseHelper.KOLOM_SCORE
    };

    // Constructor kelas DBAdapter
    public DBAdapter(Context context) {
        this.context = context;
        dbHelper = new SQLiteDatabaseHelper(this.context);
    }

    // Fungsi untuk Membuka Database dan sebagai
    // Awalan untuk Mengolah Table yang ada di dalamnya.
    public DBAdapter open() throws SQLException {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    // Menutup Database
    public void close() {
        dbHelper.close();
    }

    // Menyisipkan skor ke Table SKOR
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

    // Membaca Data PLAYER dari database dan
    // Mengembalikkan Data berupa LIST PLAYER
    public ArrayList<Player> readData() {
        // Deklarasi dan Menginisialisasi Kursor untuk mengolah Tabel SKOR
        Cursor cursor = db.query(SQLiteDatabaseHelper.TABLE_NAME, semuaKolom, null, null, null, null, SQLiteDatabaseHelper.KOLOM_SCORE + " DESC");
        // Menempatkan Kursor ke data paling awal
        // di Tabel tersebut.
        cursor.moveToFirst();
        // List Player
        ArrayList<Player> allData = new ArrayList<>();
        // Menambahkan data PLAYER ke List
        while(! cursor.isAfterLast()) {
            // Inisialisasi Data Plater sesuai dengan data
            // yang ada di Database
            Player dataPlayer = new Player(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    Integer.parseInt(cursor.getString(2))
            );
            // Memberitahukan USERNAME yang telah ditambahkan ke List
            Log.w("INFO", "username = " + dataPlayer.toString());
            // Menempatkan data PLAYER ke LIST
            allData.add(dataPlayer);
            cursor.moveToNext();
        }
        // Menghentikan kursor
        cursor.close();
        // Mengembalikkan List PLAYER yang ada di Database
        return allData;
    }

    // Membaca Data PLAYER dari database dan
    // Mengembalikkan Data berupa LIST PLAYER
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
