package com.example.scavengerhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionSectionResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.maths_results_screen);

        GameProgress mApp = ((GameProgress)getApplicationContext());

        TextView module = findViewById(R.id.module);
        TextView result = findViewById(R.id.result);
        TextView mark = findViewById(R.id.mark);
        Button progressButton = findViewById(R.id.progressButton);

        Integer sectionNumber = mApp.getSection();

        ArrayList<ModuleQuestions> ModuleQuestion;

        Integer sectionOneMarks = mApp.getSectionOneMarks();
        Integer sectionTwoMarks = mApp.getSectionTwoMarks();
        Integer sectionThreeMarks = mApp.getSectionThreeMarks();

        switch (sectionNumber - 1) {
            case 1:
                mark.setText("You got " + sectionOneMarks + "/5 correct!");
                break;
            case 2:
                mark.setText("You got " + sectionTwoMarks + "/5 correct!");
                break;
            case 3:
                mark.setText("You got " + sectionThreeMarks + "/5 correct!");
                break;
        }


        if (mApp.getSectionOneMarks() > 3) {
            result.setText("Congratulations!");
            progressButton.setText("Next!");

        } else {
            result.setText("Better luck next time!");
            progressButton.setText("Redo");
            progressButton.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent home = new Intent(v.getContext(), TopicSelection.class);

                    GameProgress mApp = ((GameProgress)getApplicationContext());

                    if(mApp.getSection() > 1) {
                        mApp.removeSection();
                    } else {
                        mApp.setSection(1);
                    }

                    Integer sectionNumber = mApp.getSection();

                    ArrayList<ModuleQuestions> ModuleQuestion;

                    switch (sectionNumber) {
                        case 1:
                            mApp.resetSectionOneMarks();
                            break;
                        case 2:
                            mApp.resetSectionTwoMarks();
                            break;
                        case 3:
                            mApp.resetSectionThreeMarks();
                            break;
                    }

                    startActivity(home);
                }
            });
        }

        module.setText("Maths");

    }

    public void goHome(View view) {
        Intent home = new Intent(this, TopicSelection.class);
        startActivity(home);
    }

    public void nextQuestionModule(View view) {

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

        Integer nextQuestionNumber = mApp.getQuestionNumber();

        nextQuestion.putExtra("answerA", ModuleQuestion.get(nextQuestionNumber).getAnswerA());
        nextQuestion.putExtra("answerB", ModuleQuestion.get(nextQuestionNumber).getAnswerB());
        nextQuestion.putExtra("answerC", ModuleQuestion.get(nextQuestionNumber).getAnswerC());
        nextQuestion.putExtra("question", ModuleQuestion.get(nextQuestionNumber).getQuestion());
        nextQuestion.putExtra("module", ModuleQuestion.get(nextQuestionNumber).getModule());
        nextQuestion.putExtra("correctAnswer", ModuleQuestion.get(nextQuestionNumber).getCorrectAnswer());

        startActivity(nextQuestion);
    }
}
