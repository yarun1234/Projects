package com.example.arun;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Citysselect extends AppCompatActivity {


    private Button eventbutton;

    private  String strName;
    private Button  search;
    private int count=0;
    List<String> list=new ArrayList<>();
    List<String>list2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citysselect);
        strName = "";
        eventbutton = findViewById(R.id.selecteventbuttonid);
        search=findViewById(R.id.searcheventbuttonid);
        eventbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(Citysselect.this);

                builderSingle.setTitle("Select One Name:-");

                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Citysselect.this, android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("Mangaluru");
                arrayAdapter.add("Bangaluru");
                arrayAdapter.add("Indore");
                arrayAdapter.add("Hatpipliya");
                arrayAdapter.add("Dewas");
                arrayAdapter.add("Devgarh");
                arrayAdapter.add("Ramalkhedi");



                builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }


                });

                builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        strName = arrayAdapter.getItem(which);
                        eventbutton.setText(strName);
                    }
                });
                builderSingle.show();
            }

        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Citysselect.this,drawerActivity.class);
                intent.putExtra("arun",strName);
                startActivity(intent);
            }
        });
    }




}


