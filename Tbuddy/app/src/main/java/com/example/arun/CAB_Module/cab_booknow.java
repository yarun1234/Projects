package com.example.arun.CAB_Module;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arun.R;
import com.example.arun.onclicktravelcardview;
import com.example.arun.signup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class cab_booknow extends AppCompatActivity {
private double lat1=0.0,lon1=0.0,lat2=0.0,lon2=0.0;
private String placename,city,s11,s21;
private TextView dis,money;
private Button confirm_booking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_booknow);


        Intent intent=getIntent();
        placename=intent.getStringExtra("arun");
        city=intent.getStringExtra("yadav");
        s11=intent.getStringExtra("a");
        s21=intent.getStringExtra("b");
        dis=findViewById(R.id.cab_totle_distance_id);
        money=findViewById(R.id.totle_money_cab_id);
        confirm_booking=findViewById(R.id.confirm_booking_id);

      //
        lat1=Double.parseDouble(s11);
        lon1=Double.parseDouble(s21);
        String s10=String.valueOf(lat1);
        confirm_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myUri = String.format ("geo:%f,%f?q=%f,%f(%s)",lat1,lon1,lat2,lon2,"Mylocation");
                Uri gmmIntentUri = Uri.parse(myUri);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(cab_booknow.this.getPackageManager()) != null) {
                    cab_booknow.this.startActivity(mapIntent);
                }
            }
        });

        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("city").child("Travel").child("city").child(city);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dd:dataSnapshot.getChildren())
                {

                    final String disc1=dd.child("title").getValue().toString();
                    if(disc1.equals(placename)) {



                        //Picasso.with(getApplicationContext()).load(image11).into(image1);
                        lat2= (double)dd.child("map_lan").getValue();
                        lon2=(double)dd.child("map_lon").getValue();
                        String s1=String.valueOf(lat2);
                          distance(lat1,lon1,lat2,lon2);
                      //  Toast.makeText(cab_booknow.this,s1,Toast.LENGTH_SHORT).show();
                       // Toast.makeText(cab_booknow.this,s1,Toast.LENGTH_SHORT).show();


                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        // double dist=  distance(lat1,lon1,lat2,lon2);
       //    Toast.makeText(cab_booknow.this, (int) dist,Toast.LENGTH_SHORT).show();
          // String s=String.valueOf(dist);
           //dis.setText(s);




    }

    private void distance(double lat11, double lon11, double lat22, double lon22) {
        Location startPoint=new Location("locationA");
        startPoint.setLatitude(lat11);
        startPoint.setLongitude(lon11);

        Location endPoint=new Location("locationA");
        endPoint.setLatitude(lat22);
        endPoint.setLongitude(lon22);

        double distance=startPoint.distanceTo(endPoint);
        distance=distance/1000;
        int a = (int) Math.round(distance);
        double paise=0.0;
        String s=String.valueOf(a);
        dis.setText(s);
        if(distance<5)
            paise=20;
        else if(distance>5 && distance<30)
            paise=distance*7;
        else if(distance>30)
            paise=distance*5;

        int a1 = (int) Math.round(paise);
        String s1=String.valueOf(a1);
        money.setText(s1);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }



    }


