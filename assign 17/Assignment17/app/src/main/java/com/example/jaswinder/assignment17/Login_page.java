package com.example.jaswinder.assignment17;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login_page extends AppCompatActivity {
TextView email,password;
EditText ed1,ed2;
Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        email=findViewById(R.id.textView5);
        password=findViewById(R.id.textView6);
        ed1=findViewById(R.id.editText5);
        ed2=findViewById(R.id.editText6);
        submit=findViewById(R.id.button2);
        SharedPreferences sp=getApplicationContext().getSharedPreferences("My_Prefs",0);
       final String pwd_f=sp.getString("Pwd","");
        final String email_f=sp.getString("email","");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email_f.equals(ed1.getText().toString())&&pwd_f.equals(ed2.getText().toString())){
                    Intent intent=new Intent(Login_page.this,Main2Activity.class);
                    startActivity(intent);
                    Toast.makeText(Login_page.this,"you enter correct",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(Login_page.this,"not correct",Toast.LENGTH_LONG).show();;
                }
            }
        });

    }
}
