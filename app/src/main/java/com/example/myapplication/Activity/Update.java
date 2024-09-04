package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.database.Mydatabase;
import com.google.android.material.textfield.TextInputEditText;

public class Update extends AppCompatActivity {

    Button save,cancel;
    TextInputEditText oldname,oldnumber,em,area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        oldname=findViewById(R.id.newname);
        oldnumber=findViewById(R.id.newnumber);
        save=findViewById(R.id.sav);

        String updatename = getIntent().getStringExtra("name");
        String updatenumber = getIntent().getStringExtra("num");
        int cid = getIntent().getIntExtra("cid",50);

        oldname.setText(updatename);
        oldnumber.setText(updatenumber);



        int userid = getIntent().getIntExtra("uid",20);
//        Mydatabase dp = new Mydatabase(Update.this);
//        dp.editdata(oldname.getText().toString(),oldnumber.getText().toString(),cid);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Mydatabase dp = new Mydatabase(Update.this);
                dp.editdata(oldname.getText().toString(),oldnumber.getText().toString(),cid);


                startActivity(new Intent(Update.this,Mainpage.class)
                        .putExtra("userid",userid));
                finish();

            }
        });



    }
}