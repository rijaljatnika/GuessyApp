package com.zaid.guessy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterNameActivity extends Activity {

    EditText txtNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        txtNama = (EditText) findViewById(R.id.editNama);
    }
    // Pindah ke Main Menu dan
    // LOGIN ke
    public void submitNama(View view) {
        Intent submitNama = new Intent(EnterNameActivity.this, MainMenuActivity.class);
        submitNama.putExtra(MainMenuActivity.EXTRA_USERNAME, txtNama.getText().toString());
        startActivity(submitNama);
        finish();
    }
}