package com.example.arun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;


import com.example.arun.ui.gallery.GalleryFragment;
import com.example.arun.ui.home.HomeFragment;
import com.example.arun.ui.send.SendFragment;
import com.example.arun.ui.share.ShareFragment;
import com.example.arun.ui.slideshow.SlideshowFragment;
import com.example.arun.ui.tools.ToolsFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.smarteist.autoimageslider.IndicatorView.draw.drawer.Drawer;

import java.text.MessageFormat;

public class Homepage extends AppCompatActivity  {
    private DrawerLayout drawer;
    private AppBarConfiguration mAppBarConfiguration;
    private ActionBarDrawerToggle mDrawerToggle;
    private TextView travel, hotel, cab, food, rent;
    private TextView userNameHeaderTextView;
    FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        mauth = FirebaseAuth.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
       // navigationView.setNavigationItemSelectedListener(this);
        View hView = navigationView.getHeaderView(0);
        userNameHeaderTextView = hView.findViewById(R.id.nev_header_name);
        // Passing each menu ID as a set of Ids because each
        //menu should be considered as top level destinations.



//       ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close );
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



   public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
  /* public void onClickSignOut(MenuItem item) {
       AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
       builder1.setTitle("Sign Out");
       builder1.setMessage("Are you sure? You won't be able to get event related updates.");
      builder1.setCancelable(true);

       builder1.setPositiveButton(
               "Yes",
               new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       FirebaseAuth.getInstance().signOut();
                       //clear user workmanager notifications
                       //WorkManager.getInstance(getApplicationContext()).cancelAllWork();
                       dialog.dismiss();
                       Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                       intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                       startActivity(intent);
                   }
               });

       builder1.setNegativeButton(
               "No",
               new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                       dialog.cancel();
                   }
               });

       AlertDialog alert11 = builder1.create();
       alert11.show();
   }
*/




//   @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//
//        switch (item.getItemId())
//        {
//            case R.id.menulogoutid:
//
//                FirebaseAuth.getInstance().signOut();
//                finish();
//                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(intent);
//                break;
//
//
//        }
//
//        return true;
//    }
//
//
//
}

