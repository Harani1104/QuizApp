package com.example.quizappnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class StarterPage extends AppCompatActivity {

    Button login;
    Button newUser;
    Button kode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starter_page);

        login = findViewById(R.id.loginStarter);
        newUser = findViewById(R.id.newUser);
        kode = findViewById(R.id.kode);

        login.setOnClickListener((view -> {
            Intent logger = new Intent(getApplicationContext(),LoginFrag.class);
            startActivity(logger);
        }));

        newUser.setOnClickListener((view -> {
            Intent newUserLog = new Intent(getApplicationContext(),NewUser.class);
            startActivity(newUserLog);
        }));

        kode.setOnClickListener((view -> {
            Intent kodeLog = new Intent(getApplicationContext(),LoginFrag.class);
            startActivity(kodeLog);
        }));
    }
}