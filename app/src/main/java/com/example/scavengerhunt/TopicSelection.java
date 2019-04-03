package com.example.scavengerhunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class TopicSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maths_intro_screen);

        // Get Game Progress
        GameProgress mApp = ((GameProgress)getApplicationContext());

        // Get the all the questions
        Integer sectionNumber = mApp.getSection();

        switch (sectionNumber) {
            case 1:
                setContentView(R.layout.maths_intro_screen);
                break;
            case 2:
                setContentView(R.layout.reading_intro_screen);
                break;
            case 3:
                setContentView(R.layout.writing_intro_screen);
                break;
            default:
                // Default
                setContentView(R.layout.maths_intro_screen);
        }

    }

    public void toQuestionScreen(View view) {
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

        Intent intent = new Intent(this, Question.class);

        Integer currentQuestion = mApp.getQuestionNumber();

        intent.putExtra("answerA", ModuleQuestion.get(currentQuestion).getAnswerA());
        intent.putExtra("answerB", ModuleQuestion.get(currentQuestion).getAnswerB());
        intent.putExtra("answerC", ModuleQuestion.get(currentQuestion).getAnswerC());
        intent.putExtra("question", ModuleQuestion.get(currentQuestion).getQuestion());
        intent.putExtra("module", ModuleQuestion.get(currentQuestion).getModule());
        intent.putExtra("correctAnswer", ModuleQuestion.get(currentQuestion).getCorrectAnswer());
        intent.putExtra("questionSize", ModuleQuestion.get(currentQuestion).getQuestionSize());
        intent.putExtra("answerSize", ModuleQuestion.get(currentQuestion).getAnswerSize());

        startActivity(intent);
    }
}
