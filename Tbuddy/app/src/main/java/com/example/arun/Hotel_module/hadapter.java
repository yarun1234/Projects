package com.example.arun.Hotel_module;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arun.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class





hadapter extends RecyclerView.Adapter<hadapter.modelviewolder> {

    private Context mctx;
    private List<hmodel>modelList;
    private RelativeLayout relativeLayout;

    public hadapter(Context mctx, List<hmodel> modelList) {
        this.mctx = mctx;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public modelviewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mctx);
        View view=inflater.inflate(R.layout.hcardview, null);
        return new modelviewolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull modelviewolder holder, int position) {

       final hmodel model1 = modelList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(model1.getTitle());
        holder.textViewShortDesc.setText(model1.getShortdesc());
        holder.textViewRating.setText(String.valueOf(model1.getRating()));
        holder.textViewPrice.setText(String.valueOf(model1.getPrice()));
        Picasso.with(mctx.getApplicationContext()).load(model1.getImage()).into(holder.RimageView);
        holder.RimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(mctx,hotel_description.class);
                intent.putExtra("title",model1.getTitle());
                hotel1.hp=model1.getPrice();
                mctx.startActivity(intent);
            }
        });


        //holder.RimageView.setImageDrawable(mctx.getResources().getDrawable(Integer.valueOf(model1.getImage())));


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class modelviewolder extends RecyclerView.ViewHolder {


        ImageView RimageView;
         TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        public modelviewolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            RimageView = itemView.findViewById(R.id.RimageView);
        }
    }
}