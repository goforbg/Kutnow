package com.androar.kutnow;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class SalonAdapter extends RecyclerView.Adapter <SalonAdapter.ViewHolder> {

    public ArrayList<Shops> shops;
    public Context context;

    private FirebaseDatabase firebaseDatabase;


    public SalonAdapter(Context context, ArrayList<Shops> list)
    {
        shops=list;
        this.context = context;
        notifyDataSetChanged();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        public ViewHolder (@NonNull View itemView){
            super(itemView);

        }
    }
    @NonNull
    @Override
    public SalonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_order_services, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SalonAdapter.ViewHolder holder, final int position) {
        holder.itemView.setTag(shops.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f1 = new OrderServices();
                Bundle args1 = new Bundle();
                args1.putString("shopName", shops.get(position).getShopName());
                f1.setArguments(args1);
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, f1);
                transaction.addToBackStack(null);
                transaction.commit();

                Toast.makeText(v.getContext(), "Position is" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void loadFragment(Fragment fragment) {
        // load fragment
    }


    @Override
    public int getItemCount() {
        return shops.size();
    }
}