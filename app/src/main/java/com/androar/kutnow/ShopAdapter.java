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

public class ShopAdapter extends RecyclerView.Adapter <ShopAdapter.ViewHolder> {

    public ArrayList<Salons> salons;
    public Context context;

    private FirebaseDatabase firebaseDatabase;


    public ShopAdapter(Context context, ArrayList<Salons> list)
    {
        salons=list;
        this.context = context;
        notifyDataSetChanged();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        ImageView ivShop;
        TextView tvShopName;
        TextView tvShopDesc;

        public ViewHolder (@NonNull View itemView){
            super(itemView);

            ivShop = itemView.findViewById(R.id.ivShop);
            tvShopName = itemView.findViewById(R.id.tvShop);
            tvShopDesc = itemView.findViewById(R.id.tvShopDesc);
        }
    }
    @NonNull
    @Override
    public ShopAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopAdapter.ViewHolder holder, final int position) {
        holder.itemView.setTag(salons.get(position));

        holder.tvShopName.setText(salons.get(position).getSalonName());

    }


    private void loadFragment(Fragment fragment) {
        // load fragment
    }


    @Override
    public int getItemCount() {
        return salons.size();
    }
}