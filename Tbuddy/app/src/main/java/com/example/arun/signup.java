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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class    signup extends AppCompatActivity {

    private EditText uname,uemail,upass,umobile,ucpass;
    private Button usubmit;
    private TextView ulogin;
    private FirebaseAuth mAuth;
    private String name,email,pass,mobile,cpass;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        uname=(EditText)findViewById(R.id.signup_page_nameid);
        uemail=(EditText)findViewById(R.id.signup_page_emailid);
        upass=(EditText)findViewById(R.id.signup_page_passwordid);
        ucpass=(EditText)findViewById(R.id.signup_page_cpasswordid);
        umobile=(EditText)findViewById(R.id.signup_page_mobilenoid);
        usubmit=(Button)findViewById(R.id.signup_page_Buttonid);
        ulogin=(TextView) findViewById(R.id.signup_page_Alredysignupid);
        mAuth = FirebaseAuth.getInstance();




        usubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {




                    mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {


                                users user=new users();
                                user.setName(name);
                                user.setEmail(email);
                                user.setMobile(mobile);
                                user.setPass(pass);

                                FirebaseDatabase.getInstance().getReference().child("city").child("user").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user);


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




    private Boolean validate()
    {
        Boolean result=false;
        name=uname.getText().toString();
        email=uemail.getText().toString();
        cpass=ucpass.getText().toString();
        pass=upass.getText().toString();
        mobile=umobile.getText().toString();

        if(name.isEmpty()||email.isEmpty()||pass.isEmpty()||mobile.isEmpty())
        {
            Toast.makeText(this,"please enter all details",Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(pass.equals(cpass))
                result=true;

            else
            {
                Toast.makeText(this,"confirm password is wrong",Toast.LENGTH_SHORT).show();
            }


        }
        return  result;
    }




}
