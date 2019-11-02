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
public class Signup extends Fragment {

    EditText etName, etPassword, etPhone, etEmail;
    Button btnSignup;


    private FirebaseUser user;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebase;


    public Signup() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view  =  inflater.inflate(R.layout.fragment_signup, container, false);

        etEmail = view.findViewById(R.id.etEmail);
        etPassword = view.findViewById(R.id.etPassword);
        etName = view.findViewById(R.id.etName);
        etPhone = view.findViewById(R.id.etPhone);
        btnSignup = view.findViewById(R.id.btnSignupSubmit);

        FirebaseDatabase firebase = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = FirebaseDatabase.getInstance().getReference("user");

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mdialog = new ProgressDialog(getActivity());
                mdialog.setMessage("Please wait! ... ");
                mdialog.show();
                table_user.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.child(etPhone.getText().toString()).exists()) {
                            mdialog.dismiss();
                            Toast.makeText(getActivity(), "Phone number already exists!", Toast.LENGTH_SHORT).show();
                        }

                        else
                            {
                            mdialog.dismiss();
                            User user = new User (etPhone.getText().toString(), etPassword.getText().toString());
                            table_user.child(etPhone.getText().toString()).setValue(user);
                                Toast.makeText(getActivity(), "Sign up successful!", Toast.LENGTH_SHORT).show();
                            }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        //Return view
        return view;
    }

}
