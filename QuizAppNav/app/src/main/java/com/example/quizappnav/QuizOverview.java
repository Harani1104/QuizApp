package com.example.quizappnav;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class QuizOverview extends AppCompatActivity {

    Button quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_overview);

        quiz = findViewById(R.id.quizName);

        quiz.setOnClickListener((view -> {
            Intent subber = new Intent(getApplicationContext(),CreateQuiz.class);
            startActivity(subber);
        }));

    }
}
