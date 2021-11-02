package com.example.quizappnav;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFrag extends AppCompatActivity {

Button login;
EditText username;
EditText password;

Context context;
CharSequence text;
Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_login);

        login = findViewById(R.id.loginButton);
        username = findViewById(R.id.loginUserName);
        password = findViewById(R.id.loginPassword);

        context = getApplicationContext();
        text = "Username or Password incorrect";
        toast = Toast.makeText(context,text,Toast.LENGTH_SHORT );

        login.setOnClickListener((view -> {
            if (username.getText().toString().equals("test")  &&
                    password.getText().toString().equals("123")) {
                Intent browse = new Intent(getApplicationContext(), HomeFrag.class);
                startActivity(browse);
            }
            else{
                toast.show();
            }
        }));


}
}
