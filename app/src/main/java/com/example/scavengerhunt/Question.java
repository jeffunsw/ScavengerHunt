package com.example.scavengerhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout to the question screen
        setContentView(R.layout.question);

        // Retrieve data from intent
        Intent intent = getIntent();
        String retrieveAnswerA = intent.getStringExtra("answerA");
        String retrieveAnswerB = intent.getStringExtra("answerB");
        String retrieveAnswerC = intent.getStringExtra("answerC");
        String retrieveModule = intent.getStringExtra("module");
        String retrieveQuestion = intent.getStringExtra("question");
        Integer retrieveQuestionSize = intent.getExtras().getInt("questionSize");

        // Grab the XML elements
        TextView question = findViewById(R.id.question);
        Button answerA = findViewById(R.id.answerA);
        Button answerB = findViewById(R.id.answerB);
        Button answerC = findViewById(R.id.answerC);
        TextView module = findViewById(R.id.module);

        // Update XML elements according to intent
        question.setText(retrieveQuestion);
        question.setTextSize(retrieveQuestionSize);
        answerA.setText(retrieveAnswerA);
        answerB.setText(retrieveAnswerB);
        answerC.setText(retrieveAnswerC);
        module.setText(retrieveModule.toUpperCase());

    }

    // answerA onClick
    public void answerA(View view) {
        processAnswer("answerA");
    }

    // answerB onClick
    public void answerB(View view) {
        processAnswer("answerB");
    }

    // answerC onClick
    public void answerC(View view) {
        processAnswer("answerC");
    }

    // processAnswer for answers
    public void processAnswer(String type){

        // Retrieve data from intent
        Intent intent = getIntent();
        String retrieveCorrectAnswer = intent.getStringExtra("correctAnswer");
        String retrieveAnswer = intent.getStringExtra(type);
        String retrieveModule = intent.getStringExtra("module");
        String retrieveQuestion = intent.getStringExtra("question");
        Integer retrieveQuestionSize = intent.getExtras().getInt("questionSize");

        // Create new intent for Question Result
        Intent questionIntent = new Intent(this, QuestionResult.class);

        // Add data into Question Result intent
        questionIntent.putExtra("module", retrieveModule);
        questionIntent.putExtra("correctAnswer", retrieveCorrectAnswer);
        questionIntent.putExtra("question", retrieveQuestion);
        questionIntent.putExtra("questionSize", retrieveQuestionSize);

        // Grab the game progress data
        GameProgress mApp = ((GameProgress)getApplicationContext());

        // Logic for whether or not they answered the question right or wrong (if they match)
        if (retrieveCorrectAnswer.equals(retrieveAnswer)) {

            // Add into Question Result that the answer was correct
            questionIntent.putExtra("result", "Correct!");

            // Grab from game progress current section and question number
            Integer sectionNumber = mApp.getSection();
            Integer questionNumber = mApp.getQuestionNumber();

            // Update game progress to save whether or not the question was correct
            switch (questionNumber) {
                case 0 : mApp.setQuestionOneResults(true); break;
                case 1 : mApp.setQuestionTwoResults(true); break;
                case 2 : mApp.setQuestionThreeResults(true); break;
                case 3 : mApp.setQuestionFourResults(true); break;
                case 4 : mApp.setQuestionFiveResults(true); break;
            }

            // Add to the tally of the number of questions per section correct
            switch (sectionNumber) {
                case 1: mApp.addSectionOneMarks(); break;
                case 2: mApp.addSectionTwoMarks(); break;
                case 3: mApp.addSectionThreeMarks(); break;
            }

        } else {
            // Add into Question Result that the answer was incorrect
            questionIntent.putExtra("result", "Incorrect!");
        }

        // Start the activity
        startActivity(questionIntent);
    }
}
