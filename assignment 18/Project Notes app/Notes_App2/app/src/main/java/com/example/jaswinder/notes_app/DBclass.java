package com.example.jaswinder.notes_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBclass extends SQLiteOpenHelper {
    public DBclass(Context context) {
        super(context, "user", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE USER (Title Text,Date Text,Time Text,Notes Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USER");
        onCreate(sqLiteDatabase);
    }


    void addData(String title, String notes,String date,String time) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("Title", title);
        contentValues.put("Notes", notes);
contentValues.put("Date",date);
contentValues.put("Time",time);
        sqLiteDatabase.insert("user", null, contentValues);
    }

    Cursor getData() { //showData()

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        //SELECT * FROM TABLE
        Cursor cursor = sqLiteDatabase.query("user", null, null, null, null, null, null);

        return cursor;

    }

    void onDelete(String title) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String arr[] = {title};
        sqLiteDatabase.delete("user", "Title = ?", arr);
    }


    void onUpdate(String title, String notes) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Title", title);
        contentValues.put("Notes", notes);
        String arr[] = {title};

        sqLiteDatabase.update("user", contentValues, "Title = ? ", arr);

    }
}