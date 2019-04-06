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

        setContentView(R.layout.section_results);

        GameProgress mApp = ((GameProgress)getApplicationContext());
        mApp.setQuestionOneResults(false);
        mApp.setQuestionTwoResults(false);
        mApp.setQuestionThreeResults(false);
        mApp.setQuestionFourResults(false);
        mApp.setQuestionFiveResults(false);

        TextView module = findViewById(R.id.module);
        TextView result = findViewById(R.id.result);
        TextView mark = findViewById(R.id.mark);
        Button progressButton = findViewById(R.id.progressButton);

        Integer sectionNumber = mApp.getSection();

        Integer marks = 0;

        switch (sectionNumber - 1) {
            case 1: marks = mApp.getSectionOneMarks(); mark.setText("You got " + marks + "/5 correct!"); break;
            case 2: marks = mApp.getSectionTwoMarks(); mark.setText("You got " + marks + "/5 correct!");break;
            case 3: marks = mApp.getSectionThreeMarks(); mark.setText("You got " + marks + "/5 correct!");break;
        }

        if (marks > 3) { // Default 3
            result.setText("Congratulations!");
            progressButton.setText("Next!");

            progressButton.setOnClickListener( new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent home = new Intent(v.getContext(), TopicSelection.class);
                    startActivity(home);
                }
            });


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


        switch (sectionNumber - 1) {
            case 1:
                module.setText("MATHS");
                break;
            case 2:
                module.setText("READING");
                break;
            case 3:
                module.setText("SPELLING");
                break;
        }

    }

}
