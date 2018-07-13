package com.example.jaswinder.toastlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast toast=Toast.makeText(this,"inside oncreate",Toast.LENGTH_LONG);
        toast.show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        Toast toast=Toast.makeText(this,"inside onstart",Toast.LENGTH_LONG);
        super.onStart();

    }

    @Override
    protected void onPause() {
        Toast toast=Toast.makeText(this,"inside onpause",Toast.LENGTH_LONG);
        super.onPause();

    }

    @Override
    protected void onResume() {
        Toast toast=Toast.makeText(this,"inside onresume",Toast.LENGTH_LONG);
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "inside ondestory", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

}
