package com.androar.kutnow;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllShops extends Fragment {


    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Shops> shops;



    Integer[] shopId={
            R.drawable.shop1,
            R.drawable.shop2,
            R.drawable.shop3,
            R.drawable.shop4
    };




    public AllShops() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MainActivity) getActivity()).setActionBarTitle("Kutnow");
        // 1.
        myAdapter = new ShopAdapter(getActivity(), shops, shopId);
        myAdapter.notifyDataSetChanged();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_all_shops, container, false);

        shops = new ArrayList<Shops>();
        shops.add(new Shops("KrazyCuts", "Haircuts starting at Rs. 150", "cheap"));
        shops.add(new Shops("SuriyaSalon", "Haircuts starting at Rs. 120", "cheap"));
        shops.add(new Shops("Greentrends", "Haircuts starting at Rs. 280", "costly"));
        shops.add(new Shops("Chillbreeze", "50% Off on your first haircut. Starting at just Rs.99*", "medium"));

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = rootview.findViewById(R.id.rvAllShops);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new ShopAdapter(getActivity(), shops, shopId);
        myAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(myAdapter);



        // Inflate the layout for this fragment
        return rootview;
    }

}
