package com.example.jaswinder.notes_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
EditText title,note;
Button save,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title=findViewById(R.id.editText);
        note=findViewById(R.id.editText2);
        save=findViewById(R.id.button);

        final DBclass dbClass = new DBclass(this);
        SimpleDateFormat dateF = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
        SimpleDateFormat timeF = new SimpleDateFormat("HH:mm", Locale.getDefault());
      final   String date = dateF.format(Calendar.getInstance().getTime());
      final   String time = timeF.format(Calendar.getInstance().getTime());



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( TextUtils.isEmpty(title.getText())){
                    Toast.makeText(getApplicationContext(), "Cannot leave blank", Toast.LENGTH_LONG).show();

                    title.setError( "Field is required!" );

                }
                else {
                    dbClass.addData(title.getText().toString(), note.getText().toString(), date, time);
                    Toast.makeText(getApplicationContext(), "notes is saved", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, Notes.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

//        Intent intent = getIntent();
//        if(intent.getStringExtra("title") != null){
//            String str = intent.getStringExtra("title");
//
//            String[] arr = str.split("\n", 2);
//
//            title.setText(arr[0]);
//            note.setText(arr[1]);
//        }

//
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DBclass dBclass=new DBclass(MainActivity.this);
//                dBclass.onDelete(title.getText().toString());
//                Toast.makeText(getApplicationContext(),"do you del",Toast.LENGTH_LONG).show();
//                Intent in=new Intent(MainActivity.this,Notes.class);
//                startActivity(in);
//            }
//        });










//        deletebtn = findViewById(R.id.buttondelt);
//        deletebtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DBClass dbClass = new DBClass(DeleteActivity.this);
//                dbClass.onDelete(name.getText().toString());
//            }
//        });


//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dbClass.addData(name.getText().toString(),password.getText().toString(),number.getText().toString(),type.getText().toString());
//                Toast.makeText(getApplicationContext(),"DETAILS ADDED SUCCESSFULLY  !",Toast.LENGTH_SHORT).show();
//
//                Intent intent = new Intent(RegistrationActivity.this,MainActivity.class);
//                startActivity(intent);
//            }
//        });


    }
}
