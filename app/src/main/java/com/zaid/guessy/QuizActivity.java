package com.zaid.guessy;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends Activity {

    TextView timer, txtSoal;
    Button btnA, btnB, btnC, btnD;

    public static String EXTRA_NOMOR = "extra_nomor";

    int nomor;
    int skorTambah;

    String[][] soal = {
            {"SOAL1", "A", "B", "D", "C", "C"},
            {"SOAL2", "A", "B", "C", "D", "C"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final Intent intent = getIntent();
        nomor = intent.getIntExtra(EXTRA_NOMOR, 0);
        Toast.makeText(getApplicationContext(), "Nomor Soal : " + Integer.toString(nomor), Toast.LENGTH_SHORT).show();

        txtSoal = (TextView) findViewById(R.id.quiz_question);
        txtSoal.setText(soal[nomor][0]);
        btnA = (Button) findViewById(R.id.a);
        btnA.setText(soal[nomor][1]);
        btnB = (Button) findViewById(R.id.b);
        btnB.setText(soal[nomor][2]);
        btnC = (Button) findViewById(R.id.c);
        btnC.setText(soal[nomor][3]);
        btnD = (Button) findViewById(R.id.d);
        btnD.setText(soal[nomor][4]);

        timer = (TextView) findViewById(R.id.quiz_timer);
        CountDownTimer count = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(Long.toString(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                timer.setText(Long.toString(0));
                Intent intentScore = new Intent(QuizActivity.this, ResultActivity.class);
                startActivity(intentScore);
                finish();
            }
        };
    }

    public void cekJawaban(View v) {
        Button btn = (Button) v;

        // DEBUG
        Toast.makeText(getApplicationContext(), "Jawaban Anda  : " + btn.getText().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Jawaban BENAR : " + soal[nomor][5], Toast.LENGTH_SHORT).show();

        if(btn.getText().toString() == soal[nomor][5]) {
            skorTambah = 20;
            Intent intentScore = new Intent(QuizActivity.this, GameActivity.class);
            intentScore.putExtra(GameActivity.EXTRA_SCORE, skorTambah);
            startActivity(intentScore);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        return;
    }
}
