package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.example.quizapp.model.questions.*;

public class QuizFragment extends Fragment implements View.OnClickListener {

    public QuizFragment() {
        // Required empty public constructor
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    // setting up things
    private Button button0, button1, button2, button3, resetButton, nextButton, prevButton;
    private ImageView Image;
    private TextView questionTextView;
    // to keep current question track
    private int currentQuestionIndex = 0;
    Quiz quiz;
    private ArrayList<Question> questionBank;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quiz = new Quiz();
        questionBank = quiz.getQuestions();

        // setting up the elements associated with id
        button0 = view.findViewById(R.id.answer_button_0);
        button1 = view.findViewById(R.id.answer_button_1);
        button2 = view.findViewById(R.id.answer_button_2);
        button3 = view.findViewById(R.id.answer_button_3);
        nextButton = view.findViewById(R.id.next_button);
        prevButton = view.findViewById(R.id.prev_button);
        resetButton = view.findViewById((R.id.reset_button));

        questionTextView = view.findViewById(R.id.answer_text_view);
        Image = view.findViewById(R.id.myimage);
        // register our buttons to listen to click events
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        prevButton.setOnClickListener(this);
        resetButton.setOnClickListener(this);
        updateQuestion();
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        // checking which button is clicked by user in this case user choose false
        int NumberOfQuestions = questionBank.size();
        switch (v.getId()) {
            case R.id.answer_button_0:
                checkAnswer(0);
                break;
            case R.id.answer_button_1:
                checkAnswer(1);
                break;
            case R.id.answer_button_2:
                checkAnswer(2);
                break;
            case R.id.answer_button_3:
                checkAnswer(3);
                break;
            case R.id.next_button:
                // go to next question limiting question bank range
                if (currentQuestionIndex < NumberOfQuestions) {
                    currentQuestionIndex = currentQuestionIndex + 1;
                    // last question reached making buttons invisible
                    if (currentQuestionIndex == NumberOfQuestions) {
                        questionTextView.setText(getString(R.string.correct, findTotalScore(), NumberOfQuestions));
                        nextButton.setVisibility(View.INVISIBLE);
                        prevButton.setVisibility(View.INVISIBLE);
                        button0.setVisibility(View.INVISIBLE);
                        button1.setVisibility(View.INVISIBLE);
                        button2.setVisibility(View.INVISIBLE);
                        button3.setVisibility(View.INVISIBLE);
                        resetButton.setVisibility(View.VISIBLE);

                        if (findTotalScore() > 3)
                            questionTextView.setText(
                                    "CORRECTNESS IS " + findTotalScore() + " " + "OUT OF " + NumberOfQuestions);
                        // showing correctness
                    } else {
                        updateQuestion();
                    }
                }
                break;
            case R.id.prev_button: // goes back to prev queastion
                if (currentQuestionIndex > 0) { currentQuestionIndex = (currentQuestionIndex - 1) % questionBank.size();
                    updateQuestion();
                }
                break;
            case R.id.reset_button:
                resetQuiz();
        }
    }

    private void resetQuiz(){
        //we resets the quiz
        //toggle visibility of buttons
        //and set the currentQuestionIndex bak to 0
        currentQuestionIndex = 0;
        updateQuestion();
        nextButton.setVisibility(View.VISIBLE);
        prevButton.setVisibility(View.VISIBLE);
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.INVISIBLE);

        for (int i = 0; i < questionBank.size(); i++) {
            //resets what the user answered
            questionBank.get(i).setAnsweredTrue(false);
        }

        updateQuestion();
    }

    private int findTotalScore() {
        // variable to hold the total score
        int total = 0;
        // counts how many answers are correct
        for (int i = 0; i < questionBank.size(); i++) {
            if(questionBank.get(i).getAnsweredTrue()) {
                total++;
            }
        }
        return total;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateQuestion() {
        Log.d("Current", "onClick: " + currentQuestionIndex);

        //updates questions and answers
        questionTextView.setText(questionBank.get(currentQuestionIndex).getQuestion());
        button0.setText(questionBank.get(currentQuestionIndex).getAnswers().get(0));
        button1.setText(questionBank.get(currentQuestionIndex).getAnswers().get(1));
        button2.setText(questionBank.get(currentQuestionIndex).getAnswers().get(2));
        button3.setText(questionBank.get(currentQuestionIndex).getAnswers().get(3));
    }

    private void checkAnswer(int userAnswer) {
        //fetch the true answer
        int trueAnswer = questionBank.get(currentQuestionIndex).getTrueAnswerIndex();
        // getting correct ans of current question
        int toastMessageId;
        // if answer matches with the button clicked
        if (userAnswer == trueAnswer) {
            toastMessageId = R.string.correct_answer;
            questionBank.get(currentQuestionIndex).setAnsweredTrue(true);
        } else {
            //showing toast message correct
            toastMessageId = R.string.wrong_answer;
            questionBank.get(currentQuestionIndex).setAnsweredTrue(false);
        }

        //show message
        Toast.makeText(this.getActivity(), toastMessageId, Toast.LENGTH_SHORT).show();
    }
}