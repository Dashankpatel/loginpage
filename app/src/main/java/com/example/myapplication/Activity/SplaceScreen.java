package com.example.myapplication.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;

public class SplaceScreen extends AppCompatActivity {

    // app open thay tyare koi fix app design logo aave aena mate

    static SharedPreferences sp;
    static SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splace_screen);

        sp = getSharedPreferences("myshare",MODE_PRIVATE);
        edit = sp.edit();

        // user 1st time id-password create kari login karava mate
        Boolean userstatus = sp.getBoolean("status",false);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               // user login 6e ke nathi ae check karva
                if (userstatus){
                    startActivity(new Intent(SplaceScreen.this,Mainpage.class).
                            putExtra("userid",sp.getInt("uid",0)));
                    finish();
                }
                else
                {
                    startActivity(new Intent(SplaceScreen.this,Signin.class));
                    finish();
                }
            }
        }
        // ketla milli second delay karavu 6e ae mate
        , 2000);



    }
}