package com.example.arun.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.arun.CAB_Module.CAB;
import com.example.arun.Food_Module.FOOD;
import com.example.arun.Food_Module.restaurant;
import com.example.arun.Hotel_module.hotel1;
import com.example.arun.R;
import com.example.arun.TRAVEL;
import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private DrawerLayout drawer;

    private TextView travel, hotel, cab, food, rent,travelimage;
    private TextView travelimg;

    FirebaseAuth mauth;


    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {



        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
       View root = inflater.inflate(R.layout.fragment_home, container, false);
       return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        super.onViewCreated(view, savedInstanceState);
       final String placename=getActivity().getIntent().getExtras().getString("arun");
        travel = view.findViewById(R.id.idtravel);
        hotel = view.findViewById(R.id.idhotel);
        cab = view.findViewById(R.id.idcab);
        food = view.findViewById(R.id.idfood);
        travelimg=view.findViewById(R.id.travel_image11_id);



        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TRAVEL.class);
                intent.putExtra("arun",placename);
                startActivity(intent);
            }
        });
        travelimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),TRAVEL.class);
                intent.putExtra("arun",placename);
                startActivity(intent);
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), hotel1.class);
                intent.putExtra("arun",placename);
                startActivity(intent);

            }
        });
        cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CAB.class);
                intent.putExtra("arun1",placename);
                startActivity(intent);
            }
        });
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), restaurant.class);
                intent.putExtra("arun",placename);
                startActivity(intent);
            }
        });




    }


}


