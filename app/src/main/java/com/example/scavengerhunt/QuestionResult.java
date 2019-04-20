package com.example.scavengerhunt;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_results);

        ConstraintLayout rl = (ConstraintLayout)findViewById(R.id.constraint_layout);


        // Retrieve data from intent
        Intent intent = getIntent();
        String retrieveModule = intent.getStringExtra("module");
        String retrieveCorrectAnswer = intent.getStringExtra("correctAnswer");
        String retrieveQuestion = intent.getStringExtra("question");
        String retrieveResult = intent.getStringExtra("result");
        Integer retrieveQuestionSize = intent.getExtras().getInt("questionSize");

        if (retrieveResult.equals("Correct!")) {
            rl.setBackgroundColor(Color.parseColor("#5CAD46"));
        } else {
            rl.setBackgroundColor(Color.parseColor("#E8453F"));
        }

        // Grab the XML elements
        TextView question = findViewById(R.id.question);
        TextView result = findViewById(R.id.result);
        TextView answer = findViewById(R.id.answer);
        TextView module = findViewById(R.id.module);

        // Grab the game progress data
        GameProgress mApp = ((GameProgress)getApplicationContext());
        Integer sectionNumber = mApp.getSection();

        // Initiate the ArrayList<ModuleQuestions>
        ArrayList<ModuleQuestions> ModuleQuestion;

        // Fill ModuleQuestion with the data of the correct section
        switch (sectionNumber) {
            case 1:
                ModuleQuestion = ModuleQuestions.getMathsQuestions();
                break;
            case 2:
                ModuleQuestion = ModuleQuestions.getReadingQuestions();
                break;
            case 3:
                ModuleQuestion = ModuleQuestions.getWritingQuestions();
                break;

            // Default
            default: ModuleQuestion = ModuleQuestions.getMathsQuestions();

        }

        // Update the text size of the Question and Answer (from ModuleQuestion)
        question.setTextSize(ModuleQuestion.get(sectionNumber).getQuestionSize());
        answer.setTextSize(ModuleQuestion.get(sectionNumber).getAnswerSize());

        // Change XML elements according to intent
        question.setText(retrieveQuestion);
        question.setTextSize(retrieveQuestionSize);
        module.setText(retrieveModule.toUpperCase());
        answer.setText(retrieveCorrectAnswer);
        result.setText(retrieveResult);
    }

    // nextQuestion onClick
    public void nextQuestion(View view) {

        // Get Game Progress and get section number & current question
        GameProgress mApp = ((GameProgress)getApplicationContext());
        Integer sectionNumber = mApp.getSection();
        Integer currentQuestion = mApp.getQuestionNumber();

        // Initiate the ArrayList<ModuleQuestions>
        ArrayList<ModuleQuestions> ModuleQuestion;

        // Fill ModuleQuestion with the data of the correct section
        switch (sectionNumber) {
            case 1:
                ModuleQuestion = ModuleQuestions.getMathsQuestions();
                break;
            case 2:
                ModuleQuestion = ModuleQuestions.getReadingQuestions();
                break;
            case 3:
                ModuleQuestion = ModuleQuestions.getWritingQuestions();
                break;

            // Default
            default: ModuleQuestion = ModuleQuestions.getMathsQuestions();

        }

        // Create two intents. 1) Show next question, 2) Finish the section
        Intent nextQuestion = new Intent(this, Question.class);
        Intent finishSection = new Intent(this, QuestionSectionList.class);

        // Continue after 5 questions
        if (currentQuestion.equals(4)) {

            // Increment section number
            mApp.addSection();

            // Reset question number back to 0
            mApp.resetQuestionNumber();

            // Start activity
            startActivity(finishSection);
        } else {

            // Increment question number
            mApp.addQuestionNumber();

            // Retrieve current question number
            Integer nextQuestionNumber = mApp.getQuestionNumber();

            // Insert into extra the data
            nextQuestion.putExtra("answerA", ModuleQuestion.get(nextQuestionNumber).getAnswerA());
            nextQuestion.putExtra("answerB", ModuleQuestion.get(nextQuestionNumber).getAnswerB());
            nextQuestion.putExtra("answerC", ModuleQuestion.get(nextQuestionNumber).getAnswerC());
            nextQuestion.putExtra("question", ModuleQuestion.get(nextQuestionNumber).getQuestion());
            nextQuestion.putExtra("module", ModuleQuestion.get(nextQuestionNumber).getModule());
            nextQuestion.putExtra("correctAnswer", ModuleQuestion.get(nextQuestionNumber).getCorrectAnswer());
            nextQuestion.putExtra("questionSize", ModuleQuestion.get(currentQuestion).getQuestionSize());
            nextQuestion.putExtra("answerSize", ModuleQuestion.get(currentQuestion).getAnswerSize());

            // Start activity
            startActivity(nextQuestion);
        }

    }
}
