package com.example.iquarium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class end_timer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_timer);
        Button aquarium = findViewById(R.id.aquarium);
        aquarium.setOnClickListener(v -> {
            startActivity(new Intent(this, Aquarium.class));
        });
        Button profile = findViewById(R.id.profile);
        profile.setOnClickListener(v -> {
            startActivity(new Intent(this, Profile.class));
        });
        endButtonStuff();
    }
    protected void endButtonStuff() {
        Button shop = findViewById(R.id.shop);
        shop.setOnClickListener(v -> {
            startActivity(new Intent(this, Shop.class));
        });
        Button confirmTime = findViewById(R.id.confirmTime);
        confirmTime.setOnClickListener(v -> {
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            getIntent();
            EditText timeSpent = findViewById(R.id.timeSpent);
            String spentTime = timeSpent.getText().toString();
            Integer spentTimeNumber = Integer.parseInt(spentTime);
            TextView textResponse = findViewById(R.id.textResponse);
            String goalTime = getIntent().getStringExtra("timeGoal2");
            Integer goalTimeNumber = Integer.parseInt(goalTime);
            Log.d("goalTime", goalTime);
            if (spentTimeNumber <= goalTimeNumber) {
                textResponse.setText("Congratulations! You've met you goal for the day." +
                        "You can now add something from the shop to your aquarium!");
                textResponse.setVisibility(View.VISIBLE);
                shop.setVisibility(View.VISIBLE);

            } else {
                textResponse.setText("Sorry, you didn't meet your goal for the day." +
                        "Try again tomorrow to add something to your aquarium");
                shop.setVisibility(View.INVISIBLE);
                textResponse.setVisibility(View.VISIBLE);
            }
        });
    }
}
