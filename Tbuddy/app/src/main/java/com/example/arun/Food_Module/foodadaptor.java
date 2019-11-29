package com.example.arun.Food_Module;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arun.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public abstract class foodadaptor extends RecyclerView.Adapter<com.example.arun.Food_Module.foodadaptor.modelviewolder> {

    private Context mctx;
    private List<Foodmodel> modelList;


    public foodadaptor(Context mctx, List<Foodmodel> modelList) {
        this.mctx = mctx;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public modelviewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mctx);
        View view=inflater.inflate(R.layout.activity_food_cardview, null);
        return new modelviewolder(view);
    }


    public void onBindViewHolder(@NonNull com.example.arun.Food_Module.foodadaptor.modelviewolder holder, final int position) {

        final Foodmodel model1 = modelList.get(position);
        holder.Menuname.setText(model1.getMenuname());
        Picasso.with(mctx.getApplicationContext()).load(model1.getMenuImage()).into(holder.Menuimage);
        holder.Menuimage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent =new Intent(mctx,item1.class);

                intent.putExtra("catID",model1.getCatID());
                mctx.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class modelviewolder extends RecyclerView.ViewHolder
    {
        ImageView Menuimage;
        TextView Menuname;
        public modelviewolder(@NonNull View itemView)
        {
            super(itemView);
            Menuname = itemView.findViewById(R.id.food_name);
            Menuimage = itemView.findViewById(R.id.food_image);
        }
    }
}


