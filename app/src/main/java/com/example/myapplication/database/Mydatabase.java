package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Mydatabase extends SQLiteOpenHelper {


    public Mydatabase(Context context)
    {
        super(context,"mydata.db",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//        String table = "CREATE TABLE user(username text unique , email text , password text)";
        String table = "CREATE TABLE user(username text , email text , password text)";
        db.execSQL(table);

    }

    public void insertdata(String username,String email , String password)
    {
        try{
            String insert = "INSERT INTO user (username , email , password) VALUES ('"+username+"','"+email+"','"+password+"')";
            getWritableDatabase().execSQL(insert);
        }
        catch (Exception e)
        {
            Log.d("++ex++", "insertdata: "+e);
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
