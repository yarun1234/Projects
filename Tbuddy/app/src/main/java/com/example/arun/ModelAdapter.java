package com.example.arun;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.modelviewolder> {

    private Context mctx;
    private List<model>modelList;

    public ModelAdapter(Context mctx, List<model> modelList) {
        this.mctx = mctx;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public modelviewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mctx);
        View view=inflater.inflate(R.layout.recycletravel, null);
        return new modelviewolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull modelviewolder holder, int position) {

        final model model = modelList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewplacename.setText(model.getPlacename());
        //holder.RimageView.setImageDrawable(mctx.getResources().getDrawable(model.getImage()));
        Picasso.with(mctx.getApplicationContext()).load(model.getImage()).into(holder.RimageView);

       // holder.RimageView2.setImageDrawable(mctx.getResources().getDrawable(model.getImage1()));

       //Glide.with(mctx).load(model.getImage1()).into(holder.RimageView2);
       // Picasso.with(mctx.getApplicationContext()).load(model.getImage1()) .into(holder.RimageView2);
        holder.RimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(mctx,onclicktravelcardview.class);
                intent.putExtra("arun",model.getTitle());
                intent.putExtra("yadav",model.getPlacename());
                mctx.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class modelviewolder extends RecyclerView.ViewHolder {
        private CardView mcardview;
      ImageView RimageView,RimageView2,a;
      TextView textViewTitle,textViewplacename;
        public modelviewolder(@NonNull View itemView) {
            super(itemView);
           mcardview=itemView.findViewById(R.id.trevelcardviewid);
            textViewTitle = itemView.findViewById(R.id.titleid);
            RimageView = itemView.findViewById(R.id.Rimageid);
            textViewplacename=itemView.findViewById(R.id.travel_placename_id);
           // RimageView2 = itemView.findViewById(R.id.Rimageid2);

        }
    }
}
