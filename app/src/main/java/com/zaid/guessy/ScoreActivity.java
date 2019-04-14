package com.zaid.guessy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ScoreActivity extends Activity {

    private ListView listScore;
    private DBAdapter db;
    private ArrayList<Player> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        db = new DBAdapter(this);
        db.open();
        list = new ArrayList<Player>();
        list.addAll(db.readData());
        listScore = (ListView) findViewById(R.id.list_high_score);
        listScore.setAdapter(new PlayerAdapter(this, R.layout.list_score, list));
        db.close();
    }
}