package com.zaid.guessy;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PemahamanActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemahaman);
    }
    // Menutup Pemahaman dan Kembali ke Main Menu
    @Override
    public void onBackPressed() {
        finish();
    }
}
