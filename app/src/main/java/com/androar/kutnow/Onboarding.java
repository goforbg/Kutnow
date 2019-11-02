package com.androar.kutnow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Onboarding extends AppCompatActivity {

    Button signin, signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        signin = findViewById(R.id.btnSignIn);
        signup = findViewById(R.id.btnSignUp);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin.setVisibility(View.GONE);
                signup.setVisibility(View.GONE);
                Fragment fragment = new Signin();
                    // load fragment
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.frame_container2, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin.setVisibility(View.GONE);
                signup.setVisibility(View.GONE);
                Fragment fragment = new Signup();
                // load fragment
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container2, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });



    }



}
