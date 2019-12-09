package com.example.iquarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class YourTimerGoal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_timer_goal);
        Button aquarium = findViewById(R.id.aquarium);
        aquarium.setOnClickListener(v -> {
            startActivity(new Intent(this, Aquarium.class));
        });
        Button profile = findViewById(R.id.profile);
        profile.setOnClickListener(v -> {
            startActivity(new Intent(this, Profile.class));
        });

        getIntent();
        String input = getIntent().getStringExtra("timeGoal");
        TextView displayNumber = findViewById(R.id.displayNumber);
        displayNumber.setText(input + " hours");

        Button endTimerButton = findViewById(R.id.endTimerButton);
        //new intent for end timer to compare times
        Intent endIntent = new Intent(this, end_timer.class);
        endIntent.putExtra("timeGoal2", input);
        endTimerButton.setOnClickListener(v -> {
            startActivity(endIntent);
        });


        //need a way for the page to switch when end time is reached

        //Intent so other pages can go to new timer page instead of old ones
        /*
        Intent timeToAquarium = new Intent(this, Aquarium.class);
        Intent timeToProfile = new Intent (this, Profile.class);
        String displayString = displayNumber.getText().toString();
        timeToAquarium.putExtra("displayString", displayString);
        timeToProfile.putExtra("displayString", displayString);
        */
    }

}
