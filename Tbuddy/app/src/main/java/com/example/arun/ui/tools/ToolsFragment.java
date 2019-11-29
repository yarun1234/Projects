package com.example.arun.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.arun.Admin.addtravelplacesdata;
import com.example.arun.Admin.addtravlingplaces;
import com.example.arun.Admin.upload_image_travel;
import com.example.arun.R;
import com.example.arun.TRAVEL;
import com.example.arun.ui.home.HomeFragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    private TextView des,maplat,maplon,title,cost,timing,idealtiming,besttimetovisit,weather;
    private Button submit;
    DatabaseReference databaseReference,databaseReference1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);

    /*    des= submit.findViewById(R.id.add_submit_id);

        maplat= submit.findViewById(R.id.add_maplan_id);
        maplon= submit.findViewById(R.id.add_maplon_id);
        title= submit.findViewById(R.id.add_title_id);
        cost= submit.findViewById(R.id.add_cost_id);
        timing= submit.findViewById(R.id.add_timings_id);
        idealtiming= submit.findViewById(R.id.add_ideal_timing_id);
        besttimetovisit= submit.findViewById(R.id.add_best_timing_tovisit_id);
        weather= submit.findViewById(R.id.add_weather_id);
        submit= submit.findViewById(R.id.add_submit_id);

        databaseReference= FirebaseDatabase.getInstance().getReference().child("Feedback1");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String des1=des.getText().toString();

                String  maplat1=maplat.getText().toString();
                String  maplon1=maplon.getText().toString();
               String title1=title.getText().toString();

               String cost1=cost.getText().toString();
                String timing1=timing.getText().toString();
                String idealtiming1=idealtiming.getText().toString();
                String besttimetovisit1=besttimetovisit.getText().toString();
                String  weather1=weather.getText().toString();

                feedbackdata user=new feedbackdata();
                user.setDescription(des1);
                user.setMap_lan(maplat1);
                user.setMap_lon(maplon1);
                user.setTitle(title1);
                user.setCost(cost1);
                user.setTiming(timing1);
                user.setIdealtiming(idealtiming1);
                user.setBesttimetovisit(besttimetovisit1);
                user.setWeather(weather1);
                databaseReference.child("feedback").setValue(user);



                Toast.makeText(getActivity(), "Feedback Submit", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), HomeFragment.class);

                startActivity(intent);
                //finish();




            }
        });*/
        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);

        des=view.findViewById(R.id.add_description_id);

        maplat=view.findViewById(R.id.add_maplan_id);
        maplon=view.findViewById(R.id.add_maplon_id);
        title=view.findViewById(R.id.add_title_id);
        cost=view.findViewById(R.id.add_cost_id);
        timing=view.findViewById(R.id.add_timings_id);
        idealtiming=view.findViewById(R.id.add_ideal_timing_id);
        besttimetovisit=view.findViewById(R.id.add_best_timing_tovisit_id);
        weather=view.findViewById(R.id.add_weather_id);
        submit=view.findViewById(R.id.add_submit_id);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Feedback1");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String des1=des.getText().toString();

                String  maplat1=maplat.getText().toString();
                String  maplon1=maplon.getText().toString();
                String title1=title.getText().toString();

                String cost1=cost.getText().toString();
                String timing1=timing.getText().toString();
                String idealtiming1=idealtiming.getText().toString();
                String besttimetovisit1=besttimetovisit.getText().toString();
                String  weather1=weather.getText().toString();

                feedbackdata user=new feedbackdata();
                user.setDescription(des1);
                user.setMap_lan(maplat1);
                user.setMap_lon(maplon1);
                user.setTitle(title1);
                user.setCost(cost1);
                user.setTiming(timing1);
                user.setIdealtiming(idealtiming1);
                user.setBesttimetovisit(besttimetovisit1);
                user.setWeather(weather1);
                databaseReference.child(title1).setValue(user);



                Toast.makeText(getActivity(), "Feedback Submit", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), HomeFragment.class);

                startActivity(intent);


    }



    });

    }
}