package com.zaid.guessy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EnterName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);
    }

    public void submitNama(View view) {
        Intent submitNama = new Intent(EnterName.this, MainMenu.class);
        startActivity(submitNama);
        finish();
    }
}
