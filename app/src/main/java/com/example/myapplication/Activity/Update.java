package com.example.myapplication.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.database.Mydatabase;
import com.google.android.material.textfield.TextInputEditText;

public class Update extends AppCompatActivity {

    // contact data edit - delete karva

    Button save,out,delete;
    TextInputEditText oldname,oldnumber,em,area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        oldname=findViewById(R.id.newname);
        oldnumber=findViewById(R.id.newnumber);
        save=findViewById(R.id.sav);
        out=findViewById(R.id.out);
        delete=findViewById(R.id.delete);

        // data edit karva
        String updatename = getIntent().getStringExtra("name");
        String updatenumber = getIntent().getStringExtra("num");
        int cid = getIntent().getIntExtra("cid",50);

        oldname.setText(updatename);
        oldnumber.setText(updatenumber);

        int userid = getIntent().getIntExtra("userid",20);

        // edit data save karva
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

        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Update.this,Mainpage.class)
                        .putExtra("userid",userid));
                finish();

            }
        });

        // data delete karva
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // dialogue box open karva
                    Dialog dialog = new Dialog(Update.this);
                    dialog.setContentView(R.layout.dialogview_delete);
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.show();

                    TextView tex1 = dialog.findViewById(R.id.tex1);
                    Button yes1 = dialog.findViewById(R.id.yes1);
                    Button no1 = dialog.findViewById(R.id.no1);

                    tex1.getText();

                    yes1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v)
                        {
                            Mydatabase dp = new Mydatabase(Update.this);
                            dp.deletdata(cid);

                            startActivity(new Intent(Update.this,Mainpage.class)
                                    .putExtra("userid",userid));
                            finish();
                        }
                    });

                    no1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
            }
        });

    }

}