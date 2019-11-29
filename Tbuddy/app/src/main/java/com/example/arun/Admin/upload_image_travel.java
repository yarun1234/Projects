package com.example.arun.Admin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arun.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;

public class upload_image_travel extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    Button upload,choose;
    TextView alert;

    ArrayList<Uri> FileList = new ArrayList<Uri>();
    private Uri FileUri;
    private ProgressDialog progressDialog;
    private int upload_count = 0;
    int n=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image_travel);
        alert = findViewById(R.id.alert);
        upload = findViewById(R.id.upload_image);
        choose = findViewById(R.id.chooser);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("File Uploading Please Wait...........");


        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE,true);
                startActivityForResult(intent,PICK_IMAGE);

            }
        });



        upload.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                progressDialog.show();
                alert.setText("If Loading Takes too long please Press the button again");

                StorageReference ImageFolder = FirebaseStorage.getInstance().getReference().child("banglore");


                for(upload_count = 0; upload_count < FileList.size(); upload_count++){


                    Uri IndividualFile = FileList.get(upload_count);
                    final StorageReference ImageName = ImageFolder.child("Image"+IndividualFile.getLastPathSegment());



                    ImageName.putFile(IndividualFile).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            ImageName.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String url = String.valueOf(uri);
                                    String link;

                                    //   databaseReference.setValue(url);
                                    StoreLink(url);

                                }
                            });







                        }
                    });



                }





            }
        });




    }

    private void StoreLink(String url) {


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("city").child("Travel").child("city").child(addtravlingplaces.placename).child(addtravlingplaces.title1);

        String str = Integer.toString(n);
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("image" +str,url);
        n++;

        //databaseReference.push().setValue(hashMap);
        databaseReference.updateChildren(hashMap);
        progressDialog.dismiss();
        alert.setText("File Uploaded Successfully");
        upload.setVisibility(View.GONE);
        FileList.clear();






    }


    @SuppressLint("SetTextI18n")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE){

            if(resultCode == RESULT_OK){

                if(data.getClipData() != null){



                    int countClipData = data.getClipData().getItemCount();



                    int currentImageSelect = 0;

                    while (currentImageSelect < countClipData){


                        FileUri = data.getClipData().getItemAt(currentImageSelect).getUri();

                        FileList.add(FileUri);

                        currentImageSelect = currentImageSelect +1;


                    }

                    alert.setVisibility(View.VISIBLE);
                    alert.setText("You Have Selected "+ FileList.size() +" Images");
                    choose.setVisibility(View.GONE);


                }else{


                    Toast.makeText(this, "Please Select Multiple File", Toast.LENGTH_SHORT).show();
                }


            }


        }


    }
    /*
        String link1;

    public FOOD(String link1) {
            this.link1 = link1;
        }

        public String getLink1 () {
            return link1;
        }

        public void setLink1 (String link1){
            this.link1 = link1;
        }
    */
}