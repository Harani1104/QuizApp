package com.example.quizappnav;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class CreateQuiz extends AppCompatActivity {

    EditText question1;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_quiz);

        submit = findViewById(R.id.createSubmit);

        submit.setOnClickListener((view -> {
            Intent subber = new Intent(getApplicationContext(),HomeFrag.class);
            startActivity(subber);
        }));
//        question1 = findViewById(R.id.question);
//                                                  //Not Implemented yet
//        question1.setOnClickListener((view -> {
//            Intent quest1 = new Intent(getApplicationContext(),CreateQuiz.class);
//            startActivity(quest1);
//        }));
    }
}
