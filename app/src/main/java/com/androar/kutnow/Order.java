package com.androar.kutnow;


import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Order extends Fragment {

    private ActionBar toolbar;



    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Shops> shops;

    Fragment fragment;

    ImageView iv1, iv2, iv3, iv4, iv5;


    Integer[] shopId={
            R.drawable.shop1,
            R.drawable.shop2,
            R.drawable.shop3,
            R.drawable.shop4
    };



    public Order() {
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


        View rootview =inflater.inflate(R.layout.fragment_order, container, false);

        shops = new ArrayList<Shops>();
        shops.add(new Shops("KrazyCuts", "50+ positive ratings this week", "cheap"));
        shops.add(new Shops("SuriyaSalon", "More than 10 from your neighbourhood rated this well", "cheap"));
        shops.add(new Shops("Greentrends", "70+ positive ratings this week", "costly"));
        shops.add(new Shops("Chillbreeze", "#1 trending near you", "medium"));

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView = rootview.findViewById(R.id.rvShoplist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new ShopAdapter(getActivity(), shops, shopId);
        myAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(myAdapter);

        iv1 = rootview.findViewById(R.id.iv1);
        iv2 = rootview.findViewById(R.id.iv2);
        iv3 = rootview.findViewById(R.id.iv3);
        iv4 = rootview.findViewById(R.id.iv4);
        iv5 = rootview.findViewById(R.id.iv5);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //fragment = new OrderServices();
                //loadFragment(fragment);
            }
        });





        // Inflate the layout for this fragment
        return rootview;
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}
