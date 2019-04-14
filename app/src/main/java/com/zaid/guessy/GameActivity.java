package com.zaid.guessy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.VibrationEffect;
import android.os.Vibrator;
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

    // GAME BOARD
    GridView board;
    // WAKTU
    TextView waktu;
    // Pemutar Suara
    MediaPlayer suara;
    // Timer Hitung Mundur
    CountDownTimer timer;
    // Tombol Navigasi Back dan Resey
    Button btnBack, btnReset;
    // Deklarasi banyak Kolom Grid dan Jumlah Total Grid
    int numColumn, jumlahGrid;
    // LUCKY GRID
    int jawabanGrid;
    //
    public static int numCount;
    public ArrayList<Integer> luckyGrid = new ArrayList<>();

    public static int SCORE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Inisialisasi Nilai Awal
        numCount = 10;
        numColumn = 5;
        // Menghitung Jumlah Grid Total
        jumlahGrid = numColumn * numColumn;
        // Merandom LUCKY GRID
        for (int i = 0; i < 10; i++) {
            // MengacakAngka yang belum terjawab
            jawabanGrid = randomAngka(jumlahGrid);
            if(luckyGrid.contains(jawabanGrid)) {
                jawabanGrid = randomAngka(jumlahGrid);
                luckyGrid.add(jawabanGrid);
            } else {
                luckyGrid.add(jawabanGrid);
            }
        }
        // [DEBUG] Lucky Grid
         Toast.makeText(getApplicationContext(), Integer.toString(jawabanGrid), Toast.LENGTH_SHORT).show();

        // Mengatur Back Button ketika ditekan (CLICK)
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Mengatur Reset Button ketika ditekan (CLICK)
        btnReset = (Button) findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
        // Mengatur Hitungan Mundur
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
        // Mengatur Jumlah Kolom GRID
        board = (GridView) findViewById(R.id.board);
        board.setNumColumns(numColumn);

        // Menambahkan GRID ke list GRID
        Integer[] nums = {};
        final List<Integer> numberList = new ArrayList<Integer>(Arrays.asList(nums));
        for(int i = 1; i < jumlahGrid + 1; i++) {
            numberList.add(i);
        }
        // Menambahkan GRID yang ada ke GAME BOARD
        board.setAdapter(new ArrayAdapter<Integer>(this, R.layout.activity_game, numberList){
            public View getView(int position, View convertView, ViewGroup parent) {

                Context context = getContext();
                Button grid;
                // Mengecek apakah
                if(convertView == null) {
                    // Inisialisasi GRID jika bernilai NULL
                    grid = new Button(context);
                    // Mengatur Lebar dan Panjang Grid agar sama panjang
                    int h = context.getResources().getDisplayMetrics().widthPixels/numColumn;
                    grid.setLayoutParams(new GridView.LayoutParams(h, h));
                    grid.setPadding(1, 1, 1, 1);
                } else {
                    // Inisialisasi GRID jika tidak bernilai NULL
                    grid = (Button) convertView;
                }
                // Mengatur Grid ketika di CLICK, sehingga
                // Ketika di CLICK akan diketahui apakah GRID
                // Merupakan LUCKY GRID
                grid.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gridClick(v);
                    }
                });
                // Mengatur Text dari GRID Button sesuai dengan POSISI nomor nya
                grid.setText(numberList.get(position).toString());
                // Mengatur Warna Background menjadi PUTIH
                grid.setBackgroundColor(Color.WHITE);
                // Mengatur WARNA TEXT menjadi WARNA PRIMER APLIKASI
                grid.setTextColor(getResources().getColor(R.color.colorPrimary));
                // Mengembalikan GRID
                return grid;
            }
        });
    }

    public void gridClick(View view) {
        /*
         * Fungsi untuk Mengecek apakah grid yang di CLICK
         * merupakan TEBAKAN (GRID) yang benar;
         * Jika
         */

        // Inisialisasi Button Grid
        // Mengubah view menjadi button
        Button btnSelect = (Button) view;
        // Jika Grid sudah terpilih/tertekan
        // maka tidak akan terjadi apa2
        if(btnSelect.getCurrentTextColor() == Color.TRANSPARENT) {
            return;
        }

//        terjawab.add(Integer.parseInt(btnSelect.getText().toString()));

        // Meminta Service Getaran
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        // Merubah Warna Latar Menjadi ABU GELAP
        btnSelect.setBackgroundColor(Color.DKGRAY);
        // Merubah Warna Teks Menjadi TRANSAPARAN
        btnSelect.setTextColor(Color.TRANSPARENT);

        // Mengambil Angka pada Grid
        int nomor = Integer.parseInt(((Button) view).getText().toString());
        // Cek Kesesuaian Jawaban User dengan Jawaban Sebenarnya
        if(luckyGrid.contains(nomor)) {
            // Jika Jawaban Benar
//            Toast.makeText(getApplicationContext(), "Jawaban Anda Benar", Toast.LENGTH_SHORT).show();
            suara = MediaPlayer.create(this, R.raw.correct);
            timer.cancel();
            // Menambah Point
            SCORE += 20;
            btnSelect.setBackground(this.getResources().getDrawable(R.drawable.heart));
        } else {
            // Jika Jawaban Salah
            Toast.makeText(getApplicationContext(), "Jawaban Anda Salah", Toast.LENGTH_SHORT).show();
            suara = MediaPlayer.create(this, R.raw.wrong);
            btnSelect.setBackground(this.getResources().getDrawable(R.drawable.close));
            // Menambah jumlah nomor yang telah salah
            numCount--;
        }

        suara.setLooping(false);
        suara.start();
        // Cek SDK Version Device yang dipakai USER
        // melakukan getaran
        if (Build.VERSION.SDK_INT >= 26) {
            vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            vibrator.vibrate(1000);
        }

        // Jika jumlah
        if(numCount == 0) {
            Intent intentScore = new Intent(GameActivity.this, ResultActivity.class);
            startActivity(intentScore);
            finish();
        }
    }

    // Mengacak LUCKY GRID
    public static int randomAngka(int maks) {
        Random random = new Random();
        int angka = random.nextInt(maks) + 1;
        return angka;
    }

    // Memulai Kembali Game
    public void resetGame() {
        Intent intentReset = new Intent(GameActivity.this, GameActivity.class);
        finish();
        startActivity(intentReset);
    }
//    // Inisialisasi GAME
//    public void initGame(GridView gv) {
//        int grids = gv.getChildCount();
//        for (int i = 0; i < grids; i++) {
//            Button btn = (Button) gv.getChildAt(i);
//            btn.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//            btn.setTextColor(Color.WHITE);
//        }
//    }

    @Override
    public void onBackPressed() {
        /*
         * Fungsi ketika Tombol RETURN ditekan maka
         *      tidak Akan Langsung Keluar dari Aplikasi
         */
        super.onBackPressed();

    }
}