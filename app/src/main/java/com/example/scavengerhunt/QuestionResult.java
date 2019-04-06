package com.example.scavengerhunt;

import android.content.Intent;
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

        Intent intent = getIntent();

        String retrieveModule = intent.getStringExtra("module");
        String retrieveCorrectAnswer = intent.getStringExtra("correctAnswer");
        String retrieveQuestion = intent.getStringExtra("question");
        String retrieveResult = intent.getStringExtra("result");

        // Grab the XML elements
        TextView question = findViewById(R.id.question);
        TextView result = findViewById(R.id.result);
        TextView answer = findViewById(R.id.answer);
        TextView module = findViewById(R.id.module);

        GameProgress mApp = ((GameProgress)getApplicationContext());
        // Get the all the questions
        Integer sectionNumber = mApp.getSection();

        ArrayList<ModuleQuestions> ModuleQuestion;

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
            default:
                // Default
                ModuleQuestion = ModuleQuestions.getMathsQuestions();
        }

        question.setTextSize(ModuleQuestion.get(sectionNumber).getQuestionSize());
        answer.setTextSize(ModuleQuestion.get(sectionNumber).getAnswerSize());

        // Change XML elements according to intent
        question.setText(retrieveQuestion);
        module.setText(retrieveModule.toUpperCase());
        answer.setText(retrieveCorrectAnswer);
        result.setText(retrieveResult);
    }

    public void nextQuestion(View view) {

        // Get Game Progress
        GameProgress mApp = ((GameProgress)getApplicationContext());

        // Get the all the questions
        Integer sectionNumber = mApp.getSection();

        ArrayList<ModuleQuestions> ModuleQuestion;

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
            default:
                // Default
                ModuleQuestion = ModuleQuestions.getMathsQuestions();
        }


        Intent nextQuestion = new Intent(this, Question.class);
        Intent finishSection = new Intent(this, QuestionSectionList.class);

        Integer currentQuestion = mApp.getQuestionNumber();

        // Max 5 questions
        if (currentQuestion.equals(4)) {
            mApp.addSection();
            mApp.resetQuestionNumber();
            startActivity(finishSection);
        } else {

            mApp.addQuestionNumber();

            Integer nextQuestionNumber = mApp.getQuestionNumber();

            nextQuestion.putExtra("answerA", ModuleQuestion.get(nextQuestionNumber).getAnswerA());
            nextQuestion.putExtra("answerB", ModuleQuestion.get(nextQuestionNumber).getAnswerB());
            nextQuestion.putExtra("answerC", ModuleQuestion.get(nextQuestionNumber).getAnswerC());
            nextQuestion.putExtra("question", ModuleQuestion.get(nextQuestionNumber).getQuestion());
            nextQuestion.putExtra("module", ModuleQuestion.get(nextQuestionNumber).getModule());
            nextQuestion.putExtra("correctAnswer", ModuleQuestion.get(nextQuestionNumber).getCorrectAnswer());
            nextQuestion.putExtra("questionSize", ModuleQuestion.get(currentQuestion).getQuestionSize());
            nextQuestion.putExtra("answerSize", ModuleQuestion.get(currentQuestion).getAnswerSize());

            startActivity(nextQuestion);
        }

    }
}
