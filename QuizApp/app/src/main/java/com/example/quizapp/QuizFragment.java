package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.lang.reflect.Array;

import com.example.quizapp.questions.PictureQuestion;

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
    private Button button0, button1, button2, button3, resetButton;
    private ImageButton nextButton, prevButton;
    private ImageView Image;
    private TextView questionTextView;
    // to keep current question track
    private int currentQuestionIndex = 0;

    private PictureQuestion[] questionBank = new PictureQuestion[] {
            // array of objects of class Question
            // providing questions from string
            // resource and the correct ans
            // trueAnswer should have lower value than the length of the array
            new PictureQuestion(R.string.a0, 0, new int[] {R.string.a1,
                    R.string.a2, R.string.a3, R.string.a4}),
            new PictureQuestion(R.string.b0, 2, new int[] {R.string.b1,
                    R.string.b2, R.string.b3, R.string.b4}),
            new PictureQuestion(R.string.c0, 3, new int[] {R.string.c1,
                    R.string.c2, R.string.c3, R.string.c4}),
            new PictureQuestion(R.string.d0, 3, new int[] {R.string.d1,
                    R.string.d2, R.string.d3, R.string.d4}),
            new PictureQuestion(R.string.e0, 0, new int[] {R.string.e1,
                    R.string.e2, R.string.e3, R.string.e4}),
            new PictureQuestion(R.string.f0, 3, new int[] {R.string.f1,
                    R.string.f2, R.string.f3, R.string.f4}),
    };



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
        int NumberOfQuestions = Array.getLength(questionBank);
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
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex - 1)
                            % questionBank.length;updateQuestion();
                }
                break;
            case R.id.reset_button:
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

                updateQuestion();
        }
    }

    private int findTotalScore() {
        // variable to hold the total score
        int total = 0;
        // counts how many answers are correct
        for (int i = 0; i < Array.getLength(questionBank); i++) {
            if(questionBank[i].getAnsweredTrue()) {
                total++;
            }
        }
        return total;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateQuestion() {
        Log.d("Current", "onClick: " + currentQuestionIndex);

        //updates questions and answers
        questionTextView.setText(questionBank[currentQuestionIndex].getQuestionResId());
        button0.setText(questionBank[currentQuestionIndex].getAnswersResId()[0]);
        button1.setText(questionBank[currentQuestionIndex].getAnswersResId()[1]);
        button2.setText(questionBank[currentQuestionIndex].getAnswersResId()[2]);
        button3.setText(questionBank[currentQuestionIndex].getAnswersResId()[3]);
    }

    private void checkAnswer(int userAnswer) {
        //fetch the true answer
        int trueAnswer = questionBank[currentQuestionIndex].getTrueAnswerIndex();
        // getting correct ans of current question
        int toastMessageId;
        // if ans matches with the button clicked
        if (userAnswer == trueAnswer) {
            toastMessageId = R.string.correct_answer;
            questionBank[currentQuestionIndex].setAnsweredTrue(true);
        } else {
            // showing toast message correct
            toastMessageId = R.string.wrong_answer;
            questionBank[currentQuestionIndex].setAnsweredTrue(false);
        }

        //TODO
        //return toastMessageId;
        //Toast.makeText(QuizFragment.this, toastMessageId, Toast.LENGTH_SHORT).show();
    }
}