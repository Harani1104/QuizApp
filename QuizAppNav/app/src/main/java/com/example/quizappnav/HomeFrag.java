package com.example.quizappnav;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;

public class HomeFrag extends AppCompatActivity {

    Button browse;
    Button lagny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_home);

        //browse = findViewById(R.id.browse);      //Not implemented yet
//        browse.setOnClickListener((view -> {
//            Intent browser = new Intent(getApplicationContext(),Browse.class);
//            startActivity(browser);

        lagny = findViewById(R.id.lagNy);
        lagny.setOnClickListener((view -> {
            Intent lagerNy = new Intent(getApplicationContext(), QuizOverview.class);
            startActivity(lagerNy);
        }));
    }


}
