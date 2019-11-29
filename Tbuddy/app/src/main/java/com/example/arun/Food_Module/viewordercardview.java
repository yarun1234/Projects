package com.example.arun.Food_Module;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.arun.R;
import com.google.firebase.database.DatabaseReference;

public class viewordercardview extends AppCompatActivity {
   Button ritem;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewordercardview);
        ritem = (Button) findViewById(R.id.removeitem);
        ritem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }
}

