package com.zaid.guessy;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MitosActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitos);
    }

    // Menutup Pemahaman dan Kembali ke Main Menu
    @Override
    public void onBackPressed() {
        finish();
    }
}
