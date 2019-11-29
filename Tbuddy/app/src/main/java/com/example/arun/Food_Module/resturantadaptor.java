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

public abstract class resturantadaptor extends RecyclerView.Adapter<resturantadaptor.modelviewolder> {

    private Context mctx;
    private List<resturantmodel>modelList;


    public resturantadaptor(Context mctx, List<resturantmodel> modelList) {
        this.mctx = mctx;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public modelviewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mctx);
        View view=inflater.inflate(R.layout.activity_cardview, null);
        return new modelviewolder(view);
    }


    public void onBindViewHolder(@NonNull modelviewolder holder, int position) {

        final resturantmodel model1 = modelList.get(position);

        //binding the data with the viewholder views
        holder.restname.setText(model1.getRestaurantname());
        holder.restdesc.setText(model1.getRestDescription());
        holder.restrating.setText(String.valueOf(model1.getRating()));

       Picasso.with(mctx.getApplicationContext()).load(model1.getImage()).into(holder.RimageView);
       holder.RimageView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent =new Intent(mctx,menu.class);
                intent.putExtra("title",model1.getRestaurantname());
                mctx.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class modelviewolder extends RecyclerView.ViewHolder {


        ImageView RimageView;
        TextView restname, restdesc, restrating;
        public modelviewolder(@NonNull View itemView) {
            super(itemView);

            restname = itemView.findViewById(R.id.restname);
            restdesc = itemView.findViewById(R.id.restdesc);
            restrating = itemView.findViewById(R.id.restrating);

            RimageView = itemView.findViewById(R.id.restpic);
        }
    }
}