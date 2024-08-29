package com.example.myapplication.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
                    if (!numberInput.matches("\\d{10}")) {
                        number.setError("Please enter a valid number");
                        return;
                    }
                }
                else
                {
                    number.setError("Please enter a Phone number");
                    return;
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
    }
}



//save.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//
//        String numberInput = number.getText().toString();
//        String emailInput = em.getText().toString();
//
//        // Validate that the numberInput contains only digits
//        if (!numberInput.matches("\\d+")) {
//            number.setError("Please enter a valid number");
//            return;
//        }
//
//        // Validate that the emailInput is a valid email address
//        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
//            em.setError("Please enter a valid email address");
//            return;
//        }
//
//        Mydatabase dp = new Mydatabase(Add.this);
//        Boolean t = dp.addcontact(userid, name.getText().toString(), numberInput, emailInput, area.getText().toString());
//        Log.d("llllllllllllllll", "onClick: " + t);
//
//        if (t) {
//            startActivity(new Intent(Add.this, Mainpage.class).putExtra("userid", userid));
//            finish();
//        }
//    }
//});
