package com.example.arun.Hotel_module;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arun.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static com.example.arun.Hotel_module.hotel1.hp;


public class hotel_description extends AppCompatActivity {
    private TextView nametext,price,ratingdes,sa,bn;
    private ImageView image1;
    private String hotelname1;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_description);
        nametext=(TextView)findViewById(R.id.hotelnamedes);
        ratingdes=(TextView) findViewById(R.id.hotelrating);
        price=findViewById(R.id.hotelprice);
        image1=findViewById(R.id.imagedes);
        sa=findViewById(R.id.seeall);
        bn=findViewById(R.id.booknow);



        sa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(hotel_description.this,hotel1.class);
                startActivity(i);
                finish();
            }
        });



        hotelname1=getIntent().getStringExtra("title");
        Toast.makeText(getApplicationContext(),hotelname1,Toast.LENGTH_LONG).show();
        String p = new Double(hp).toString();

        price.setText(p);


      // nametext.setText(hotelname1);

     //   nametext.setText(s);
        Toast.makeText(getApplicationContext(),hotel1.h,Toast.LENGTH_LONG).show();



        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference().child(hotel1.h);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot d:dataSnapshot.getChildren())
                {
                 //   final String name=d.child("name").getValue().toString();
                    final String shortdesc=d.child("shortdesc").getValue().toString();
                    final String title=d.child("title").getValue().toString();
                    final String image =d.child("image1").getValue(String.class);
                    final String  rating =d.child("rating").getValue(String.class);

                    double price=Double.parseDouble(d.child("price").getValue().toString());


                    if(title.equals(hotelname1))
                    {
                        nametext.setText(title);
                       ratingdes.setText(rating);
                        Picasso.with(context).load(image).into(image1);
                        Toast.makeText(getApplicationContext(),rating,Toast.LENGTH_LONG).show();
                        break;
                    }
                    //rating=Double.parseDouble(d.child("rating").getValue().toString());
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ImageView i=image1;

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(hotel_description.this,hotel_form.class);
                i.putExtra("hotel",hotelname1);




                startActivity(i);
            }
        });
    }
}
