package com.example.petcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class petRegistration extends AppCompatActivity {

    EditText Petname, Password, Address;
    Button AddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_reg);

        Petname = findViewById(R.id.petnameR);
        Password = findViewById(R.id.passwordR);
        Address = findViewById(R.id.addressR);
        AddBtn = findViewById(R.id.addbtnR);

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());

                long input = dbHandler.addPetInfo(Petname.getText().toString(),Password.getText().toString(),Address.getText().toString());

                if (input>0){
                    Toast.makeText(petRegistration.this, "Successfully inserted", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(getApplicationContext(),viewAllPets.class);
                    startActivity(i);
                }else{
                    Toast.makeText(petRegistration.this, "Invalid", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}