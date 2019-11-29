package com.example.arun.Food_Module;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.arun.MainActivity;
import com.example.arun.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class orderview_notcart extends AppCompatActivity {




    RecyclerView recyclerView;
    vieworderadoptor adapter;
    List<orderdetails> modelList;
    DatabaseReference databaseReference1;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderview_notcart);


        recyclerView=(RecyclerView) findViewById(R.id.recycle_orderlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelList=new ArrayList<>();
        // viewtotalprice=String.valueOf(totalitemprice.totalprice);



        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("request");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelList.clear();
                for(DataSnapshot d:dataSnapshot.getChildren())
                {
                    final String email=d.child("email").getValue(String.class);
                    if(email!=null && MainActivity.uemail!=null && email.equals(MainActivity.uemail))
                    {
                        final String item=d.child("item").getValue(String.class);
                        final String noq=d.child("noq").getValue(String.class);
                        final String orderprice =d.child("orderprice").getValue(String.class);
                        modelList.add(new orderdetails(item,orderprice,noq,email));
                    }

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

        adapter = new vieworderadoptor(this, modelList){};


        recyclerView.setAdapter(adapter);

    }




}