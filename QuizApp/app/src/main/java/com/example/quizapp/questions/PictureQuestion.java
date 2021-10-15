package com.example.quizapp.questions;

public class PictureQuestion {

    // answerResId will store question
    private int questionResId, trueAnswerIndex;
    private int[] answersResId;
    // Asnwered will store if the user answered correct or not on this question
    private boolean isAnsweredTrue;

    public PictureQuestion(int questionResId, int trueAnswerIndex, int[] answersResId) {
        // setting the values through
        // arguments passed in constructor
        this.questionResId = questionResId;
        this.answersResId = answersResId;
        this.trueAnswerIndex = trueAnswerIndex;
    }


    public int getQuestionResId()
    {
        return questionResId;
    }
    public void setQuestionResId(int questionResId)
    {
        this.questionResId = questionResId;
    }

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

    public int[] getAnswersResId() { return answersResId; }
    public void setAnswersResId(int[] answersResId) { this.answersResId = answersResId; }

}

