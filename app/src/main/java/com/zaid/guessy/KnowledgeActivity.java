package com.zaid.guessy;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KnowledgeActivity extends AppCompatActivity {

    Button kembali, pemahaman, fakta, mitos;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);

        kembali = findViewById(R.id.kembali);
        pemahaman = findViewById(R.id.pemahaman);
        fakta = findViewById(R.id.fakta);
        mitos = findViewById(R.id.mitos);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent balik = new Intent(KnowledgeActivity.this, MainMenuActivity.class);
                startActivity(balik);
                finish();
            }
        });

        pemahaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paham = new Intent(KnowledgeActivity.this, PemahamanActivity.class);
                startActivity(paham);
                finish();
            }
        });

        fakta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facts = new Intent(KnowledgeActivity.this, FaktaActivity.class);
                startActivity(facts);
            }
        });

        mitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myth = new Intent(KnowledgeActivity.this, MitosActivity.class);
                startActivity(myth);
            }
        });
    }
}
