package com.example.arun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class TRAVEL extends AppCompatActivity {

    RecyclerView recyclerView;
   //private FirebaseRecyclerAdapter<Blog, BlogViewHolder> adapter;
    ModelAdapter adapter;
  // LottieAnimationView eventLoader;
    private ImageView loader;
    List<model> modelList;
   DatabaseReference databaseReference1;
   private String placename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        placename=intent.getStringExtra("arun");
        //Toast.makeText(TRAVEL.this,  MainActivity.email,Toast.LENGTH_SHORT).show();

        modelList=new ArrayList<>();
        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
       recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("city").child("Travel").child("city").child(placename);
        //DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("datafetch");



        databaseReference.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              modelList.clear();

               for(DataSnapshot d:dataSnapshot.getChildren())

               {
                   Toast.makeText(TRAVEL.this,placename,Toast.LENGTH_SHORT).show();


                   final String title=d.child("title").getValue().toString();
                   final String image =d.child("image1").getValue(String.class);

                  //final String image2 =d.child("image2").getValue(String.class);

                   modelList.add(new model(1,title,image,placename));
               }
               runOnUiThread(new Runnable() {
                   public void run() {
                       adapter.notifyDataSetChanged();
                   }
               });

           }

         @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });


        adapter = new ModelAdapter(this, modelList);


        recyclerView.setAdapter(adapter);


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

