package com.example.myapplication.Activity;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.database.Mydatabase;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<String> namelist = new ArrayList<>();
    ArrayList<String> numlist = new ArrayList<>();
    Context context;

    MyAdapter(Context context, int uid) {
        this.context = context;

        Mydatabase db = new Mydatabase(context);
        Cursor cr = db.selectcon(uid);

        while (cr.moveToNext()) {
            namelist.add(cr.getString(2));
            numlist.add(cr.getString(3));
        }
    }

    @Override
    public int getCount() {
        return namelist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View vv = LayoutInflater.from(context).inflate(R.layout.myview, parent, false);

        TextView name = vv.findViewById(R.id.sname), num = vv.findViewById(R.id.snum);

        name.setText(namelist.get(position));
        num.setText(numlist.get(position));

        return vv;
    }
}
