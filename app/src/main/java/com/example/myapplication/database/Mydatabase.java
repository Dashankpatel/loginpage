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
        String table = "CREATE TABLE user(username text , email text , password text)";
        db.execSQL(table);

        String contact = "CREATE TABLE contact(id integer primary key autoincrement , userid integer , name text , number text , email text , addres text)";
        db.execSQL(contact);

    }

    public  Boolean addcontact(int userid, String name, String number, String email, String address)
    {
        try {
            String insrt = "INSERT INTO contact (userid , name , number , email , address) VALUES ("+userid+" , '"+name+"' , '"+number+"' , '"+email+"' ,'"+address+"')";
            getWritableDatabase().execSQL(insrt);
            return true;
        }catch (Exception exception)
        {
            return false;
        }
    }


    public Boolean insertdata(String username,String email , String password)
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


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Cursor userlogin(String user, String pass) {

        String select = "SELECT * FROM user WHERE username = '"+user+"' AND password = '"+pass+"'  ";

        Cursor cr = getReadableDatabase().rawQuery(select,null);

        return cr;
    }
}
