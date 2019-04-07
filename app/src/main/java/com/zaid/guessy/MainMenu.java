package com.zaid.guessy;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RatingBar;

public class MainMenu extends AppCompatActivity {
    CardView gameCard, knowledgeCard, profileCard, ratingCard, scoreCard, exitCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //card board
        gameCard = findViewById(R.id.gameBoard);
        gameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gamestart = new Intent(MainMenu.this, GameActivity.class);
                startActivity(gamestart);
                finish();
            }
        });
        // knowledgeCard
        gameCard = findViewById(R.id.knowledge);
        gameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gamestart = new Intent(MainMenu.this, KnowledgeActivity.class);
                startActivity(gamestart);
                finish();
            }
        });

        // profile Card
        gameCard = findViewById(R.id.profile);
        gameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gamestart = new Intent(MainMenu.this, ProfileActivity.class);
                startActivity(gamestart);
                finish();
            }
        });

        //Rating Card
        gameCard = findViewById(R.id.rating);
        gameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ratingstart = new Intent(MainMenu.this, RatingActivity.class);
                startActivity(ratingstart);
                finish();
            }
        });

        // Score Card
        gameCard = findViewById(R.id.score);
        gameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gamestart = new Intent(MainMenu.this, ScoreActivity.class);
                startActivity(gamestart);
                finish();
            }
        });

        //Exit

    }

    public void gameStart(View view) {

    }
}
