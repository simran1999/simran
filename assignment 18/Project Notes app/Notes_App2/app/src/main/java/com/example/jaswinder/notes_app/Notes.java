package com.example.jaswinder.notes_app;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Notes extends AppCompatActivity {
    ListView listView;
    TextView textView;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        listView = findViewById(R.id.list);
        add = findViewById(R.id.button4);


        ArrayList<String> arrayList = new ArrayList<String>();
        DBclass dBclass = new DBclass(this);
        Cursor cursor = dBclass.getData();


//        ArrayList<String> arrayList = new ArrayList<String>();
//
//        DBClass dbClass = new DBClass(this);
//        Cursor cursor= dbClass.getData();

        if (cursor.moveToFirst()) {

            do {
                //cursor , display the data of that row
                String title = cursor.getString(cursor.getColumnIndex("Title"));
                String notes = cursor.getString(cursor.getColumnIndex("Notes"));
                String date = cursor.getString(cursor.getColumnIndex("Date"));
                String time = cursor.getString(cursor.getColumnIndex("Time"));

                arrayList.add(title +"\n"+ notes +"\n"+date+" "+time);

                //cursor , increment to next row
            } while (cursor.moveToNext());

        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Notes.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(Notes.this, Main2Activity.class);
                intent.putExtra("title", selected);
                startActivity(intent);
                finish();

            }
        });
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            // Get the selected item text from ListView
//            String selectedItem = (String) parent.getItemAtPosition(position);
//
//            // Display the selected item text on TextView
//            tv.setText("Your favorite : " + selectedItem);
//        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i,
//                                    long l) {
//                String filename = ((Note)ls.getItemAtPosition(i)).getmDateTime()
//                        + Utilities.FILE_EXTENSION;

//                Intent viewNoteIntent = new Intent(getApplicationContext(),
//                        NoteActivity.class);
//                viewNoteIntent.putExtra(Utilities.EXTRAS_NOTE_FILENAME, filename);
//                startActivity(viewNoteIntent)
//            }
//        });
//

    }
}
