package com.example.quizappnav;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class CreateQuiz extends AppCompatActivity {

    Button question1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_quiz);

//        question1 = findViewById(R.id.question);
//                                                  //Not Implemented yet
//        question1.setOnClickListener((view -> {
//            Intent quest1 = new Intent(getApplicationContext(),CreateQuiz.class);
//            startActivity(quest1);
//        }));
    }
}
