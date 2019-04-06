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

        // Get Game Progress
        GameProgress mApp = ((GameProgress)getApplicationContext());

        // From Game Progress get the current section
        Integer sectionNumber = mApp.getSection();

        // Change layout based on different sections
        switch (sectionNumber) {
            case 1:
                setContentView(R.layout.intro_maths_screen);
                break;
            case 2:
                setContentView(R.layout.intro_reading_screen);
                break;
            case 3:
                setContentView(R.layout.intro_writing_screen);
                break;
            case 4:
                setContentView(R.layout.intro_treasure_screen);
                break;
        }

    }

    // toQuestionScreen onClick
    public void toQuestionScreen(View view) {

        // Get Game Progress
        GameProgress mApp = ((GameProgress)getApplicationContext());

        // Get the all the current section and current question number
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

        // Create two intents. 1) Question screen or 2) Treasure screen
        Intent intent = new Intent(this, Question.class);
        Intent treasure = new Intent(this, Treasure.class);

        // Insert into extra the data
        intent.putExtra("answerA", ModuleQuestion.get(currentQuestion).getAnswerA());
        intent.putExtra("answerB", ModuleQuestion.get(currentQuestion).getAnswerB());
        intent.putExtra("answerC", ModuleQuestion.get(currentQuestion).getAnswerC());
        intent.putExtra("question", ModuleQuestion.get(currentQuestion).getQuestion());
        intent.putExtra("module", ModuleQuestion.get(currentQuestion).getModule());
        intent.putExtra("correctAnswer", ModuleQuestion.get(currentQuestion).getCorrectAnswer());
        intent.putExtra("questionSize", ModuleQuestion.get(currentQuestion).getQuestionSize());
        intent.putExtra("answerSize", ModuleQuestion.get(currentQuestion).getAnswerSize());

        // Dependent on section number, ether show the next question screen or treasure
        if (sectionNumber == 4) {
            startActivity(treasure);
        } else {
            startActivity(intent);
        }

    }
}
