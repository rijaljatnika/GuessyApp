package com.zaid.guessy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ScoreActivity extends Activity {

    private ListView listScore;
    private DBAdapter db;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        db = new DBAdapter(this);
        db.open();
        list = new ArrayList<String>();
        list.addAll(db.getAllData());
        listScore = (ListView) findViewById(R.id.list_high_score);
        ArrayAdapter<String> adapterScore = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1, list
        );
        listScore.setAdapter(adapterScore);
        db.close();
    }
}
