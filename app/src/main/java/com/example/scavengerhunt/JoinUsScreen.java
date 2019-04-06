package com.example.scavengerhunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class JoinUsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout to the join us screen
        setContentView(R.layout.join_us_screen);

        // Grab intent & get the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.NAME);

        // Capture the textView, and set the text to the string
        TextView textView = findViewById(R.id.textView6);
        textView.setText(message);
    }

    // nextScreenToGreetingScreens onClick
    public void nextScreenToGreetingsScreen(View view) {

        // Create intent and start activity
        Intent intent = new Intent(this, GreetingsScreen.class);
        startActivity(intent);
    }
}
