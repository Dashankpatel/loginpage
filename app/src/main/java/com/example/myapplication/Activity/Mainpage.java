package com.example.myapplication.Activity;

import android.content.Intent;
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

    TextView name,mail,passw;
    FloatingActionButton add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        Mydatabase dp = new Mydatabase(Mainpage.this);

        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        passw = findViewById(R.id.passw);
        add = findViewById(R.id.add);

        name.setText(getIntent().getStringExtra("name"));
        mail.setText(getIntent().getStringExtra("email"));
        passw.setText(getIntent().getStringExtra("passw"));


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Mainpage.this, Add.class));
                finish();

            }
        });


    }
}