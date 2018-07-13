package com.example.jaswinder.assignment17;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
TextView name,password,email,roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=findViewById(R.id.textView2);
        password=findViewById(R.id.textView3);
        email=findViewById(R.id.textView);
        roll=findViewById(R.id.textView4);
        SharedPreferences sp=getApplicationContext().getSharedPreferences("My_Prefs",MODE_PRIVATE);
        String name_f=sp.getString("Name","");
        String pwd_f=sp.getString("Pwd","");
        String email_f=sp.getString("email","");
        String roll_f=sp.getString("roll","");

        name.setText(name_f);
        password.setText(pwd_f);
        roll.setText(roll_f);
        email.setText(email_f);

    }
}
