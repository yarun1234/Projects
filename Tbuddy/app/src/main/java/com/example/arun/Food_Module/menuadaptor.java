package com.example.arun.Food_Module;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arun.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public abstract class menuadaptor extends RecyclerView.Adapter<com.example.arun.Food_Module.menuadaptor.modelviewolder> {

    private Context mctx;
    private List<menumodel> modelList;

    public menuadaptor(Context mctx, List<menumodel> modelList) {
        this.mctx = mctx;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public modelviewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mctx);
        View view=inflater.inflate(R.layout.activity_itemcardview, null);
        return new modelviewolder(view);
    }


    public void onBindViewHolder(@NonNull com.example.arun.Food_Module.menuadaptor.modelviewolder holder, final int position) {

                final menumodel model1 = modelList.get(position);
                holder.Itemname.setText(model1.getItemname());
                Picasso.with(mctx.getApplicationContext()).load(model1.getItemimage()).into(holder.Itemimage);
                holder.Itemimage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               Intent intent =new Intent(mctx,itemdetailscard_view.class);
               intent.putExtra("Iimage",model1.getItemimage());
               intent.putExtra("Iiname",model1.getItemname());
               intent.putExtra("Iprice",model1.getItemprice());
               intent.putExtra("name",menu.anupam);

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
        ImageView Itemimage;
        TextView Itemname;

        public modelviewolder(@NonNull View itemView)
        {
            super(itemView);
            Itemname = itemView.findViewById(R.id.item_name);
            Itemimage = itemView.findViewById(R.id.item_image);
        }
    }
}


