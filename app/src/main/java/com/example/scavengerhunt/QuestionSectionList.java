package com.example.scavengerhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionSectionList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_section_list);

        TextView result = findViewById(R.id.module);

        GameProgress mApp = ((GameProgress)getApplicationContext());
        // Get the all the questions
        Integer sectionNumber = mApp.getSection();

        switch (sectionNumber - 1) {
            case 1: result.setText("Maths"); break;
            case 2: result.setText("Reading"); break;
            case 3: result.setText("Writing"); break;
        }

        initRecyclerView();
    }

    private void initRecyclerView() {

        ModuleQuestions mQuestions = ((ModuleQuestions)getApplicationContext());

        GameProgress mApp = ((GameProgress)getApplicationContext());

        ArrayList<Marks> marks = new ArrayList<Marks>();

        marks.add(new Marks(Boolean.toString(mApp.isQuestionOneResults())));
        marks.add(new Marks(Boolean.toString(mApp.isQuestionTwoResults())));
        marks.add(new Marks(Boolean.toString(mApp.isQuestionThreeResults())));
        marks.add(new Marks(Boolean.toString(mApp.isQuestionFourResults())));
        marks.add(new Marks(Boolean.toString(mApp.isQuestionFiveResults())));

        // Get the all the questions
        Integer sectionNumber = mApp.getSection();

        ArrayList<ModuleQuestions> ModuleQuestion;

        switch (sectionNumber - 1) {
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

        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(ModuleQuestion, marks,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void showSectionResult(View view) {
        Intent intent = new Intent(this, QuestionSectionResults.class);
        startActivity(intent);
    }
}
