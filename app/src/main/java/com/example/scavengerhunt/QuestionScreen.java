package com.example.scavengerhunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class QuestionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading_question_screen);
        Intent intent = getIntent();

        Integer questionNumber = 1;

        switch (questionNumber) {
            case 1:
                intent.putExtra("question_number", 1);
                intent.putExtra("question", "Hello this is the question");
                intent.putExtra("answerA", "answerA");
                intent.putExtra("answerB", "answerB");
                intent.putExtra("answerC", "answerC");
                break;
        }

    }
}
