package com.example.quizappnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class CreateQuiz extends AppCompatActivity {

    Button prev;
    Button next;
    Button finish;
    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_quiz);

        prev = findViewById(R.id.previousQuest);
        next = findViewById(R.id.nextQuest);
        finish = findViewById(R.id.finish);

        finish.setOnClickListener((view -> {
            Intent subber = new Intent(getApplicationContext(),QuizOverview.class);
            startActivity(subber);
        }));
    }
}