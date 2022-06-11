package com.example.spinnertest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

public class viewAll extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all);

        DBHandler dbHandler = new DBHandler(getApplicationContext());

        Cursor res = dbHandler.readAllData();

        if(res.getCount() == 0){
            Toast.makeText(viewAll.this, "No entry exists", Toast.LENGTH_SHORT).show();
        }

        StringBuffer buffer = new StringBuffer();

        while (res.moveToNext()){
            buffer.append("Username :"+res.getString(0)+"\n");
            buffer.append("Password :"+res.getString(1)+"\n");
            buffer.append("Availability :"+res.getString(2)+"\n");
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(viewAll.this);
        builder.setCancelable(true);
        builder.setTitle("User Entries");
        builder.setMessage(buffer.toString());
        builder.show();

    }
}