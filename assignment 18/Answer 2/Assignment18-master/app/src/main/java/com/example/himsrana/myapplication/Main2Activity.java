package com.example.himsrana.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText mail,pwd;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mail = findViewById(R.id.email);
        pwd = findViewById(R.id.pwd);

        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Database",0);
                String name_login = sharedPreferences.getString("Email","");
                String pwd_login = sharedPreferences.getString("Password","");

                if((mail.getText().toString().equals(name_login))&&(pwd.getText().toString().equals(pwd_login))) {
                    Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(),"Logged In",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(Main2Activity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
