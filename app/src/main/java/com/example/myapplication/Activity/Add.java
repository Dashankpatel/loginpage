package com.example.myapplication.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.database.Mydatabase;
import com.google.android.material.textfield.TextInputEditText;

public class Add extends AppCompatActivity {

    Button save,cancel;
    TextInputEditText name,number,em,area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        em=findViewById(R.id.em);
        area=findViewById(R.id.area);
        save=findViewById(R.id.save);
        cancel=findViewById(R.id.cancel);

        int userid = getIntent().getIntExtra("userid",20);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Mydatabase dp = new Mydatabase(Add.this);

                String numberInput = number.getText().toString();
                // number check karava
                if (!numberInput.isEmpty())
                {
                    // number 10 digit ma j aave aena mate
                    if (numberInput.length() !=10)
                    {
                        Toast.makeText(Add.this, "Please enter a Valid number", Toast.LENGTH_SHORT).show();
                        number.setError("Please enter a valid number");
                        return;
                    }
                }

                String emailInput = em.getText().toString();
                //  email address check karava
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                        em.setError("Please enter a valid email address");
                        return;
                }

                Boolean t =dp.addcontact(userid,name.getText().toString(),numberInput, emailInput,area.getText().toString());
                Log.d("llllllllllllllll", "onClick: "+t);

                if (t)
                {
                    startActivity(new Intent(Add.this,Mainpage.class).putExtra("userid",userid));
                    finish();
                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Add.this,Mainpage.class).putExtra("userid",userid));
                finish();

            }
        });
    }
}