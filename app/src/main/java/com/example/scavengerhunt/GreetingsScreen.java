package com.example.scavengerhunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GreetingsScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout to the name screen
        setContentView(R.layout.greetings_screen);
    }

    // nextScreen onClick
    public void nextScreen(View view) {

        // Create intent and start activity
        Intent intent = new Intent(this, TopicSelection.class);
        startActivity(intent);
    }
}
