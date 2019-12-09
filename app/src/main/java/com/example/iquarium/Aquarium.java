package com.example.iquarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Aquarium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquarium);

        Button timer = findViewById(R.id.timer);
        timer.setOnClickListener(v -> {
            startActivity(new Intent(this, Timer.class));
        });
        Button profile = findViewById(R.id.profile);
        profile.setOnClickListener(v -> {
            startActivity(new Intent(this, Profile.class));
        });
        getIntent();
        ImageView red = findViewById(R.id.imageViewRed);
        ImageView yellow = findViewById(R.id.imageViewYellow);
        ImageView blue = findViewById(R.id.imageViewBlue);
        ImageView weed = findViewById(R.id.imageViewSeaweed);
        ImageView star = findViewById(R.id.imageViewStarfish);
        SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(v -> {
            sharedPrefs.edit().clear().apply();
            red.setVisibility(View.INVISIBLE);
            yellow.setVisibility(View.INVISIBLE);
            blue.setVisibility(View.INVISIBLE);
            weed.setVisibility(View.INVISIBLE);
            star.setVisibility(View.INVISIBLE);

        });
        String redOne = sharedPrefs.getString("redFish", "");
        if (redOne.equals("redFish")) {
            red.setVisibility(View.VISIBLE);
        }
        String yellowOne = sharedPrefs.getString("yellowFish", "");
        if (yellowOne.equals("yellowFish")) {
            yellow.setVisibility(View.VISIBLE);
        }
        String blueOne = sharedPrefs.getString("blueFish", "");
        if (blueOne.equals("blueFish")) {
            blue.setVisibility(View.VISIBLE);
        }
        String seaOne = sharedPrefs.getString("seaWeed", "");
        if (seaOne.equals("seaWeed")) {
            weed.setVisibility(View.VISIBLE);
        }
        String starOne = sharedPrefs.getString("starFish", "");
        if (starOne.equals("starFish")) {
            star.setVisibility(View.VISIBLE);
        }
    }
}
