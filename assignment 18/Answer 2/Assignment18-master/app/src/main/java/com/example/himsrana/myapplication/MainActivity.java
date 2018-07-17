package com.example.himsrana.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,phone,email,password;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pwd);

        signup = findViewById(R.id.signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Database",0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("Name",name.getText().toString());
                editor.putString("Phone",phone.getText().toString());
                editor.putString("Email",email.getText().toString());
                editor.putString("Password",password.getText().toString());
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "SignedUP", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
