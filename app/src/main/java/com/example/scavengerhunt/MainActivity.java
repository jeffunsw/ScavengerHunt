package com.example.scavengerhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Create a static variable for the Child's name
    public static final String NAME = "NULL";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout to the name screen
        setContentView(R.layout.name_screen);

    }

    // sendMessage onClick
    public void sendMessage(View view) {

        // Create an intent
        Intent intent = new Intent(this, JoinUsScreen.class);

        // Find in XML 'editText'
        EditText editText = (EditText) findViewById(R.id.editText);

        // Create a string from the input
        String message = editText.getText().toString();

        // Add the string to the Extra
        intent.putExtra(NAME, message);

        // Start the activity
        startActivity(intent);
    }
}
