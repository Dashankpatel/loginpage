package com.example.myapplication.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputEditText;

public class Add extends AppCompatActivity {

    TextInputEditText user,phone,messa,grp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        user=findViewById(R.id.user);
        phone=findViewById(R.id.phone);
        messa=findViewById(R.id.messa);
        grp=findViewById(R.id.grp);


    }
}