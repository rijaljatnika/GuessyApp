package com.zaid.guessy;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class getStarted extends AppCompatActivity {
    //private static int splash = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
    }

    public void started(View view) {
        Intent masukanNama = new Intent(getStarted.this, EnterName.class);
        startActivity(masukanNama);
        finish();
    }
}
