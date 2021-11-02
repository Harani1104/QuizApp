package com.example.quizappnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starter_page);

        login = findViewById(R.id.loginButton);


        login.setOnClickListener((view -> {
            Intent browse = new Intent(getApplicationContext(),StarterPage.class);
            startActivity(browse);
        }));
    }
}