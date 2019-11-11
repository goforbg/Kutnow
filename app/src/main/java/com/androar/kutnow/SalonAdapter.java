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

public class SalonAdapter extends RecyclerView.Adapter <SalonAdapter.ViewHolder> {

    int cart = 0;

    public ArrayList<Salons> salons;
    public Context context;

    public SalonAdapter(Context context, ArrayList<Salons> list)
    {
        salons=list;
        this.context = context;
        notifyDataSetChanged();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        TextView tvServiceName;
        TextView tvPrice;
        Button btnAdd;

        TextView tvCartTotal;
        Button btnCartCheckout;

        public ViewHolder (@NonNull View itemView){
            super(itemView);

            tvServiceName = itemView.findViewById(R.id.tvServiceName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            btnAdd = itemView.findViewById(R.id.btnadd);

        }
    }
    @NonNull
    @Override
    public SalonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final SalonAdapter.ViewHolder holder, final int position) {
        holder.itemView.setTag(salons.get(position));
        if (salons.get(position).getServicename().equals("advanced styling")) {
            holder.tvServiceName.setText("Advanced Hairstyle");
        }
        else {
        holder.tvServiceName.setText(salons.get(position).getServicename()); }

        holder.tvPrice.setText(salons.get(position).getPrice());
        String message = salons.get(position).getServicename();

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (salons.get(position).getPrice()!=null) {
                    cart += Integer.parseInt(salons.get(position).getPrice());
                    String cartvalue = String.valueOf(cart);
                    Log.d("price of cart", cartvalue);

                    BottomSheetCart bottomSheetCart= new BottomSheetCart();
                    Bundle bundle = new Bundle();
                    bundle.putString("cartvalue", cartvalue);
                    bottomSheetCart.setArguments(bundle);
                    bottomSheetCart.show(loadFragment(),"example");


                }
                else {
                    cart += 150;
                }
            }
        });

        String cartvalue = String.valueOf(cart);
        Log.d("price", cartvalue);

    }


    private FragmentTransaction loadFragment() {
        // load fragment
        FragmentTransaction transaction = ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction();
        return transaction;
    }


    @Override
    public int getItemCount() {
        return salons.size();
    }
}