package com.example.arun.Food_Module;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arun.MainActivity;
import com.example.arun.R;

public class orderplaced extends AppCompatActivity {

    Button done1,vieworder1;
    TextView addressshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderplaced);
        done1=(Button)findViewById(R.id.done);
        vieworder1=(Button)findViewById(R.id.btnorderlist);
        addressshow=(TextView)findViewById(R.id.addressview);
       Intent i=getIntent();
       String getaddress=i.getStringExtra("address");
       addressshow.setText(getaddress);
        done1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(orderplaced.this, MainActivity.class);
                addressshow.setText(" ");
                orderplaced.this.startActivity(intent);
            }
        });

        vieworder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(orderplaced.this,orderview_notcart.class);
                orderplaced.this.startActivity(intent);
            }
        });
    }
}
