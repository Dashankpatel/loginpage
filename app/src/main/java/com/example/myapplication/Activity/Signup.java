package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.Mydatabase;

public class Signup extends AppCompatActivity {

    TextView account;
    Button createuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        account = findViewById(R.id.account);
        createuser = findViewById(R.id.createuser);

        Mydatabase dp = new Mydatabase(Signup.this);

        createuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dp.insertdata("dashank","dashank#1101","dashank1101");

            }
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