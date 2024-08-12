package com.example.myapplication.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.database.Mydatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Mainpage extends AppCompatActivity {

    TextView name;
    FloatingActionButton add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        Mydatabase dp = new Mydatabase(Mainpage.this);

        name = findViewById(R.id.name);
        add = findViewById(R.id.add);

        name.setText(getIntent().getStringExtra("name"));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}