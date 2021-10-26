package com.example.quizapp.questions;

import com.example.quizapp.R;

public class Quiz {
    PictureQuestion[] questions;

    public Quiz() {
        this.questions = new PictureQuestion[] {
                // array of objects of class Question
                // providing questions from string
                // resource and the correct ans
                // trueAnswer should have lower value than the length of the array
                new PictureQuestion(R.string.a0, 0, new int[] {R.string.a1,
                        R.string.a2, R.string.a3, R.string.a4}),
                new PictureQuestion(R.string.b0, 2, new int[] {R.string.b1,
                        R.string.b2, R.string.b3, R.string.b4}),
                new PictureQuestion(R.string.c0, 3, new int[] {R.string.c1,
                        R.string.c2, R.string.c3, R.string.c4}),
                new PictureQuestion(R.string.d0, 3, new int[] {R.string.d1,
                        R.string.d2, R.string.d3, R.string.d4}),
                new PictureQuestion(R.string.e0, 0, new int[] {R.string.e1,
                        R.string.e2, R.string.e3, R.string.e4}),
                new PictureQuestion(R.string.f0, 3, new int[] {R.string.f1,
                        R.string.f2, R.string.f3, R.string.f4}),
        };
    }

    public PictureQuestion[] getQuestions() {
        return questions;
    }

    public void setQuestions(PictureQuestion[] questions) {
        this.questions = questions;
    }
}
