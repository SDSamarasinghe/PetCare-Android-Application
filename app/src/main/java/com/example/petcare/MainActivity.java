package com.example.petcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Petname, Password;
    Button loginBtn, RegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Petname = findViewById(R.id.petnameM);
        Password = findViewById(R.id.passwordM);
        loginBtn = findViewById(R.id.loginbtnM);
        RegBtn = findViewById(R.id.registerbtnM);

        RegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),petRegistration.class);
                startActivity(i);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHandler dbHandler = new DBHandler(getApplicationContext());

                if (dbHandler.loginUser(Petname.getText().toString(),Password.getText().toString())){
                    Intent i = new Intent(getApplicationContext(),viewAllPets.class);
                    startActivity(i);
                }else {
                    Toast.makeText(MainActivity.this, "Invalid pet", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}