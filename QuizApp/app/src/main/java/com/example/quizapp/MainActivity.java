package com.example.quizapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.questions.Quizmodul;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    // setting up things
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private TextView questionTextView;
    private TextView questionAttempTV;
    private ArrayList <Quizmodul> quizModulArrayList;
    Random random;
    int currentScore = 0;
    int questAttempt = 1;
    int currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        questionTextView = findViewById(R.id.questionAttemptTV);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        quizModulArrayList = new ArrayList<>();
        random = new Random();
        currentPos = random.nextInt(quizModulArrayList.size());


        setData(currentPos);
        getQuizQuestion(quizModulArrayList);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModulArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(button1.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questAttempt++;
                currentPos = random.nextInt(quizModulArrayList.size());
                setData(currentPos);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModulArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(button2.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questAttempt++;
                currentPos = random.nextInt(quizModulArrayList.size());
                setData(currentPos);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModulArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(button3.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questAttempt++;
                currentPos = random.nextInt(quizModulArrayList.size());
                setData(currentPos);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModulArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(button4.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questAttempt++;
                currentPos = random.nextInt(quizModulArrayList.size());
                setData(currentPos);
            }
        });
    }

    private void ShowScore(){
        BottomSheetDialog bottomSD = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_handling,(LinearLayout)findViewById(R.id.handleScore));
        TextView scoreText = bottomSheetView.findViewById(R.id.TVScore);
        Button restartButton = bottomSheetView.findViewById(R.id.ScoreButton);
        scoreText.setText("Your Score is " + currentScore + " /10");
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModulArrayList.size());
                setData(currentPos);
                questAttempt = 1;
                currentScore = 0;
                bottomSD.dismiss();
            }
        });
        bottomSD.setCancelable(false);
        bottomSD.setContentView(bottomSheetView);
        bottomSD.show();
    }

    private void setData(int currentPos) {
        questionAttempTV.setText("Questions attempted: " + questAttempt + " / 10");
        if (questAttempt == 10){
            ShowScore();
        }
        else {
            questionTextView.setText(quizModulArrayList.get(currentPos).getQuestion());
            button1.setText(quizModulArrayList.get(currentPos).getChoice1());
            button2.setText(quizModulArrayList.get(currentPos).getChoice2());
            button3.setText(quizModulArrayList.get(currentPos).getChoice3());
            button4.setText(quizModulArrayList.get(currentPos).getChoice4());
        }
        }

    private void getQuizQuestion(ArrayList<Quizmodul> quizmodul) {
        quizModulArrayList.add(new Quizmodul("Biggest planet in our solar system","Earth","Saturn","Jupiter","Mars","Jupiter"));
        quizModulArrayList.add(new Quizmodul("Name of a flower","Golden Retriever","Sun","Google","Rose","Rose"));
        quizModulArrayList.add(new Quizmodul("Which of these can not move","A Rock","A Lion","A Human","A Monkey","A Rock"));
        quizModulArrayList.add(new Quizmodul("1 + 2 = ?","1","2","3","4","3"));
    }
}