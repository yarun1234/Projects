package com.example.arun.Hotel_module;

import android.os.Bundle;
import android.widget.Toast;

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

public class hotel1 extends AppCompatActivity {

    RecyclerView recyclerView;
    hadapter adapter;
    List<hmodel> modelList;
    DatabaseReference databaseReference1;
    public static String h;
    public static  Double hp;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel1);

        recyclerView=(RecyclerView) findViewById(R.id.myRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelList=new ArrayList<>();

         h =getIntent().getStringExtra("arun");
        Toast.makeText(getApplicationContext(),h,Toast.LENGTH_LONG).show();
        String c="bangalore",f="Bangaluru",k="datafetch",i="Indore";
        if(h.equals(f))
        {
            h=c;
        }
        else if(h.equals(i))
        {
            h=k;
        }
        Toast.makeText(getApplicationContext(),h,Toast.LENGTH_LONG).show();


        // adapter = new ModelAdapter(this, modelList);
        // recyclerView.setAdapter(adapter);

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child(h);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelList.clear();
                for(DataSnapshot d:dataSnapshot.getChildren())
                {
                  //  final String name=d.child("name").getValue().toString();
                    final String shortdesc=d.child("shortdesc").getValue().toString();
                    final String title=d.child("title").getValue().toString();
                    final String image =d.child("image").getValue(String.class);
                    final String  rating =d.child("rating").getValue(String.class);
                    Toast.makeText(getApplicationContext(),title,Toast.LENGTH_LONG).show();
                    double price=Double.parseDouble(d.child("price").getValue().toString());

                    //rating=Double.parseDouble(d.child("rating").getValue().toString());
                    modelList.add(new hmodel(1,title,shortdesc,rating,price,image));

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

     /*   modelList.add(
                new model(
                        1,
                        "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
                        "13.3 inch, Silver, 1.35 kg",
                        4.3,
                        60000,
                        R.drawable.macbook));

        modelList.add(
                new model(
                        1,
                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
                        "14 inch, Gray, 1.659 kg",
                        4.3,
                        60000,
                        R.drawable.dellinspiron));

        modelList.add(
                new model(
                        1,
                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
                        "13.3 inch, Silver, 1.35 kg",
                        4.3,
                        60000,
                        R.drawable.surface));


        adapter = new ModelAdapter(this, modelList);


        recyclerView.setAdapter(adapter);*/


        adapter = new hadapter(this, modelList);



        recyclerView.setAdapter(adapter);

    }




}