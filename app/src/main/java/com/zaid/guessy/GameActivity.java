package com.zaid.guessy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;

public class GameActivity extends Activity {

    GridView board;
    TextView waktu;
    MediaPlayer suara;
    CountDownTimer timer;
    Button btnBack, btnReset;

    int numColumn, jumlahGrid;
    int jawabanGrid;
    public static int numCount;
    public static int SCORE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        numCount = 0;
        numColumn = 5;
        jumlahGrid = numColumn * numColumn;
        jawabanGrid = randomAngka(jumlahGrid);
        Toast.makeText(getApplicationContext(), Integer.toString(jawabanGrid), Toast.LENGTH_SHORT).show();

        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        waktu = (TextView) findViewById(R.id.textTimer);
        timer =  new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                waktu.setText(Long.toString(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                waktu.setText(Integer.toString(0));
                Toast.makeText(getApplicationContext(), "Waktu Habis", Toast.LENGTH_SHORT).show();
            }
        }.start();

        board = (GridView) findViewById(R.id.board);
        board.setNumColumns(numColumn);

        Integer[] nums = {};

        final List<Integer> numberList = new ArrayList<Integer>(Arrays.asList(nums));
        for(int i = 1; i < jumlahGrid + 1; i++) {
            numberList.add(i);
        }

        board.setAdapter(new ArrayAdapter<Integer>(this, R.layout.activity_game, numberList){
            public View getView(int position, View convertView, ViewGroup parent) {

                Context mContext = getContext();

                Button grid;
                if(convertView == null) {
                    grid = new Button(mContext);
                    int h = mContext.getResources().getDisplayMetrics().widthPixels/numColumn;
                    grid.setLayoutParams(new GridView.LayoutParams(h, h));
                    grid.setPadding(1, 1, 1, 1);
                } else {
                    grid = (Button) convertView;
                }

                grid.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gridClick(v);
                    }
                });
                grid.setText(numberList.get(position).toString());
                grid.setBackgroundColor(Color.WHITE);
                grid.setTextColor(getResources().getColor(R.color.colorPrimary));
                return grid;
            }
        });
    }

    public void gridClick(View view) {
        Button btnSelect = (Button) view;

        if(btnSelect.getCurrentTextColor() == Color.WHITE) {
            return;
        }

        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        btnSelect.setBackgroundColor(Color.DKGRAY);
        btnSelect.setTextColor(Color.WHITE);

        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            vibrator.vibrate(1000);
        }

        int nomor = Integer.parseInt(((Button) view).getText().toString());
        if(nomor == jawabanGrid) {
            Toast.makeText(getApplicationContext(), "Jawaban Anda Benar", Toast.LENGTH_SHORT).show();
            timer.cancel();
            SCORE += 20;
            jawabanGrid = randomAngka(jumlahGrid);
        } else {
            Toast.makeText(getApplicationContext(), "Jawaban Anda Salah", Toast.LENGTH_SHORT).show();
        }

        ++numCount;

        if(numCount == 5) {
            Intent intentScore = new Intent(GameActivity.this, ResultActivity.class);
            startActivity(intentScore);
        }
    }

    public int randomAngka(int maks) {
        Random random = new Random();
        int angka = random.nextInt(maks) + 1;
        return angka;
    }

    public void resetGame() {
        Intent intentReset = new Intent(GameActivity.this, GameActivity.class);
        finish();
        startActivity(intentReset);
    }
}