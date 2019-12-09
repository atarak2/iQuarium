package com.example.iquarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    private EditText name;
    private EditText start;
    private EditText end;
    private String text1;
    private String text2;
    private String text3;
    private TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button aquarium = findViewById(R.id.aquarium);
        aquarium.setOnClickListener(v -> {
            startActivity(new Intent(this, Aquarium.class));
        });
        Button timer = findViewById(R.id.timer);
        timer.setOnClickListener(v -> {
            startActivity(new Intent(this, Timer.class));
        });
        name = findViewById(R.id.name);
        start = findViewById(R.id.morning);
        end = findViewById(R.id.night);
        SharedPreferences sharedPrefs = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        Button confirming = findViewById(R.id.confirming);
        confirming.setOnClickListener(v -> {
            editor.putString("textName", name.getText().toString());
            editor.putString("textMorn", start.getText().toString());
            editor.putString("textNight", end.getText().toString());
            editor.apply();
            Toast.makeText(this, "Profile updated", Toast.LENGTH_SHORT).show();
        });
        Button save = findViewById(R.id.save);

        save.setOnClickListener(v -> {
            text1 = sharedPrefs.getString("textName", "");
            text2 = sharedPrefs.getString("textMorn", "");
            text3 = sharedPrefs.getString("textNight", "");
            showText = findViewById(R.id.showText);
            if (text1 != null && text2 != null && text3 != null) {
                showText.setText(text1 + "'s Day: " + text2 + " AM - " + text3 + " PM");
                showText.setVisibility(View.VISIBLE);
            }
        });
    }

}
