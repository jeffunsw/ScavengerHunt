package com.example.scavengerhunt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class QuestionSectionList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set layout to the activity question section list screen
        setContentView(R.layout.activity_question_section_list);

        // Find XML result TextView
        TextView result = findViewById(R.id.module);

        // Get Game Progress and section number
        GameProgress mApp = ((GameProgress)getApplicationContext());
        Integer sectionNumber = mApp.getSection();

        // Dependent on section number, change title
        switch (sectionNumber - 1) {
            case 1: result.setText("Maths"); break;
            case 2: result.setText("Reading"); break;
            case 3: result.setText("Writing"); break;
        }

        // Start recycler view
        initRecyclerView();
    }

    // Recycler view
    private void initRecyclerView() {

        // Get Game Progress & section number
        GameProgress mApp = ((GameProgress)getApplicationContext());
        Integer sectionNumber = mApp.getSection();

        // Create ArrayList<Marks> to record user's marks
        ArrayList<Marks> marks = new ArrayList<Marks>();

        // Add the Marks ArrayList user's results
        marks.add(new Marks(Boolean.toString(mApp.isQuestionOneResults())));
        marks.add(new Marks(Boolean.toString(mApp.isQuestionTwoResults())));
        marks.add(new Marks(Boolean.toString(mApp.isQuestionThreeResults())));
        marks.add(new Marks(Boolean.toString(mApp.isQuestionFourResults())));
        marks.add(new Marks(Boolean.toString(mApp.isQuestionFiveResults())));

        // Initiate the ArrayList<ModuleQuestions>
        ArrayList<ModuleQuestions> ModuleQuestion;

        // Fill ModuleQuestion with the data of the correct section
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
            // Default
            default: ModuleQuestion = ModuleQuestions.getMathsQuestions();
        }

        // Find the Recycler View in XML
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);

        // Create RecyclerViewAdapter with ModuleQuestion
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(ModuleQuestion, marks,this);

        // Set the adapter
        recyclerView.setAdapter(adapter);

        // Set the recyclerView layout as linear
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // showSectionResult onClick
    public void showSectionResult(View view) {

        // Create intent & start activity
        Intent intent = new Intent(this, QuestionSectionResults.class);
        startActivity(intent);
    }
}
