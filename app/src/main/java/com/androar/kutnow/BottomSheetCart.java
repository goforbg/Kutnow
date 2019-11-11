package com.androar.kutnow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetCart extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_cart, container, false);

        TextView tvTotalCart = view.findViewById(R.id.tvCartTotal);
        String cartValue =  getArguments().getString("cartvalue");
        tvTotalCart.setText("Total value: "+cartValue);

        return view;
    }
}
