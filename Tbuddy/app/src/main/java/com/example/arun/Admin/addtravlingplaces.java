package com.example.arun.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arun.MainActivity;
import com.example.arun.R;
import com.example.arun.signup;
import com.example.arun.users;
import com.example.arun.welcome;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addtravlingplaces extends AppCompatActivity {
    private TextView des,maplat,maplon,title,cost,timing,idealtiming,besttimetovisit,weather;
    private Button submit;
    DatabaseReference databaseReference,databaseReference1;
 public static String placename, title1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent=getIntent();
        placename=intent.getStringExtra("arun");


        setContentView(R.layout.activity_addtravlingplaces);
        des=findViewById(R.id.add_description_id);

        maplat=findViewById(R.id.add_maplan_id);
        maplon=findViewById(R.id.add_maplon_id);
        title=findViewById(R.id.add_title_id);
        cost=findViewById(R.id.add_cost_id);
        timing=findViewById(R.id.add_timings_id);
        idealtiming=findViewById(R.id.add_ideal_timing_id);
        besttimetovisit=findViewById(R.id.add_best_timing_tovisit_id);
        weather=findViewById(R.id.add_weather_id);
        submit=findViewById(R.id.add_submit_id);

        databaseReference=FirebaseDatabase.getInstance().getReference().child("city").child("Travel").child("city").child(placename);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String des1=des.getText().toString();

                String  maplat1=maplat.getText().toString();
                String  maplon1=maplon.getText().toString();
                  title1=title.getText().toString();
                Double maplat11 = Double.valueOf(maplat1);
                Double maplon11=Double.valueOf(maplon1);
                String cost1=cost.getText().toString();
                String timing1=timing.getText().toString();
                String idealtiming1=idealtiming.getText().toString();
                String besttimetovisit1=besttimetovisit.getText().toString();
                String  weather1=weather.getText().toString();

                addtravelplacesdata user=new addtravelplacesdata();
                user.setDescription(des1);

                user.setMap_lan(maplat11);
                user.setMap_lon(maplon11);
                user.setTitle(title1);
                user.setCost(cost1);
                user.setTiming(timing1);
                user.setIdealtiming(idealtiming1);
                user.setBesttimetovisit(besttimetovisit1);
                user.setWeather(weather1);
                databaseReference.child(title1).setValue(user);



                Toast.makeText(addtravlingplaces.this,"Add successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(addtravlingplaces.this, upload_image_travel.class));
                //finish();




            }
        });

    }
}
