package com.zaid.guessy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainMenuActivity extends Activity {

    // MENU : GAME, KNOWLEDGE, PROFILE, RATING, SCORE, dan EXIT
    LinearLayout gameMenu, knowledgeMenu, profileMenu, ratingMenu, scoreMenu, exitMenu;
    // TAMPILAN USERNAME
    TextView username;
    // EXTRA USERNAME
    public static String EXTRA_USERNAME = "extra_username";
   // USERNAME PLAYER yang sedang main
    public static String USER_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Mengatur Username dari PLAYER yang masuk ke APlikasi
        Intent terimaNama = getIntent();
        USER_NAME = terimaNama.getStringExtra(EXTRA_USERNAME);
        // Menampilkan Username Player
        username = (TextView) findViewById(R.id.welcome_nama);
        username.setText(USER_NAME);

        //card board
        // Pindah ke Menu GAME Guessy
        // untuk mulai Memainkan GAME
        gameMenu = findViewById(R.id.gameBoard);
        gameMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameIntent = new Intent(MainMenuActivity.this, GameActivity.class);
                startActivity(gameIntent);
            }
        });
        // knowledgeCard
        // Pindah ke Menu Knowledge
        // untuk Membaca Materi tentang Quiz
        knowledgeMenu = findViewById(R.id.knowledge);
        knowledgeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent knowledgeIntent = new Intent(MainMenuActivity.this, KnowledgeActivity.class);
                startActivity(knowledgeIntent);
            }
        });

        //Rating Card
        // Pindah ke Menu RATING
        // untuk memberikan RATING PLAYER terhadap GAME
        ratingMenu = findViewById(R.id.rating);
        ratingMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ratingIntent = new Intent(MainMenuActivity.this, RatingActivity.class);
                startActivity(ratingIntent);
            }
        });

        // Score Card
        // Pindah ke Menu SCORE
        // untuk melihat Papan SCORE
        scoreMenu = findViewById(R.id.score);
        scoreMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreIntent = new Intent(MainMenuActivity.this, ScoreActivity.class);
                startActivity(scoreIntent);
            }
        });

        //Exit
        // Pindah ke Menu Exit
        // untuk keluar dari Aplikasi
        exitMenu = (LinearLayout) findViewById(R.id.exit);
        exitMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Menampilkan Dialog Keluar dari Aplikasi
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        /*
         * Fungsi untuk memanggil Dialog keputusan
         * keluar(Logout) atau tidak nya User
         */

        // Menampilkan Dialog Konfirmasi Keluar
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Mengatur Pesan Konfirmasi Keluar
        builder.setMessage("Ingin Keluar Dari Aplikasi?")
                .setCancelable(false)
                // Mengatur Tombol YA jika Benar ingin Keluar
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                // Mengatur Tombol TIDAK jika tidak ingin Keluar
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                // Menampilkan Dialog
                .show();
    }
}
