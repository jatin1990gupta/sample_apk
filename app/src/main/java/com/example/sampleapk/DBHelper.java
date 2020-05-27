package com.example.sampleapk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Currency;

public class DBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "details.db";

    public static String TABLE_NAME = "data";
    public static String col1 = "NAME";
    public static String col2 = "CONTACT";
    public static String col3 = "EMAIL";


    public DBHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String create_table = "CREATE TABLE " + TABLE_NAME + "( " +
                col1 + " TEXT, " + col2 + " TEXT, " + col3 + " TEXT)";
        db.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean add_data(String name, String contact, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1, name);
        cv.put(col2, contact);
        cv.put(col3, email);

        long result = db.insert(TABLE_NAME, null, cv);
        return result!=-1;
    }

    public ArrayList<data> getListContents(){
        ArrayList<data> datalist = new ArrayList<data>();
        SQLiteDatabase db = this.getReadableDatabase();
        try{
            Cursor c = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);
            c.moveToLast();
            do{
                String name = c.getString(c.getColumnIndex(col1));
                String contact = c.getString(c.getColumnIndex(col2));
                String email = c.getString(c.getColumnIndex(col3));

                data dts = new data(name, contact, email);
                datalist.add(dts);
            } while (c.moveToPrevious());
        } catch (Exception ee){
            Log.e("No records Found",ee.toString());
        }
        return datalist;
    }
}
