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
    ImageView pop;
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
        pop=findViewById(R.id.pop);

        int userid = getIntent().getIntExtra("userid",20);

        Dialog dialog = new Dialog(Add.this);

        dialog.setContentView(R.layout.exit);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        TextView tex = dialog.findViewById(R.id.tex);
        Button yes = dialog.findViewById(R.id.yes);
        Button no = dialog.findViewById(R.id.no);

        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu pmenu = new PopupMenu(Add.this,pop);

                pmenu.inflate(R.menu.mymenu);
                pmenu.show();
                pmenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getItemId()==R.id.logout)
                        {
                            tex.getText();
                            yes.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    SplaceScreen.edit.putBoolean("status",false);
                                    SplaceScreen.edit.apply();

                                    startActivity(new Intent(Add.this, Signin.class));
                                    finish();
                                }
                            });
                            no.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                        }
                        else if (item.getItemId()==R.id.setting)
                        {
                            Toast.makeText(Add.this, "setting", Toast.LENGTH_SHORT).show();


                        }


                        return false;
                    }
                });


            }
        });


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
