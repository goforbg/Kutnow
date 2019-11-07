package com.androar.kutnow;


import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderServices extends Fragment {


    TextView shopProviderName;
    String shopName;

    ProgressDialog progressDialog;

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Salons> salons;


   String advancedstyling;
   String colouring;
   String detans;
   String facials;
   String haircuts;
   String logo;
   String makeovers;
   String manicure;
   String salonName;
   String pedicure;
   Long shopId;
   String threading;
   String waxing;




    public OrderServices() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Bundle bundle = getArguments();
        shopName = bundle.getString("shopName");
        Toast.makeText(getActivity(), shopName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_order_services, container, false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait ...");
        progressDialog.show();
        shopProviderName = view.findViewById(R.id.shopProviderName);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("shops");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                advancedstyling = dataSnapshot.child(shopName).child("advancedstyling").getValue(String.class);
                colouring = dataSnapshot.child(shopName).child("colouring").getValue(String.class);
                detans = dataSnapshot.child(shopName).child("detans").getValue(String.class);
                facials = dataSnapshot.child(shopName).child("facial").getValue(String.class);
                haircuts = dataSnapshot.child(shopName).child("haircuts").getValue(String.class);
                logo = dataSnapshot.child(shopName).child("logo").getValue(String.class);
                makeovers = dataSnapshot.child(shopName).child("makeovers").getValue(String.class);
                manicure = dataSnapshot.child(shopName).child("manicure").getValue(String.class);
                salonName = dataSnapshot.child(shopName).child("name").getValue(String.class);
                pedicure = dataSnapshot.child(shopName).child("pedicure").getValue(String.class);
                shopId = dataSnapshot.child(shopName).child("shopId").getValue(Long.class);
                threading = dataSnapshot.child(shopName).child("threading").getValue(String.class);
                waxing = dataSnapshot.child(shopName).child("waxing").getValue(String.class);
                Log.d("Waxing", waxing);
                shopProviderName.setText(salonName);


                salons = new ArrayList<Salons>();
                salons.add(new Salons("advanced styling", advancedstyling));
                salons.add(new Salons("colouring", colouring));
                salons.add(new Salons("detans", detans));
                salons.add(new Salons("facials", facials));
                salons.add(new Salons("haircuts", haircuts));
                salons.add(new Salons("makeovers", makeovers));
                salons.add(new Salons("manicure", manicure));
                salons.add(new Salons("pedicure", pedicure));
                salons.add(new Salons("threading", threading));
                salons.add(new Salons("waxing", waxing));



                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView = view.findViewById(R.id.rvCart);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(layoutManager);
                myAdapter = new SalonAdapter(getActivity(), salons);
                myAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(myAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Some error!", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
