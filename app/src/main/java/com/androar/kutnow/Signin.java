package com.androar.kutnow;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Signin extends Fragment {


    EditText etUsername;
    EditText etPassword;
    String username,password;
    Button btnSigninSubmit;

    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebase;


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
        btnSigninSubmit = view.findViewById(R.id.btnSigninSubmit);

        username = etUsername.getText().toString();
        password = etPassword.getText().toString();

        firebase = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = firebase.getReference("user");

        btnSigninSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(getActivity());
                mDialog.setMessage("Please wait!...");
                mDialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        mDialog.dismiss();
                        User user = dataSnapshot.child(etUsername.getText().toString()).getValue(User.class);
                        if (user.getPassword().equals(etPassword.getText().toString())) {

                            Toast.makeText(getActivity(), "Successful sign in!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getActivity(), "Some error occurred!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

}
