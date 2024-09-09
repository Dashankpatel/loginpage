package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.Mydatabase;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Signup extends AppCompatActivity {

    TextView account;
    Button createuser;
    TextInputEditText user, email, pass1, pass2;

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

        // new user create karva
        createuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password1 = pass1.getText().toString();
                String password2 = pass2.getText().toString();

                //  email address check karava
                String emailInput = email.getText().toString();
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                    email.setError("Please enter a valid email address");
                    return;
                }

                // password 1 & 2 same 6e te check karva
                if (password1.equals(password2)) {
                    Boolean d = dp.insertdata(user.getText().toString(), emailInput, password1);

                    if (d == true) {
                        startActivity(new Intent(Signup.this, Signin.class));
                        Toast.makeText(Signup.this, "Account created", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
                else {
                    Toast.makeText(Signup.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }

        });

        // login account hoy to login page ma back aavavaa
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Signup.this, Signin.class));
                finish();


            }
        });


    }
}