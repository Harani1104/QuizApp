package com.example.quizapp;

import static android.content.ContentValues.TAG;

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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

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

    //Eksempelet hadde "private", usikker på om det er satt på riktig sted
    FirebaseAuth mAuth;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Fortsatt usikker om jeg har lagt in auth riktig


        username = view.findViewById(R.id.loginUserName);
        password = view.findViewById(R.id.loginPassword);
        buttonLogin = view.findViewById(R.id.buttonHome);
        buttonLogin.setOnClickListener(this);
        text = "Username or Password incorrect";
        toast = Toast.makeText(this.getActivity(), text, Toast.LENGTH_SHORT);

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
        }
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {



        switch (view.getId()) {
            case  R.id.buttonHome:
                if (!(username.getText().toString().isEmpty() || password.getText().toString().isEmpty())) {

                    mAuth.signInWithEmailAndPassword(username.getText().toString(), password.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Log.d(TAG, "signInWithEmail:success");
                                        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
                                    } else {
                                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                                        Toast.makeText(view.getContext(), "login failed!!.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                } else {
                    Toast.makeText(this.getActivity(), "Fyll inn alle felt", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}