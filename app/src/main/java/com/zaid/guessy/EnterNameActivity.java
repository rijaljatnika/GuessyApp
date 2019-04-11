package com.zaid.guessy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EnterNameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);
    }

    public void submitNama(View view) {
        Intent submitNama = new Intent(EnterNameActivity.this, MainMenuActivity.class);
        startActivity(submitNama);
        finish();
    }
}
