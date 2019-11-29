package com.example.ignite19.ui.LeaderBoard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ignite19.R;
import com.example.ignite19.showResults;

import java.util.List;

public class resultsAdapter extends RecyclerView.Adapter<resultsAdapter.resultsViewHolder>{
    private List<String> event_name;
    Context context;
    private int lastPosition = -1;

    public resultsAdapter(Context context, List<String> event_name) {
        this.event_name = event_name;


        this.context=context;
    }

    @NonNull
    @Override
    public resultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.results_list_card_view,parent,false);
        return  new resultsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull resultsViewHolder holder, int position) {
        final String event_title=event_name.get(position);
        setAnimation(holder.itemView,position);
        holder.event_name_tv.setText(event_title);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i=new Intent(context, showResults.class);
                //i.putExtra("event",event_title);
                Bundle bundle = new Bundle();
                bundle.putString("event",event_title);
                //context.startActivity(i);
                Navigation.findNavController(view).navigate(R.id.action_fragmentLeaderBoard_to_eventResultsUser,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(event_name!=null)
        return event_name.size();
        else
            return 0;
    }
    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull resultsViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.clearAnimaiton();
    }

    public class resultsViewHolder extends RecyclerView.ViewHolder{
        private TextView event_name_tv;
        public resultsViewHolder(@NonNull View itemView) {
            super(itemView);
            event_name_tv=itemView.findViewById(R.id.results_card_event_name_textview);
        }

        public void clearAnimaiton() {
            itemView.clearAnimation();
        }
    }
}



