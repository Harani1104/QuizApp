package com.example.quizappnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NewUser extends AppCompatActivity {

    EditText name;
    EditText password;
    EditText mail;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);

        submit = findViewById(R.id.userSubmit);
        submit.setOnClickListener((view -> {
            Intent submitLog = new Intent(getApplicationContext(),StarterPage.class);
            startActivity(submitLog);
        }));
    }
    }
