package com.androar.kutnow;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CheckoutItems extends Fragment {


    public CheckoutItems() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout_items, container, false);
        Bundle bundle = new Bundle();
        String cartValue =  getArguments().getString("cartvalue");
        return view;
    }

}
