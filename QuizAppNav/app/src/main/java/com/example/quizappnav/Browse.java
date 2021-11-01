package com.example.quizappnav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class Browse extends AppCompatActivity {

    Button filter;
    EditText filterText;
    ListView quizList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_activity);

        Button filter = findViewById(R.id.filter);
        EditText filterText = findViewById(R.id.filterText);
        ListView quizList = findViewById(R.id.quizList);


    }
}