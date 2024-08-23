package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
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

    //    TextView name;
    ListView list;
    FloatingActionButton add,back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

        Mydatabase dp = new Mydatabase(Mainpage.this);

        add = findViewById(R.id.add);
        list = findViewById(R.id.list);
        back = findViewById(R.id.back);

        int userid = getIntent().getIntExtra("userid", 10);


        list.setAdapter(new MyAdapter(this, userid));


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Mainpage.this, Add.class).putExtra("userid", userid));
                finish();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SplaceScreen.edit.putBoolean("status",false);
                SplaceScreen.edit.apply();

                startActivity(new Intent(Mainpage.this, Signin.class));
                finish();

            }
        });


    }
}