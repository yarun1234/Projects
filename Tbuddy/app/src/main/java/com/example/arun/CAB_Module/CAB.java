package com.example.arun.CAB_Module;

import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.Settings;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.example.arun.R;
import com.example.arun.onclicktravelcardview;
import com.example.arun.signup;

import java.util.ArrayList;

public class CAB extends AppCompatActivity {
    private static final int REQUEST_LOCATION = 1;
    Button getcurrentlocation, destination, booknow;
    LocationManager locationManager;
    String latitude, longitude;
    SearchView searchView;
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;
    private static final String[] COUNTRIES = new String[]{
            "Afghanistan", "Albania", "Algeria", "Andorra" ,"A" ,"b" , "c","aa","AA","Aaa","Addd"
    , "Aw","ww","ss","ee","rr"};
    private ArrayList<String> countries1 = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab);
        Intent intent=getIntent();
       final String placename=intent.getStringExtra("arun1");
        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        getcurrentlocation = findViewById(R.id.selectlocation_id);
       // destination = findViewById(R.id.select_destination_id);
        booknow = findViewById(R.id.book_cab_id);

        getcurrentlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                //Check gps is enable or not

                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    //Write Function To enable gps

                    OnGPS();
                } else {
                    //GPS is already On then

                    getLocation();
                }
            }
        });



        String[] countries = getResources().getStringArray(R.array.countries);

        final AutoCompleteTextView editText = findViewById(R.id.select_destination_id);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.custom_list_item, R.id.text_view_list_item, countries);
        editText.setAdapter(adapter);


        booknow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination1=editText.getText().toString();
                String s11=String.valueOf(latitude);
                String s21=String.valueOf(longitude);
                //Toast.makeText(CAB.this,s11,Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(CAB.this, cab_booknow.class);
                intent.putExtra("arun",destination1);
                intent.putExtra("yadav",placename);
                intent.putExtra("a",s11);
                intent.putExtra("b",s21);

               startActivity(intent);
            }
        });


       /* destination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(CAB.this);

                builderSingle.setTitle("Select One Name:-");

                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(CAB.this, android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("Bangalore Palace");

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
                      String  strName = arrayAdapter.getItem(which);
                        destination.setText(strName);
                    }
                });
                builderSingle.show();
            }

        });*/


    }



    private void getLocation() {

        //Check Permissions again

        if (ActivityCompat.checkSelfPermission(CAB.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(CAB.this,

                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location LocationGps = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Location LocationNetwork = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            Location LocationPassive = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

            if (LocationGps != null) {
                double lat = LocationGps.getLatitude();
                double longi = LocationGps.getLongitude();

                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                getcurrentlocation.setText("Your location");
            } else if (LocationNetwork != null) {
                double lat = LocationNetwork.getLatitude();
                double longi = LocationNetwork.getLongitude();

                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                getcurrentlocation.setText("Your Location");
            } else if (LocationPassive != null) {
                double lat = LocationPassive.getLatitude();
                double longi = LocationPassive.getLongitude();

                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);

                getcurrentlocation.setText("Your Location");
            } else {
                Toast.makeText(this, "Can't Get Your Location", Toast.LENGTH_SHORT).show();
            }

            //Thats All Run Your App
        }

    }

    private void OnGPS() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
