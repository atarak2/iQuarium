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

import org.w3c.dom.Text;

public class Timer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        Button aquarium = findViewById(R.id.aquarium);
        aquarium.setOnClickListener(v -> {
            startActivity(new Intent(this, Aquarium.class));
        });
        /*
        Button shop = findViewById(R.id.shop);
        shop.setOnClickListener(v -> {
            startActivity(new Intent(this, Shop.class));
        });
         */
        Button profile = findViewById(R.id.profile);
        profile.setOnClickListener(v -> {
            startActivity(new Intent(this, Profile.class));
        });
        buttonStuff();
    }

    /**
     * helper function for entering time string
     */
    protected void buttonStuff() {
        Button confirm = findViewById(R.id.confirm);
        confirm.setOnClickListener(v -> {
            Intent timerIntent = new Intent(this, YourTimerGoal.class);
            EditText enterTime = findViewById(R.id.enterTime);
            String timeGoal = enterTime.getText().toString();
            timerIntent.putExtra("timeGoal", timeGoal);
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            startActivity(timerIntent);
        });
    }
}
