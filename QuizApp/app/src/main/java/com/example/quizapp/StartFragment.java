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

        //sends the user to Login
        Button buttonLogin = view.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_startFragment_to_loginFragment));

        //sends the user to userregistration (frame 2)
        Button buttonNewUser = view.findViewById(R.id.buttonNewUser);
        buttonNewUser.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_startFragment_to_registerFragment));

        //køyrer ein ferdig quiz lagd for å teste (frame 6, deretter 7)
        StartFragmentDirections.ActionStartFragmentToQuizFragment action = StartFragmentDirections.actionStartFragmentToQuizFragment(
                "DZBZsLOZTbgxUInZH6CX");

        Button buttonSkipTOQuiz = view.findViewById(R.id.buttonSkipToQuiz);
        buttonSkipTOQuiz.setOnClickListener(Navigation.createNavigateOnClickListener(action));
    }
}