package com.example.arun.Food_Module;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arun.MainActivity;
import com.example.arun.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class itemdetailscard_view extends AppCompatActivity {

    String Iitemname,Iitemimage,Iitemprice;
    String itquant,totalprice;
    ImageView img;
    TextView iname;
    TextView iprice;
    Button Itemadd,viewdetails;
    EditText itemqunatity;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;
    int price,total,TP=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_itemdetailscard_view);
        img = (ImageView) findViewById(R.id.cardimage);
        iname = (TextView) findViewById(R.id.carditem);
        iprice = (TextView) findViewById(R.id.carditemprice);
        itemqunatity = (EditText) findViewById(R.id.carditemquant);
        viewdetails=(Button)findViewById(R.id.vieworder) ;
        Itemadd = (Button) findViewById(R.id.carditemadd);
        Iitemimage = getIntent().getStringExtra("Iimage");
        Iitemname = getIntent().getStringExtra("Iiname");
        Iitemprice = getIntent().getStringExtra("Iprice");
        Picasso.with(this).load(Iitemimage).into(img);
        iname.setText(Iitemname);
        iprice.setText(Iitemprice);


        mAuth = FirebaseAuth.getInstance();

        databaseReference = FirebaseDatabase.getInstance().getReference("request");

        Itemadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate())
                {

                        orderdetails orderdetails = new orderdetails();
                        orderdetails.setEmail(MainActivity.uemail);
                        orderdetails.setItem( Iitemname);
                        orderdetails.setNoq(itquant);
                        orderdetails.setOrderprice(totalprice);

                        //FirebaseDatabase.getInstance().getReference("request").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(orderdetails);
                            databaseReference.push().setValue(orderdetails);
                        Toast.makeText(itemdetailscard_view.this, "item Added", Toast.LENGTH_SHORT).show();


                }
                else
                    {
                        Toast.makeText(itemdetailscard_view.this, "error", Toast.LENGTH_SHORT).show();
                    }

                }


        });



        viewdetails.setOnClickListener(new View.OnClickListener()
        {

        public void onClick(View v)
        {

            Intent intent=new Intent(itemdetailscard_view.this,vieworderlist.class);

            itemdetailscard_view.this.startActivity(intent);

        }


    });
}

    private Boolean validate()
    {
        Boolean result=false;
        itquant=itemqunatity.getText().toString();
        price=Integer.parseInt(Iitemprice);
        total=price*Integer.parseInt(itquant);
        totalitemprice.totalprice=totalitemprice.totalprice+total;
        totalprice=String.valueOf(total);


        if(itquant.isEmpty())
        {
            Toast.makeText(this,"please add quantity",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result=true;


        }
        return  result;
    }
}
