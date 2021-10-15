package com.example.quizapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class HomeFragment extends Fragment {



    public HomeFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //sends the user browse(frame 5)
        //todo implement browser
        Button buttonBrowse = view.findViewById(R.id.buttonBrowse);
        buttonBrowse.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_browseFragment));

        //sends the user to the quizmaker (frame 4)
        //TODO implement quizmaker
        Button buttonNewQuiz= view.findViewById(R.id.buttonNewQuiz);
        buttonNewQuiz.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_newQuizFragment));
    }
}