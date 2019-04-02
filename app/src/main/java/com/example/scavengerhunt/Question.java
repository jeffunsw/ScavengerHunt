package com.example.scavengerhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maths_question_screen);

        Intent intent = getIntent();

        // Retrieve intent
        String retrieveAnswerA = intent.getStringExtra("answerA");
        String retrieveAnswerB = intent.getStringExtra("answerB");
        String retrieveAnswerC = intent.getStringExtra("answerC");
        String retrieveModule = intent.getStringExtra("module");
        String retrieveQuestion = intent.getStringExtra("question");

        // Grab the XML elements
        TextView question = findViewById(R.id.question);
        Button answerA = findViewById(R.id.answerA);
        Button answerB = findViewById(R.id.answerB);
        Button answerC = findViewById(R.id.answerC);
        TextView module = findViewById(R.id.module);

        GameProgress mApp = ((GameProgress)getApplicationContext());
        // Get the all the questions
        Integer sectionNumber = mApp.getSection();

        ArrayList<ModuleQuestions> ModuleQuestion;

        switch (sectionNumber) {
            case 1:
                question.setTextSize(50);
                break;
            case 2:
                question.setTextSize(20);
                break;
            case 3:
                question.setTextSize(30);
                break;
            default:
                // Default
                question.setTextSize(10);
        }

        // Change XML elements according to intent
        question.setText(retrieveQuestion);
        answerA.setText(retrieveAnswerA);
        answerB.setText(retrieveAnswerB);
        answerC.setText(retrieveAnswerC);
        module.setText(retrieveModule.toUpperCase());

    }

    public void answerA(View view) {
        processAnswer("answerA");
    }

    public void answerB(View view) {
        processAnswer("answerB");

    }

    public void answerC(View view) {
        processAnswer("answerC");
    }

    public void processAnswer(String type){
        Intent intent = getIntent();
        String retrieveCorrectAnswer = intent.getStringExtra("correctAnswer");
        String retrieveAnswer = intent.getStringExtra(type);
        String retrieveModule = intent.getStringExtra("module");
        String retrieveQuestion = intent.getStringExtra("question");

        Intent questionIntent = new Intent(this, QuestionResult.class);

        questionIntent.putExtra("module", retrieveModule);
        questionIntent.putExtra("correctAnswer", retrieveCorrectAnswer);
        questionIntent.putExtra("question", retrieveQuestion);

        GameProgress mApp = ((GameProgress)getApplicationContext());

        if (retrieveCorrectAnswer.equals(retrieveAnswer)) {
            questionIntent.putExtra("result", "Correct!");

            Integer sectionNumber = mApp.getSection();

            ArrayList<ModuleQuestions> ModuleQuestion;

            switch (sectionNumber) {
                case 1:
                    mApp.addSectionOneMarks();
                    break;
                case 2:
                    mApp.addSectionTwoMarks();
                    break;
                case 3:
                    mApp.addSectionThreeMarks();
                    break;
            }


        } else {
            questionIntent.putExtra("result", "Incorrect!");
        }

        startActivity(questionIntent);
    }
}
