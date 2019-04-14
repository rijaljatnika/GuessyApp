package com.zaid.guessy;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

    Button btnPlayAgain, btnHighScore;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result = (TextView) findViewById(R.id.result);
        result.setText(Integer.toString(GameActivity.SCORE));

        btnHighScore = (Button) findViewById(R.id.high_score);
        btnHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPlayAgain = new Intent(ResultActivity.this, ScoreActivity.class);
                DBAdapter db = new DBAdapter(getApplicationContext());
                db.open();
                long kode = db.insertData(MainMenuActivity.USER_NAME, GameActivity.SCORE);
                if(kode > 0) {
                    Log.w("INFO", "INSERT DATA BERHASIL");
                } else {
                    Log.w("INFO", "INSERT DATA GAGAL");
                }
                db.close();
                startActivity(intentPlayAgain);
            }
        });

        btnPlayAgain = (Button) findViewById(R.id.play_again);
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentPlayAgain = new Intent(ResultActivity.this, GameActivity.class);
                startActivity(intentPlayAgain);
            }
        });
    }
}
