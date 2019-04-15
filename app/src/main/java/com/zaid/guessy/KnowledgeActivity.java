package com.zaid.guessy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KnowledgeActivity extends Activity {
    // Daftar Sub Menu di Knowledge Menu
    Button kembali, pemahaman, fakta, mitos;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);
        // Inisialisasi Tombol NAVIGASI / Sub Menu
        kembali = findViewById(R.id.kembali);
        pemahaman = findViewById(R.id.pemahaman);
        fakta = findViewById(R.id.fakta);
        mitos = findViewById(R.id.mitos);

        // Mengatur tombol kembali agar Kembali ke MainMenu
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Mengatur tombol kembali agar ketika di CLICK dapat bepindah ke Pengertian PMS
        pemahaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paham = new Intent(KnowledgeActivity.this, PemahamanActivity.class);
                startActivity(paham);
                finish();
            }
        });
        // Mengatur tombol kembali agar ketika di CLICK dapat bepindah ke Artikel FAKTA PMS
        fakta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facts = new Intent(KnowledgeActivity.this, FaktaActivity.class);
                startActivity(facts);
            }
        });
        // Mengatur tombol kembali agar ketika di CLICK dapat bepindah ke Artikel MITOS PMS
        mitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myth = new Intent(KnowledgeActivity.this, MitosActivity.class);
                startActivity(myth);
            }
        });
    }
    // Kembali ke Main menu ketika tombol RETURN ditekan
    @Override
    public void onBackPressed() {
        finish();
    }
}