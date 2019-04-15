package com.zaid.guessy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ScoreActivity extends Activity {
    // LIST SCORE
    private ListView listScore;
    // Adapter Database
    private DBAdapter db;
    // List
    private ArrayList<Player> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        // Inisialiasi Database Adapater
        db = new DBAdapter(this);
        // Membuka Database
        db.open();
        // Membuat List Score Player
        list = new ArrayList<Player>();
        // Mengambil Data dari database kemudian
        // Menambahkannya ke List
        list.addAll(db.readData());

        // Inisialisasi List Score
        listScore = (ListView) findViewById(R.id.list_high_score);
        // Menambahkan List ke List Score sesuai dengan format
        // format di list_score.xml
        listScore.setAdapter(new PlayerAdapter(this, R.layout.list_score, list));
        // Menutup Database
        db.close();
    }
}