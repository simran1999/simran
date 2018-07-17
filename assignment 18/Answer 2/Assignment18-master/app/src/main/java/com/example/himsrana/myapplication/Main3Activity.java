package com.example.himsrana.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    TextView name,email,password,phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Database",0);

        name.setText(sharedPreferences.getString("Name",null));
        email.setText(sharedPreferences.getString("Email",""));
        password.setText(sharedPreferences.getString("Password",""));
        phone.setText(sharedPreferences.getString("Phone",""));



    }
}
