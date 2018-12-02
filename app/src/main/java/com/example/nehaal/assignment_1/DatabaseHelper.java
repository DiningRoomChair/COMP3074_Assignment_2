package com.example.nehaal.assignment_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLInput;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_TABLE = "Speakers_Table";

    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String AFFILIATION = "AFFILIATION";
    private static final String EMAIL = "EMAIL";
    private static final String BIO = "BIO";

    private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE+ " ("+
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT, " +
            AFFILIATION + " TEXT, " +
            EMAIL + " TEXT, " +
            BIO + " TEXT "+ ")";

    public DatabaseHelper(Context context){
        super(context, DB_TABLE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
        onCreate(db);
    }

    public boolean insertData(String name, String affiliation, String email, String bio){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(AFFILIATION, affiliation);
        contentValues.put(EMAIL, email);
        contentValues.put(BIO, bio);

        long result = db.insert(DB_TABLE, null, contentValues);

        //returns id of new inserted row, or -1 if error
        return result != -1;
    }

    //method to view data
    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from " +  DB_TABLE;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }
}
