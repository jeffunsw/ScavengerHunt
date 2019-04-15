package com.example.scavengerhunt;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Treasure extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout to treasure chest screen
        setContentView(R.layout.treasure_chest_screen);
    }

    // showVideo onClick
    public void showVideo(View view) {

        // Create intent with URI & start activity
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/nh4fy0fVkXM?t=135"));
        startActivity(browserIntent);
    }
}
