package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.Mydatabase;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Signup extends AppCompatActivity {

    TextView account;
    Button createuser;
    TextInputEditText user,email,pass1,pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        account = findViewById(R.id.account);
        createuser = findViewById(R.id.createuser);
        user = findViewById(R.id.user);
        email = findViewById(R.id.email);
        pass1 = findViewById(R.id.pass1);
        pass2 = findViewById(R.id.pass2);


        Mydatabase dp = new Mydatabase(Signup.this);

        createuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if (pass1.getText().toString()==pass2.getText().toString())
//                {
                    Boolean d = dp.insertdata(user.getText().toString(), email.getText().toString(), pass1.getText().toString());

                    if (d==true)
                    {
                        startActivity(new Intent(Signup.this,Signin.class));
                        finish();
                    }


                }

//            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Signup.this,Signin.class));
                finish();


            }
        });




    }
}