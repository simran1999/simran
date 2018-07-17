package com.example.jaswinder.notes_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText notes,title;
    Button delete,update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        notes=findViewById(R.id.editText4);
        title=findViewById(R.id.editText3);
        delete=findViewById(R.id.button5);
        update=findViewById(R.id.button3);
        Intent intent = getIntent();
     if(intent.getStringExtra("title") != null){
            String str = intent.getStringExtra("title");

            String[] arr = str.split("\n", 3);

            title.setText(arr[0]);
            notes.setText(arr[1]);
        }


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main2Activity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want delete this?");

                // Setting Icon to Dialog
                alertDialog.setIcon(R.drawable.ic_launcher_background);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        // Write your code here to invoke YES event
                        Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                        DBclass dBclass=new DBclass(Main2Activity.this);
                dBclass.onDelete(title.getText().toString());
                Toast.makeText(getApplicationContext(),"Deleted",Toast.LENGTH_LONG).show();
                Intent in=new Intent(Main2Activity.this,Notes.class);
                startActivity(in);
                finish();
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(Main2Activity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Update...");

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want Update this?");

                // Setting Icon to Dialog
                alertDialog.setIcon(R.drawable.ic_launcher_background);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        // Write your code here to invoke YES event
                        Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_SHORT).show();
                        DBclass dbClass = new DBclass(Main2Activity.this);
                dbClass.onUpdate(title.getText().toString(),notes.getText().toString());
                Intent intent1=new Intent(Main2Activity.this,Notes.class);
                startActivity(intent1);
                finish();
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();


            }
        });




    }
}
