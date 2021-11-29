package com.example.quizapp.model.questions;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.IgnoreExtraProperties;

import java.util.ArrayList;

public class Question {
    // answerResId will store question
    private int trueAnswerIndex;
    private String question;
    private ArrayList<String> answers;
    // Asnwered will store if the user answered correct or not on this question
    private boolean isAnsweredTrue;

    public Question(String question, int trueAnswerIndex, ArrayList<String> answers) {
        // setting the values through
        // arguments passed in constructor
        this.question = question;
        this.answers = answers;
        this.trueAnswerIndex = trueAnswerIndex;
    }

    public Question(){
    }

    public String getQuestion()
    {
        return question;
    }
    public void setQuestion(String question)
    {
        this.question = question;
    }

    @Exclude
    public boolean getAnsweredTrue() {
        return isAnsweredTrue;
    }
    public void setAnsweredTrue(boolean answeredTrue) {
        this.isAnsweredTrue = answeredTrue;
    }

    public int getTrueAnswerIndex() {
        return trueAnswerIndex;
    }
    public void setTrueAnswerIndex(int trueAnswerIndex) {
        this.trueAnswerIndex = trueAnswerIndex;
    }

    public ArrayList<String> getAnswers() { return answers; }
    public void setAnswers(ArrayList<String> answers) { this.answers = answers; }
}

