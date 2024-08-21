package com.example.myapplication.database;

import android.content.Context;
import android.database.Cursor;
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

        // login username , email , password
        String table = "CREATE TABLE user(username text , email text , password text)";
        db.execSQL(table);

        // add contact name, number, email, address
        String contact = "CREATE TABLE contact(id integer primary key autoincrement , userid integer , name text , number text , email text , area text)";
        db.execSQL(contact);

    }

    // login username , email , password return & save
    public Boolean insertdata(String username , String email , String password)
    {
        try{
            String insert = "INSERT INTO user (username , email , password) VALUES ('"+username+"','"+email+"','"+password+"')";
            getWritableDatabase().execSQL(insert);

            return true;
        }
        catch (Exception e)
        {
            Log.d("++ex++", "insertdata: "+e);
            return false;
        }
    }

    // add contact name, number, email, address return & save
    public  Boolean addcontact(int userid, String name, String number, String email, String area)
    {
        try {
            String insert = "INSERT INTO contact (userid , name , number , email , area) VALUES ("+userid+" , '"+name+"' , '"+number+"' , '"+email+"' ,'"+area+"')";
            getWritableDatabase().execSQL(insert);
            return true;
        }catch (Exception exception)
        {
            Log.d("--fdf-*-","addcontact"+exception);
            return false;
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    // user login username , password OK check karava
    public Cursor userlogin(String user, String pass) {

        String select = "SELECT * FROM user WHERE username = '"+user+"' AND password = '"+pass+"'  ";

        Cursor cr = getReadableDatabase().rawQuery(select,null);

        return cr;
    }
}
