package com.example.jaswinder.dbapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText a,b,c,d;
Button e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a=findViewById(R.id.editText);
       b=findViewById(R.id.editText2);
       c=findViewById(R.id.editText3);
       d=findViewById(R.id.editText4);
       e=findViewById(R.id.button);
       e.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(MainActivity.this,Main2Activity.class);
               startActivity(intent);
           }
       });
    }
}
