package com.example.arun.Food_Module;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arun.R;

import java.util.List;

public abstract class vieworderadoptor<remove_item> extends RecyclerView.Adapter<com.example.arun.Food_Module.vieworderadoptor.modelviewolder> {


    private Context mctx;
    private List<orderdetails> modelList;

    public vieworderadoptor(Context mctx, List<orderdetails> modelList) {
        this.mctx = mctx;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public modelviewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(mctx);
        View view=inflater.inflate(R.layout.activity_viewordercardview, null);
        return new modelviewolder(view);
    }


    public void onBindViewHolder(@NonNull com.example.arun.Food_Module.vieworderadoptor.modelviewolder holder, final int position) {

        final orderdetails model1 = modelList.get(position);
        holder.Itemname.setText(model1.getItem());
        holder.Itemquat.setText(model1.getNoq());
        holder.Itemprice.setText(model1.getOrderprice());

        //totalitemprice.totalprice=totalitemprice.totalprice+Integer.parseInt(model1.getOrderprice());

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class modelviewolder extends RecyclerView.ViewHolder
    {

        TextView Itemname,Itemprice,Itemquat;


        public modelviewolder(@NonNull View itemView)
        {
            super(itemView);
            Itemname = itemView.findViewById(R.id.vieworderitem);
            Itemprice=itemView.findViewById(R.id.vieworderprice);
            Itemquat=itemView.findViewById(R.id.vieworderquantity);


        }
    }

}


