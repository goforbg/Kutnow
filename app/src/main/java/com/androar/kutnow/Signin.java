package com.androar.kutnow;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class Signin extends Fragment {


    EditText etUsername;
    EditText etPassword;
    String username,password;

    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;

    public Signin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signin, container, false);

        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        etUsername = view.findViewById(R.id.etSigninemail);
        etPassword = view.findViewById(R.id.etSigninPassword);

        username = etUsername.getText().toString();
        password = etPassword.getText().toString();


        // Inflate the layout for this fragment
        return view;
    }

}
