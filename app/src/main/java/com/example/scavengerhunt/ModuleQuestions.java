package com.example.scavengerhunt;

import java.util.ArrayList;

public class ModuleQuestions {
    private String id;
    private String module;
    private String question;
    private String answerA;
    private String answerB;
    private String answerC;
    private String correctAnswer;
    private String userAnswer;
    private boolean result;

    public ModuleQuestions() {
    }

    public ModuleQuestions(String id, String module, String question, String answerA, String answerB, String answerC, String correctAnswer, String userAnswer, boolean result) {
        this.id = id;
        this.module = module;
        this.question = question;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean isResult() {
        if (this.userAnswer == this.correctAnswer) {
            return true;
        } else {
            return false;
        }
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public static ArrayList<ModuleQuestions> getMathsQuestions() {
        ArrayList<ModuleQuestions> mathsQuestions = new ArrayList<>();
        return mathsQuestions;
    }
}
