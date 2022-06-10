package com.example.petcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class viewAllPets extends AppCompatActivity {

    RecyclerView recyclerView;
    //FloatingActionButton add_button;
    DBHandler myDB;
    ArrayList<String> pet_id, pet_name, pet_Address;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_pets);

        recyclerView = findViewById(R.id.recyclerView);
        //add_button = findViewById(R.id.add_button);

        myDB = new DBHandler(viewAllPets.this);
        pet_id = new ArrayList<>();
        pet_name= new ArrayList<>();
        pet_Address= new ArrayList<>();
        //book_pages = new ArrayList<>();

        storeDataInArrays();

        customAdapter = new CustomAdapter(viewAllPets.this,pet_id, pet_name, pet_Address);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(viewAllPets.this));
    }

    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
        else {
            while(cursor.moveToNext()){
                pet_id.add(cursor.getString(0));
                pet_name.add(cursor.getString(1));
                pet_Address.add(cursor.getString(2));
                //book_pages.add(cursor.getString(3));

            }
        }
    }
}