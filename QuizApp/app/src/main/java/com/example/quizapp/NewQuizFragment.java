package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.quizapp.model.questions.*;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;


public class NewQuizFragment extends Fragment implements View.OnClickListener {

    private EditText inQuestion, inAlt0, inAlt1, inAlt2, inAlt3;
    private Button finishQuiz, nextQuest, previousQuest;
    private ArrayList<Question> questions;
    private int currentPage;
    private RadioGroup radioGroupCorrectAnswer;

    private FirebaseFirestore firestoreDb;
    private CollectionReference quizCollectionReference;

    public NewQuizFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        currentPage = 0;
        questions = new ArrayList<>();

        //setting up elements associated with id
        inQuestion = view.findViewById(R.id.inQuestion);
        inAlt0 = view.findViewById(R.id.inAlt0);
        inAlt1 = view.findViewById(R.id.inAlt1);
        inAlt2 = view.findViewById(R.id.inAlt2);
        inAlt3 = view.findViewById(R.id.inAlt3);
        finishQuiz = view.findViewById(R.id.finishQuiz);
        nextQuest = view.findViewById(R.id.nextQuest);
        previousQuest = view.findViewById(R.id.previousQuest);
        radioGroupCorrectAnswer = view.findViewById(R.id.radioGroupCorrectAnswer);

        //adds listener
        finishQuiz.setOnClickListener(this);
        nextQuest.setOnClickListener(this);
        previousQuest.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        if(inQuestion.getText().toString().equals("") || inAlt0.getText().toString().equals("") || inAlt1.getText().toString().equals("") || inAlt2.getText().toString().equals("") || inAlt3.getText().toString().equals("") || (radioGroupCorrectAnswer.getCheckedRadioButtonId() == -1)) {
            Toast.makeText(this.getActivity(), "alle felt må bli fylt ut", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (view.getId()) {
            case R.id.finishQuiz:
                finishEdit();
                break;
            case R.id.nextQuest:
                goToNextQuestion();
                break;
            case R.id.previousQuest:
                goToPreviousQuestion();
                break;
        }
    }

    private void goToNextQuestion() {
        editQuestion();
        currentPage++;
        refreshPage();
    }

    private void goToPreviousQuestion() {
        if (currentPage == 0){
            refreshPage();
            return;
        }
        editQuestion();
        currentPage--;
        refreshPage();
    }



    @SuppressLint("RestrictedApi")
    public void finishEdit(){
        editQuestion();
        saveQuiz();
        this.getActivity().dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK));
        this.getActivity().dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK));
    }



    public void refreshPage(){
        if (currentPage < questions.size()) {
            inQuestion.setText(questions.get(currentPage).getQuestion());
            inAlt0.setText(questions.get(currentPage).getAnswers().get(0));
            inAlt1.setText(questions.get(currentPage).getAnswers().get(1));
            inAlt2.setText(questions.get(currentPage).getAnswers().get(2));
            inAlt3.setText(questions.get(currentPage).getAnswers().get(3));
        } else {
            inQuestion.setText("");
            inAlt0.setText("");
            inAlt1.setText("");
            inAlt2.setText("");
            inAlt3.setText("");
        }
        radioGroupCorrectAnswer.clearCheck();
    }

    private void editQuestion() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add(inAlt0.getText().toString());
        answers.add(inAlt1.getText().toString());
        answers.add(inAlt2.getText().toString());
        answers.add(inAlt3.getText().toString());

        int radioButtonID = radioGroupCorrectAnswer.getCheckedRadioButtonId();
        View radioButton = radioGroupCorrectAnswer.findViewById(radioButtonID);
        int radioIndex = radioGroupCorrectAnswer.indexOfChild(radioButton);
        if (currentPage < questions.size()) {
            questions.set(currentPage, new Question(inQuestion.getText().toString(), radioIndex, answers));
        } else {
            questions.add(new Question(inQuestion.getText().toString(), radioIndex, answers));
        }
    }

    private void saveQuiz() {
        firestoreDb = FirebaseFirestore.getInstance();
        quizCollectionReference = firestoreDb.collection("quizes");
        Quiz quiz = new Quiz(questions);
        quizCollectionReference.add(quiz);
    }
}