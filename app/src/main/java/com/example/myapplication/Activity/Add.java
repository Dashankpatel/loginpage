package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.Mydatabase;
import com.google.android.material.textfield.TextInputEditText;

public class Add extends AppCompatActivity {

    Button save,cancel;
    TextInputEditText name,number,em,adde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        em=findViewById(R.id.em);
        adde=findViewById(R.id.adde);
        save=findViewById(R.id.save);
        cancel=findViewById(R.id.cancel);

        int userid = getIntent().getIntExtra("userid",20);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Mydatabase dp = new Mydatabase(Add.this);

                if (dp.addcontact(userid,name.getText().toString(),number.getText().toString(),em.getText().toString(),adde.getText().toString()))
                {
                    startActivity(new Intent(Add.this,Mainpage.class).putExtra("userid",userid));
                    finish();
                }

            }
        });

    }
}