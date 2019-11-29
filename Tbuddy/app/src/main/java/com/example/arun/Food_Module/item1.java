package com.example.arun.Food_Module;

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

public class item1 extends AppCompatActivity {

    RecyclerView recyclerView;
    menuadaptor adapter;
    List<menumodel> modelList;
    String categoryID=" ";





    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item1);
        categoryID=getIntent().getStringExtra("catID");
        recyclerView=(RecyclerView) findViewById(R.id.recycler_item);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        modelList=new ArrayList<>();
         String s =getIntent().getStringExtra("name");

     //   Toast.makeText(getApplicationContext(),menu.anupam,Toast.LENGTH_LONG).show();

        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child("Food").child(menu.anupam);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                modelList.clear();
                for(DataSnapshot d:dataSnapshot.getChildren())
                {
                    final String Iname=d.child("name").getValue(String.class);
                    final String Iimage =d.child("image").getValue(String.class);
                    final String MenuID=d.child("menuId").getValue(String.class);
                    final String price=d.child("price").getValue(String.class);
                    if(categoryID.equals(MenuID)){
                    modelList.add(new menumodel(Iname,Iimage,MenuID,price));}

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

        adapter = new menuadaptor(this, modelList){};

        recyclerView.setAdapter(adapter);

    }




}