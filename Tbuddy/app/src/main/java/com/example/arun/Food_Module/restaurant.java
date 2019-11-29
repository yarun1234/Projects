package com.example.arun.Food_Module;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arun.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class restaurant extends AppCompatActivity {


    RecyclerView recyclerView;
    resturantadaptor adapter;
    List<resturantmodel> modelList;
    DatabaseReference databaseReference1;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        recyclerView=(RecyclerView) findViewById(R.id.restrecycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelList=new ArrayList<>();
        String s =getIntent().getStringExtra("arun");

        // adapter = new ModelAdapter(this, modelList);
        // recyclerView.setAdapter(adapter);

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Food").child(s);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelList.clear();
                for(DataSnapshot d:dataSnapshot.getChildren())
                {
                    //  final String name=d.child("name").getValue().toString();
                    final String restdesc=d.child("restdesc").getValue(String.class);
                    final String restname=d.child("restname").getValue(String.class);
                    final String restpic =d.child("restpic").getValue(String.class);
                    final String  restrating =d.child("restrating").getValue(String.class);
                    //Toast.makeText(getApplicationContext(),restname,Toast.LENGTH_LONG).show();

                    //rating=Double.parseDouble(d.child("rating").getValue().toString());
                    modelList.add(new resturantmodel(restrating,restname,restdesc,restpic));

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        adapter = new resturantadaptor(this, modelList){};


        recyclerView.setAdapter(adapter);

    }




}