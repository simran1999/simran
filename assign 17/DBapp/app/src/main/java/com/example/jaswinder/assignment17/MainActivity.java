package com.example.jaswinder.assignment17;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText Name,Pwd,email,roll;
Button Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Name=findViewById(R.id.editText);
        Pwd=findViewById(R.id.editText2);
        Submit=findViewById(R.id.button);
        roll=findViewById(R.id.editText4);
        email=findViewById(R.id.editText3);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getApplicationContext().getSharedPreferences("My_Prefs",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("Name",Name.getText().toString());
                editor.putString("Pwd",Pwd.getText().toString());
                editor.putString("email",email.getText().toString());
                editor.putString("roll",roll.getText().toString());
                editor.commit();
                Intent intent=new Intent(MainActivity.this,Login_page.class);
                startActivity(intent);
            }
        });
    }
}
