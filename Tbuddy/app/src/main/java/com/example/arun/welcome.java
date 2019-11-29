package com.example.arun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;

public class welcome extends AppCompatActivity {
    private static int splash_time_out=3000;
    private ImageView loader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        loader=findViewById(R.id.gifid);
        Glide.with(getApplicationContext()).load(R.drawable.loder).apply(RequestOptions.circleCropTransform()).into(loader);
        loader.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeintent=new Intent(welcome.this,Citysselect.class);
                startActivity(homeintent);
                finish();

            }
        },splash_time_out);
    }
}
