package com.zaid.guessy;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ProgressBar;

// Tampilan Loading
import com.github.ybq.android.spinkit.style.ChasingDots;

public class MainActivity extends Activity {
    // Interval Waktu Loading
    private static int SPLASH_TIME = 4000;

    // Loading View
    ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menunggu selama SPLASH_TIME milliseconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Pindah ke Tampilan Getting Started
                Intent start = new Intent(MainActivity.this, GetStartedActivity.class);
                startActivity(start);
                // Menutup Activity
                finish();
            }
        }, SPLASH_TIME);
        // Mengubah tampilan Loading
        loading = findViewById(R.id.spinKit);
        ChasingDots dots = new ChasingDots();
        loading.setIndeterminateDrawable(dots);
    }
}
