package com.androar.kutnow;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CheckoutItemsAdapter extends RecyclerView.Adapter <CheckoutItemsAdapter.ViewHolder> {

    public ArrayList<Checkoutitemobjects> checkoutitemobjects;
    private Integer[] shopId;
    public Context context;

    public CheckoutItemsAdapter(Context context, ArrayList<Checkoutitemobjects> list, Integer[] ShopId)
    {
        this.shopId=shopId;
        checkoutitemobjects=list;
        this.context = context;
        notifyDataSetChanged();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        TextView tvCheckoutItemName;
        TextView tvCheckoutItemShop;
        TextView tvCheckoutItemPrice;
        ImageView ivCheckoutItemImage;


        public ViewHolder (@NonNull View itemView){
            super(itemView);

            tvCheckoutItemName = itemView.findViewById(R.id.tvCheckoutItemName);
            tvCheckoutItemPrice = itemView.findViewById(R.id.tvCheckoutItemPrice);
            tvCheckoutItemShop = itemView.findViewById(R.id.tvCheckoutItemShop);
            ivCheckoutItemImage = itemView.findViewById(R.id.ivCheckoutItemImage);

        }
    }
    @NonNull
    @Override
    public CheckoutItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.checkout_single_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CheckoutItemsAdapter.ViewHolder holder, final int position) {
        holder.itemView.setTag(checkoutitemobjects.get(position));
        holder.tvCheckoutItemShop.setText(checkoutitemobjects.get(position).getCheckoutShopName());
        holder.tvCheckoutItemName.setText(checkoutitemobjects.get(position).getCheckoutServiceName());
        holder.tvCheckoutItemPrice.setText(checkoutitemobjects.get(position).getCheckoutServicePrice());
        holder.ivCheckoutItemImage.setImageResource(shopId[position]);


    }


    private FragmentTransaction loadFragment() {
        // load fragment
        FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        return transaction;
    }


    @Override
    public int getItemCount() {
        return checkoutitemobjects.size();
    }
}