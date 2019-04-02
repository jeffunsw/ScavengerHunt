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
        mathsQuestions.add(new ModuleQuestions("MathsQ1", "Maths", "3 x 5", "8", "15", "10","15", "", false ));
        mathsQuestions.add(new ModuleQuestions("MathsQ2", "Maths", "7 x 8", "56", "15", "54","56", "", false ));
        mathsQuestions.add(new ModuleQuestions("MathsQ3", "Maths", "12 - 4", "16", "8", "3","8", "", false ));
        mathsQuestions.add(new ModuleQuestions("MathsQ4", "Maths", "13 + 11", "24", "22", "26","24", "", false ));
        mathsQuestions.add(new ModuleQuestions("MathsQ5", "Maths", "10 x 4", "14", "14", "40","40", "", false ));

        return mathsQuestions;
    }

    public static ArrayList<ModuleQuestions> getReadingQuestions() {
        ArrayList<ModuleQuestions> readingQuestions = new ArrayList<>();
        readingQuestions.add(new ModuleQuestions("ReadingQ1", "Reading", "Have you ever thought about being a pirate? You may have read about pirates in stories and thought that it would be a great life. Pirates sail all day and never have to go to school. But think again! A pirate's life may not be as much fun as you think.\n" +
                "The writer thinks being a pirate would be ",
                "full of problems", "fun but dangerous", "better than going to school","15", "", false ));
        readingQuestions.add(new ModuleQuestions("ReadingQ2", "Reading", "Food is not easy to find at sea. There are no refrigerators onboard so you can forget about eating fresh food. Meat goes bad after just a few days. Dry food like flour and bread has weevils and other nasty creatures crawling inside. Imagine eating a sandwich full of insects or meat served with maggots.\n" +
                "Weevils can be found in",
                "flour", "meat", "fresh fruit","flour", "", false ));
        readingQuestions.add(new ModuleQuestions("ReadingQ3", "Reading", "Pirates' hammocks are often hung over barrels of stored food. That's the perfect place for rats and mice to live. If you become a pirate you could wake up each morning sharing your bed with a few friendly rodents.\n" +
                "The writer uses the words a few friendly rodents to ",
                "show that only a few are good", "make an awful thing sound not so bad", "make you believe they are good pets","make an awful thing sound not so bad", "", false ));
        readingQuestions.add(new ModuleQuestions("ReadingQ4", "Reading", "Going to the toilet is not that easy either! Over the side of the ship is the only place for this. Rough weather makes this really tricky, even for the most experienced sailor. \n " +
                "Going to the toilet on a ship is",
                "easy in good weather.", "difficult for all pirates.", "tricky only in bad weather.","difficult for all pirates", "", false ));
        readingQuestions.add(new ModuleQuestions("ReadingQ5", "Reading", "It's not all plain sailing on a pirate ship. Some of the time you will have to do battle with other large, hairy pirates with long swords, huge guns and very loud cannons. This could be extremely dangerous — deadly even! \n" + "" +
                "The words plain sailing mean pirate ships",
                "are not easy to sail", "decorated beautifully", "can be dull and boring","are not easy to sail", "", false ));

        return readingQuestions;
    }

    public static ArrayList<ModuleQuestions> getWritingQuestions() {
        ArrayList<ModuleQuestions> writingQuestions = new ArrayList<>();
        writingQuestions.add(new ModuleQuestions("WritingQ1", "Writing", "I found a _____ hiding place than she did", "best", "good", "better","better", "", false ));
        writingQuestions.add(new ModuleQuestions("WritingQ2", "Writing", "Jo likes to listen to music ____ she is cleaning her room", "even", "while", "during","while", "", false ));
        writingQuestions.add(new ModuleQuestions("WritingQ3", "Writing", "Jess bends her knees before ____ shoots", "she", "her", "she's","8", "", false ));
        writingQuestions.add(new ModuleQuestions("WritingQ4", "Writing", "Mark and his friends went to the zoo. It was an ____ day.", "fun", "good", "exciting","exciting", "", false ));
        writingQuestions.add(new ModuleQuestions("WritingQ5", "Writing", "The boy put on his shoes ____ he tied his laces", "and then", "next", "and so","and then", "", false ));

        return writingQuestions;
    }

}