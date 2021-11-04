package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.Navigator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;


public class LoginFragment extends Fragment implements View.OnClickListener {
//public class LoginFragment extends Fragment {

    public LoginFragment() {
    }
    Button buttonLogin;
    EditText username;
    EditText password;


    CharSequence text;
    Toast toast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        username = view.findViewById(R.id.loginUserName);
        password = view.findViewById(R.id.loginPassword);
        buttonLogin = view.findViewById(R.id.buttonHome);
        buttonLogin.setOnClickListener(this);
        text = "Username or Password incorrect";
        toast = Toast.makeText(this.getActivity(), text, Toast.LENGTH_SHORT);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case  R.id.buttonHome:
                if (username.getText().toString().equals("test") &&
                        password.getText().toString().equals("123")) {
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
                } else {
                    toast.show();
                }
                break;
        }
    }


}