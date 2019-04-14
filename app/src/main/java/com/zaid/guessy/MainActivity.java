package com.zaid.guessy;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.ChasingDots;

public class MainActivity extends Activity {

    private static int SPLASH_TIME = 4000;
    ProgressBar loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent start = new Intent(MainActivity.this, GetStartedActivity.class);
                startActivity(start);
                finish();
            }
        }, SPLASH_TIME);

        loading = findViewById(R.id.spinKit);
        ChasingDots dots = new ChasingDots();
        loading.setIndeterminateDrawable(dots);
    }
}
