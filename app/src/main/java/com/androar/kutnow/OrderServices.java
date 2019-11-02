package com.androar.kutnow;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderServices extends Fragment {


    TextView shopProviderName;


    public OrderServices() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_services, container, false);


        Bundle bundle = this.getArguments();
        if(bundle != null){
            String shopName = bundle.getString("shopName");

            shopProviderName = view.findViewById(R.id.shopProviderName);
            shopProviderName.setText(shopName);

        }

        return view;
    }

}
