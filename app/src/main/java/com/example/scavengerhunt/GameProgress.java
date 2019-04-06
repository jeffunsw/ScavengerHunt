package com.example.scavengerhunt;

import android.app.Application;

import java.util.ArrayList;

public class GameProgress extends Application {
    private Integer questionNumber = 0;
    private Integer section = 1;
    private Integer sectionOneMarks = 0;
    private Integer sectionTwoMarks = 0;
    private Integer sectionThreeMarks = 0;

    private boolean questionOneResults;
    private boolean questionTwoResults;
    private boolean questionThreeResults;
    private boolean questionFourResults;
    private boolean questionFiveResults;

    public boolean isQuestionOneResults() {
        return questionOneResults;
    }

    public void setQuestionOneResults(boolean questionOneResults) {
        this.questionOneResults = questionOneResults;
    }

    public boolean isQuestionTwoResults() {
        return questionTwoResults;
    }

    public void setQuestionTwoResults(boolean questionTwoResults) {
        this.questionTwoResults = questionTwoResults;
    }

    public boolean isQuestionThreeResults() {
        return questionThreeResults;
    }

    public void setQuestionThreeResults(boolean questionThreeResults) {
        this.questionThreeResults = questionThreeResults;
    }

    public boolean isQuestionFourResults() {
        return questionFourResults;
    }

    public void setQuestionFourResults(boolean questionFourResults) {
        this.questionFourResults = questionFourResults;
    }

    public boolean isQuestionFiveResults() {
        return questionFiveResults;
    }

    public void setQuestionFiveResults(boolean questionFiveResults) {
        this.questionFiveResults = questionFiveResults;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public Integer resetQuestionNumber() {
        return questionNumber = 0;
    }

    public void addQuestionNumber() {
        questionNumber += 1;
    }

    public Integer getSection() {
        return section;
    }

    public void addSection() {
        this.section++;
    }

    public void removeSection() {
        this.section--;
    }

    public void setSection(Integer section) {
        this.section = section;
    }

    public Integer getSectionOneMarks() {
        return sectionOneMarks;
    }

    public void resetSectionOneMarks() {
        this.sectionOneMarks = 0;
    }

    public void addSectionOneMarks() {
        this.sectionOneMarks++;
    }

    public void resetSectionTwoMarks() {
        this.sectionTwoMarks = 0;
    }

    public void addSectionTwoMarks() {
        this.sectionTwoMarks++;
    }

    public Integer getSectionTwoMarks() {
        return sectionTwoMarks;
    }

    public void resetSectionThreeMarks() {
        this.sectionThreeMarks = 0;
    }

    public void addSectionThreeMarks() {
        this.sectionThreeMarks++;
    }

    public Integer getSectionThreeMarks() {
        return sectionThreeMarks;
    }
}
