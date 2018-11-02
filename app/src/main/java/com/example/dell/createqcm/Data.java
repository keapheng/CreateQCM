package com.example.dell.createqcm;


import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
    private String question;
    private ArrayList<String> answers;

    public Data() {
        answers = new ArrayList<>();
    }

    public Data(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Data{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                '}';
    }
}
