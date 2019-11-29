package com.example.sumeru;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    private TextView travel,hotel,cab,food,rent;
    private ImageView travelimg,hotelimg,cabimg,foodimg,rentimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        travel=(TextView)findViewById(R.id.idtravel);
        hotel=(TextView)findViewById(R.id.idhotel);
        cab=(TextView)findViewById(R.id.idcab);
        food=(TextView)findViewById(R.id.idfood);
        rent=(TextView)findViewById(R.id.idrent);
        travelimg=(ImageView)findViewById(R.id.idtravelimg);
        hotelimg=(ImageView)findViewById(R.id.idhotelimg);
        cabimg=(ImageView)findViewById(R.id.idcabimg);
        foodimg=(ImageView)findViewById(R.id.idfoodimg);
        rentimg=(ImageView)findViewById(R.id.idrentimg);

        travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,TRAVEL.class));
            }
        });
        travelimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,TRAVEL.class));
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,HOTEL.class));
            }
        });
        hotelimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,HOTEL.class));
            }
        });

        cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,CAB.class));
            }
        });
        cabimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,CAB.class));
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,FOOD.class));
            }
        });
        foodimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,FOOD.class));
            }
        });

        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,RENT.class));
            }
        });
        rentimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homepage.this,RENT.class));
            }
        });

    }
}
