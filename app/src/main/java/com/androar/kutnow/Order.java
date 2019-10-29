package com.androar.kutnow;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Order extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Shops> shops;



    public Order() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview =inflater.inflate(R.layout.fragment_order, container, false);

        Shops shop1 = new Shops("Krazy Cuts", "50+ positive ratings this week", "cheap");
        Shops shop2 = new Shops("Suriya Salon", "More than 10 from your neighbourhood rated this well", "cheap");
        Shops shop3 = new Shops("Green trends", "70+ positive ratings this week", "costly");
        Shops shop4 = new Shops("Chillbreeze", "#1 trending near you", "medium");
        shops = new ArrayList<Shops>();
        shops.add(shop1);
        shops.add(shop2);
        shops.add(shop3);
        shops.add(shop4);



        Integer[] shopId={
                R.drawable.shop1,
                R.drawable.shop2,
                R.drawable.shop3,
                R.drawable.shop4
        };


        myAdapter = new ShopAdapter(getActivity(), shops, shopId);
        myAdapter.notifyDataSetChanged();


        recyclerView = rootview.findViewById(R.id.rvShoplist);

        recyclerView.setAdapter(myAdapter);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }

}
