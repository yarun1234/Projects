package com.example.arun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arun.Admin.AdminHomepage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText email,pass;
    private Button login;
    private TextView newuser;
    private FirebaseAuth mAuth;
    public static String uemail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth=FirebaseAuth.getInstance();

        email=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.idlogin);

        newuser=(TextView) findViewById(R.id.idnewuser);

         /*if (mAuth.getUid() !=null)
         {
             //Toast.makeText(MainActivity.this, mAuth.getUid(), Toast.LENGTH_SHORT).show();
             Intent intent=new Intent(getApplicationContext(),welcome.class);
             finish();
             startActivity(intent);
         }*/

        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,signup.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate()) {
                     uemail = email.getText().toString();
                    String upass = pass.getText().toString();
                    if (uemail.equals("Admin") && upass.equals("123")) {
                        startActivity(new Intent(MainActivity.this, AdminHomepage.class));


                    } else {
                        mAuth.signInWithEmailAndPassword(uemail, upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(),welcome.class);
                                    finish();
                                    startActivity(intent);
                                    //startActivity(new Intent(MainActivity.this, welcome.class));
                                } else {
                                    Toast.makeText(MainActivity.this, "Check email or password", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }
                }
            }
        });



    }

    private Boolean validate()
    {
        Boolean result=false;

        String uemail=email.getText().toString();
        String upass=pass.getText().toString();


        if(uemail.isEmpty()||upass.isEmpty())
        {
            Toast.makeText(this,"please enter all details",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result=true;

        }
        return  result;
    }







}

