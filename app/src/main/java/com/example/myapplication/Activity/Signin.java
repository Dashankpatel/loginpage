package com.example.myapplication.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.Mydatabase;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Signin extends AppCompatActivity {

    Button login;
    TextView create;
    TextInputEditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        create= findViewById(R.id.create);
        login = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password= findViewById(R.id.password);


        Mydatabase dp = new Mydatabase(Signin.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor data = dp.userlogin(username.getText().toString(), password.getText().toString());

                while (data.moveToNext()) {
                    Log.d("++ds--", "onClick: userid ==>" + data.getString(0));
                    Log.d("++ds--", "onClick: name ==>" + data.getString(1));
                    Log.d("++ds--", "onClick: email ==>" + data.getString(2));
                    Log.d("++ds--", "onClick: pass ==>" + data.getString(3));

                    startActivity(new Intent(Signin.this, Mainpage.class).
                            putExtra("userid",data.getString(0)).
                            putExtra("name",data.getString(1)));
                    finish();


                }

            }
        });


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Signin.this,Signup.class));
                finish();

            }
        });



    }
}