package com.example.iquarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();
        setContentView(R.layout.activity_shop);
        Button aquarium = findViewById(R.id.aquarium);
        aquarium.setOnClickListener(v -> {
            startActivity(new Intent(this, Aquarium.class));
        });
        Button timer = findViewById(R.id.timer);
        timer.setOnClickListener(v -> {
            startActivity(new Intent(this, Timer.class));
        });
        Button profile = findViewById(R.id.profile);
        profile.setOnClickListener(v -> {
            startActivity(new Intent(this, Profile.class));
        });
        Intent aquariumIntent = new Intent(this, Aquarium.class);
        Button fishRed = findViewById(R.id.fish_red);
        fishRed.setOnClickListener(v -> {
            editor.putString("redFish", "redFish");
            editor.apply();
            Toast.makeText(this, "Red fish added", Toast.LENGTH_SHORT).show();
            startActivity(aquariumIntent);
        });

        Button fishBlue = findViewById(R.id.fish_blue);
        fishBlue.setOnClickListener(v -> {
            editor.putString("blueFish", "blueFish");
            editor.apply();
            Toast.makeText(this, "Blue fish added", Toast.LENGTH_SHORT).show();
            startActivity(aquariumIntent);
        });

        Button fishYellow = findViewById(R.id.fish_yellow);
        fishYellow.setOnClickListener(v -> {
            editor.putString("yellowFish", "yellowFish");
            editor.apply();
            Toast.makeText(this, "Yellow fish added", Toast.LENGTH_SHORT).show();
            startActivity(aquariumIntent);
        });

        Button seaweed = findViewById(R.id.seaweed);
        seaweed.setOnClickListener(v -> {
            editor.putString("seaWeed", "seaWeed");
            editor.apply();
            Toast.makeText(this, "Seaweed added", Toast.LENGTH_SHORT).show();
            startActivity(aquariumIntent);
        });

        Button starfish = findViewById(R.id.starfish);
        starfish.setOnClickListener(v -> {
            editor.putString("starFish", "starFish");
            editor.apply();
            Toast.makeText(this, "Starfish added", Toast.LENGTH_SHORT).show();
            startActivity(aquariumIntent);
        });
    }
}
