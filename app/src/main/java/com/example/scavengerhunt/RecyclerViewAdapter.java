package com.example.scavengerhunt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    // Create variables
    private ArrayList<ModuleQuestions> mModuleQuestions = new ArrayList<>();
    private ArrayList<Marks> marks = new ArrayList<Marks>();
    private Context mContext;

    // RecyclerViewAdapter inputs two ArrayLists and context
    public RecyclerViewAdapter(ArrayList<ModuleQuestions> mModuleQuestions, ArrayList<Marks> marks, Context mContext) {
        this.mModuleQuestions = mModuleQuestions;
        this.marks = marks;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        // Set the textViews with data
        viewHolder.questionNumber.setText(mModuleQuestions.get(i).getId());
        viewHolder.result.setText(result(marks.get(i).getResults()));

        // When user clicks on Recycler View item
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            // Create intent
            Intent intent = new Intent(view.getContext(), ListResultsView.class);

            // Put into extra the data
            intent.putExtra("module", mModuleQuestions.get(i).getModule());
            intent.putExtra("correctAnswer", mModuleQuestions.get(i).getCorrectAnswer());
            intent.putExtra("question", mModuleQuestions.get(i).getQuestion());
            intent.putExtra("result", mModuleQuestions.get(i).getResult());
            intent.putExtra("questionSize", mModuleQuestions.get(i).getQuestionSize());
            intent.putExtra("answerSize", mModuleQuestions.get(i).getAnswerSize());
            intent.putExtra("yourAnswer", result(marks.get(i).getResults()));

            // Start activity
            view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mModuleQuestions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView questionNumber;
        TextView result;
        RelativeLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Find in XML textView and layout
            questionNumber = itemView.findViewById(R.id.questionNumber);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            result = itemView.findViewById(R.id.result);
        }
    }

    // Convert true/false to user-friendly text
    public String result(String result) {
        if (result.equals("true")) {
            return "Correct!";
        }
        else {
            return "Incorrect!";
        }

    }
}
