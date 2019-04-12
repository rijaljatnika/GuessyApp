package com.zaid.guessy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GetStartedActivity extends Activity {
    //private static int splash = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
    }

    public void started(View view) {
        Intent masukanNama = new Intent(GetStartedActivity.this, EnterNameActivity.class);
        startActivity(masukanNama);
        finish();
    }
}
