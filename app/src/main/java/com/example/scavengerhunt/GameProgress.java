package com.example.scavengerhunt;

import android.app.Application;

public class GameProgress extends Application {
    private Integer questionNumber = 0;
    private Integer section = 1;
    private Integer sectionOneMarks = 0;
    private Integer sectionTwoMarks = 0;
    private Integer sectionThreeMarks = 0;

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
