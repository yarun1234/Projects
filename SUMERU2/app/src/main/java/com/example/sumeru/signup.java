package com.example.sumeru;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    private EditText uname,uemail,upass,umobile;
    private  Button usubmit;
    private TextView ulogin;
   private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        uname=(EditText)findViewById(R.id.idnames);
        uemail=(EditText)findViewById(R.id.idemails);
        upass=(EditText)findViewById(R.id.idpassw1);
        umobile=(EditText)findViewById(R.id.idmobile);
        usubmit=(Button)findViewById(R.id.idsubmit);
        ulogin=(TextView) findViewById(R.id.idalogin);
        mAuth = FirebaseAuth.getInstance();




        usubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                     String name=uname.getText().toString();
                    String email=uemail.getText().toString().trim();
                    String pass=upass.getText().toString().trim();
                    String mobile=umobile.getText().toString();

                    mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {





                                Toast.makeText(signup.this,"registration successful",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(signup.this,MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(signup.this,"registration not successful",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
        ulogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this,MainActivity.class));
            }
        });
    }



    private void check(){
        uname=(EditText)findViewById(R.id.idnames);
        uemail=(EditText)findViewById(R.id.idemails);
        upass=(EditText)findViewById(R.id.idpassw1);
        umobile=(EditText)findViewById(R.id.idmobile);
        usubmit=(Button)findViewById(R.id.idsubmit);
        ulogin=(TextView) findViewById(R.id.idalogin);

    }
    private Boolean validate()
    {
        Boolean result=false;
        final String name=uname.getText().toString();
        final  String email=uemail.getText().toString();
        final String pass=upass.getText().toString();
        final String mobile=umobile.getText().toString();

        if(name.isEmpty()||email.isEmpty()||pass.isEmpty()||mobile.isEmpty())
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