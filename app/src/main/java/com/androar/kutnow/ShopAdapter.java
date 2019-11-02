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

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter <ShopAdapter.ViewHolder> {

    public ArrayList<Shops> shops;
    private final Integer[] shopId;
    public Context context;


    public ShopAdapter(Context context, ArrayList<Shops> list, Integer[] shopId)
    {
        shops=list;
        this.shopId=shopId;
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
        holder.itemView.setTag(shops.get(position));

        holder.tvShopName.setText(shops.get(position).getShopName());
        holder.tvShopDesc.setText(shops.get(position).getShopDesc());

        /*
        if (shops.get(position).getPrice().equals("cheap")) {
            holder.ivPrice.setImageResource(R.drawable.ic_cheap);
        }

        if (shops.get(position).getPrice().equals("medium")) {
            holder.ivPrice.setImageResource(R.drawable.ic_medium);
        }

        if (shops.get(position).getPrice().equals("costly")) {
            holder.ivPrice.setImageResource(R.drawable.ic_costly);
        }

        if (shops.get(position).getShopName().equals("")) {
            holder.ivPrice.setImageResource(R.drawable.ic_cheap);
        }

         */

        holder.ivShop.setImageResource(shopId[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment f1 = new OrderServices();
                Bundle args1 = new Bundle();
                args1.putString(shops.get(position).getShopName() ,"shopName");
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