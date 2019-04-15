package com.zaid.guessy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends Activity {

    //Deklarasi Variable
    RatingBar ratingBar;
    TextView hasilRating;
    Button btnRating;
    String value;
    ImageView ekspresi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        ratingBar = findViewById(R.id.ratingBar);
        hasilRating = findViewById(R.id.hasilRating);
        btnRating = findViewById(R.id.submit);
        ekspresi = findViewById(R.id.ekspresi);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                value = String.valueOf((int) (ratingBar.getRating()));

                if (value.equals("1")) {
                    hasilRating.setText("Astaga!");
                    ekspresi.setImageResource(R.drawable.satu);
                } else if (value.equals("2")) {
                    hasilRating.setText("Sedih");
                    ekspresi.setImageResource(R.drawable.dua);
                } else if (value.equals("3")) {
                    hasilRating.setText("Biasa aja");
                    ekspresi.setImageResource(R.drawable.tiga);
                } else if (value.equals("4")) {
                    hasilRating.setText("Bagus");
                    ekspresi.setImageResource(R.drawable.empat);
                } else if (value.equals("5")) {
                    hasilRating.setText("Keren");
                    ekspresi.setImageResource(R.drawable.lima);
                }
            }
        });

        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Terimaskasih", Toast.LENGTH_LONG).show();
            }
        });

    }
}
