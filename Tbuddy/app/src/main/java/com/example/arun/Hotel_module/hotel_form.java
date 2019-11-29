package com.example.arun.Hotel_module;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.arun.R;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class hotel_form extends AppCompatActivity {
    private FirebaseAuth f;
    private TextView confirm,hotelname;
    private Context context;
    private EditText cidate,codate,fname,lname,preference,email,contact,dfname,dlname,cardnumber,exdatem,exdatey;
    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_form);
        confirm=(TextView)findViewById(R.id.confirm);
        cidate =  (EditText)findViewById(R.id.checkindate);
        codate =  (EditText)findViewById(R.id.chechoutdate);
        fname =  (EditText)findViewById(R.id.fnameform);
        lname =  (EditText)findViewById(R.id.lnameform);
        preference=(EditText)findViewById(R.id.acnonac);
        email=(EditText)findViewById(R.id.formemail);
        hotelname=(TextView)findViewById(R.id.formhotelname);
        contact =(EditText)findViewById(R.id.formcontact);
       final ImageView i;
        i=(ImageView)findViewById(R.id.fomrimage);
        f = FirebaseAuth.getInstance();
        Firebase.setAndroidContext(getApplicationContext());




       final String  h=getIntent().getStringExtra("hotel");
        Toast.makeText(getApplicationContext(),h,Toast.LENGTH_LONG).show();

        hotelname.setText(h);

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

                    if(title.equals(h))
                    {
                        Picasso.with(context).load(image).into(i);
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





        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String cid,cod,fn,ln,pref,eml,con,dfn,dln,cardn,exmn,exyr;
                cid=cidate.getText().toString();
                cod=codate.getText().toString();
                fn=fname.getText().toString();
                ln=lname.getText().toString();
                pref=preference.getText().toString();
                eml=email.getText().toString();
                con=contact.getText().toString();

                if(cid.isEmpty())
                {
                     cidate.setError("please enter the check in date");
                     cidate.requestFocus();
                }
                else if(cod.isEmpty())
                {
                    codate.setError("please enter the check our date");
                    codate.requestFocus();
                }
                else if(fn.isEmpty())
                {
                    fname.setError("please enter the name");
                    fname.requestFocus();
                }
                else if(ln.isEmpty())
                {
                    lname.setError("please enter the name");
                    lname.requestFocus();
                }
                else if(pref.isEmpty())
                {
                    preference.setError("please enter the preferance");
                    preference.requestFocus();
                }
                else if(eml.isEmpty())
                {
                    email.setError("please enter the email");
                    email.requestFocus();
                }
                else if(con.isEmpty())
                {
                    contact.setError("please enter the contact");
                    contact.requestFocus();
                }
                else
                {
                    hoteluser hoteluser=new hoteluser(cid,cod,fn,ln,pref,eml,con);


                    Firebase firebase = new Firebase(config.url);
                    firebase.child("hoteluser").child(con).setValue(hoteluser);

                    Intent i= new Intent(hotel_form.this,confirmbook.class);
                    startActivity(i);
                    finish();


                }





            }
        });





    }
}
