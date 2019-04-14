package com.zaid.guessy;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainMenuActivity extends Activity {
    LinearLayout gameMenu, knowledgeMenu, profileMenu, ratingMenu, scoreMenu, exitMenu;
    TextView username;
    public static String EXTRA_USERNAME = "extra_username";
    public static String USER_NAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // username
        Intent terimaNama = getIntent();
        USER_NAME = terimaNama.getStringExtra(EXTRA_USERNAME);

        username = (TextView) findViewById(R.id.welcome_nama);
        username.setText(USER_NAME);

        //card board
        gameMenu = findViewById(R.id.gameBoard);
        gameMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameIntent = new Intent(MainMenuActivity.this, GameActivity.class);
                startActivity(gameIntent);
            }
        });
        // knowledgeCard
        knowledgeMenu = findViewById(R.id.knowledge);
        knowledgeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent knowledgeIntent = new Intent(MainMenuActivity.this, KnowledgeActivity.class);
                startActivity(knowledgeIntent);
            }
        });

        //Rating Card
        ratingMenu = findViewById(R.id.rating);
        ratingMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ratingIntent = new Intent(MainMenuActivity.this, RatingActivity.class);
                startActivity(ratingIntent);
            }
        });

        // Score Card
        scoreMenu = findViewById(R.id.score);
        scoreMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scoreIntent = new Intent(MainMenuActivity.this, ScoreActivity.class);
                startActivity(scoreIntent);
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
