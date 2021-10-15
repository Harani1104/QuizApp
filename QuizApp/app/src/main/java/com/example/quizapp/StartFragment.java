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


public class StartFragment extends Fragment {

    public StartFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //sends the user home(frame 3)
        //todo implement login
        Button buttonToHome = view.findViewById(R.id.buttonToHome);
        buttonToHome.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_homeFragment));

        //sends the user to userregistration (frame 2)
        //TODO implement user registration
        Button buttonNewUser = view.findViewById(R.id.buttonNewUser);
        buttonNewUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_registerFragment));

        //køyrer ein ferdig quiz lagd for å teste (frame 6, deretter 7)
        //TODO implement guest user
        Button buttonSkipTOQuiz = view.findViewById(R.id.buttonSkipToQuiz);
        buttonSkipTOQuiz.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_quizFragment));
    }
}