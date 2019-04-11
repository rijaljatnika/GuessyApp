package com.zaid.guessy;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;

public class MainMenuActivity extends Activity {
    LinearLayout gameMenu, knowledgeMenu, profileMenu, ratingMenu, scoreMenu, exitMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //card board
        gameMenu = findViewById(R.id.gameBoard);
        gameMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameIntent = new Intent(MainMenuActivity.this, GameActivity.class);
                startActivity(gameIntent);
                finish();
            }
        });
        // knowledgeCard
        knowledgeMenu = findViewById(R.id.knowledge);
        knowledgeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent knowledgeIntent = new Intent(MainMenuActivity.this, KnowledgeActivity.class);
                startActivity(knowledgeIntent);
                finish();
            }
        });

        // profile Card
        profileMenu = findViewById(R.id.profile);
        profileMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(MainMenuActivity.this, ProfileActivity.class);
                startActivity(profileIntent);
                finish();
            }
        });

        //Rating Card
        ratingMenu = findViewById(R.id.rating);
        ratingMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ratingIntent = new Intent(MainMenuActivity.this, RatingActivity.class);
                startActivity(ratingIntent);
                finish();
            }
        });

        // Score Card
        scoreMenu = findViewById(R.id.score);
        scoreMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreIntent = new Intent(MainMenuActivity.this, ScoreActivity.class);
                startActivity(scoreIntent);
                finish();
            }
        });

        //Exit
        exitMenu = (LinearLayout) findViewById(R.id.exit);
        exitMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
