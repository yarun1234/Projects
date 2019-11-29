package com.example.arun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arun.CAB_Module.CAB;
import com.example.arun.Food_Module.FOOD;
import com.example.arun.Food_Module.restaurant;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

public class onclicktravelcardview extends AppCompatActivity {
    private String placename,city ;
    private TextView title;
    private TextView disc,cost,timing,idealtiming,besttimetovisit,weather,cityname,foodbook,cabbook;
    private ImageView image;
    private TextView mapactivity;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
  //  ViewGroup view11;
    //private TextView dischide;
    //private Button hidebar;
    private   String[] urls = new String[] {"a","b","c","z"};
    DatabaseReference databaseReference;
    private double latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclicktravelcardview);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        Intent intent=getIntent();
        placename=intent.getStringExtra("arun");
        city=intent.getStringExtra("yadav");
        //Toast.makeText(onclicktravelcardview.this,city,Toast.LENGTH_SHORT).show();
         disc=findViewById(R.id.description_id);
        title=findViewById(R.id.titile_id);
         image=findViewById(R.id.mapactivityid1);
         mapactivity=findViewById(R.id.mapactivityid);
        cost=findViewById(R.id.show_cost_id);
        timing=findViewById(R.id.show_timings_id);
        idealtiming=findViewById(R.id.show_ideal_timing_id);
        besttimetovisit=findViewById(R.id.show_best_timing_tovisit_id);
        weather=findViewById(R.id.show_weather_id);
        cityname=findViewById(R.id.Banglore_id);
        cityname.setText(city);
        foodbook=findViewById(R.id.Book_food_travel_id);
        cabbook=findViewById(R.id.Book_cab_travel_id);
        foodbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(onclicktravelcardview.this, restaurant.class);
                intent.putExtra("arun1",city);
                startActivity(intent);
            }
        });
        cabbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(onclicktravelcardview.this, CAB.class);

                intent.putExtra("arun1",city);
                startActivity(intent);
            }
        });
        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("city").child("Travel").child("city").child(city);
       // final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Bangloreplaces");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dd:dataSnapshot.getChildren())
                {

                    final String disc1=dd.child("title").getValue().toString();
                       if(disc1.equals(placename)) {
                           final String title1 = dd.child("description").getValue().toString();
                           disc.setText(title1);

                           title.setText(disc1);
                           final String image11 = dd.child("image1").getValue().toString();
                           final String image12 = dd.child("image2").getValue().toString();
                           final String image13 = dd.child("image3").getValue().toString();
                           final String image14 = dd.child("image4").getValue().toString();
                           final String COST1 = dd.child("cost").getValue().toString();
                           cost.setText(COST1);
                           final String timing1 = dd.child("timing").getValue().toString();
                           timing.setText(timing1);
                           final String idealtiming1 = dd.child("idealtiming").getValue().toString();
                           idealtiming.setText(idealtiming1);
                           final String besttimeovisit1 = dd.child("besttimetovisit").getValue().toString();
                           besttimetovisit.setText(besttimeovisit1);
                           final String weather1 = dd.child("weather").getValue().toString();
                           weather.setText(weather1);

                           urls[0]=image11;
                           urls[1]=image12;
                           urls[2]=image13;
                           urls[3]=image14;

                           //Picasso.with(getApplicationContext()).load(image11).into(image1);
                          latitude= (double)dd.child("map_lan").getValue();
                          longitude=(double)dd.child("map_lon").getValue();


                           break;
                       }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mapactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String myUri = String.format ("geo:%f,%f?q=%f,%f(%s)",latitude,longitude,latitude,longitude,"Mylocation");
                Uri gmmIntentUri = Uri.parse(myUri);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(onclicktravelcardview.this.getPackageManager()) != null) {
                    onclicktravelcardview.this.startActivity(mapIntent);
                }
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String myUri = String.format ("geo:%f,%f?q=%f,%f(%s)",latitude,longitude,latitude,longitude,"Mylocation");
                Uri gmmIntentUri = Uri.parse(myUri);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(onclicktravelcardview.this.getPackageManager()) != null) {
                    onclicktravelcardview.this.startActivity(mapIntent);
                }
            }
        });



    }
    private void init() {

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(onclicktravelcardview.this,urls));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES = urls.length;

        // Auto start of viewpager
        final Handler handler = new Handler();

        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }
   public boolean onOptionsItemSelected(MenuItem item)
    {
        int id=item.getItemId();
        if(id== android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
