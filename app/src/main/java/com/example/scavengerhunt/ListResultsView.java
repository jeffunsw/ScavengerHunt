package com.example.scavengerhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ListResultsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_results_view);

        Intent intent = getIntent();

        String retrieveModule = intent.getStringExtra("module");
        String retrieveCorrectAnswer = intent.getStringExtra("correctAnswer");
        String retrieveQuestion = intent.getStringExtra("question");
        String retrieveResult = intent.getStringExtra("result");
        Integer retrieveQuestionSize = intent.getExtras().getInt("questionSize");
        Integer retrieveAnswerSize = intent.getExtras().getInt("answerSize");
        String retrieveYourAnswer = intent.getStringExtra("yourAnswer");

        // Grab the XML elements
        TextView question = findViewById(R.id.question);
//        TextView result = findViewById(R.id.result);
        TextView answer = findViewById(R.id.answer);
        TextView module = findViewById(R.id.module);
        TextView yourAnswer = findViewById(R.id.yourAnswer);

        question.setTextSize(retrieveQuestionSize);
        answer.setTextSize(retrieveAnswerSize);

        // Change XML elements according to intent
        question.setText(retrieveQuestion);
        module.setText(retrieveModule.toUpperCase() + " REVIEW");
        answer.setText(retrieveCorrectAnswer);
//        result.setText(retrieveResult);
        yourAnswer.setText(retrieveYourAnswer);
    }

    public void backQuestionSectionList(View view) {
        Intent intent = new Intent(this, QuestionSectionList.class);
        startActivity(intent);
    }
}
