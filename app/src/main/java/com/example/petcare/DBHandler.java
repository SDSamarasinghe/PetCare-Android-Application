package com.example.petcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Pets.Pet.TABLE_NAME + " (" +
                    Pets.Pet._ID + " INTEGER PRIMARY KEY," +
                    Pets.Pet.COLUMN_1 + " TEXT," +
                    Pets.Pet.COLUMN_2 + " TEXT," +
                    Pets.Pet.COLUMN_3 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Pets.Pet.TABLE_NAME;

    public Long addPetInfo(String petname, String password, String address){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Pets.Pet.COLUMN_1, petname);
        values.put(Pets.Pet.COLUMN_2, password);
        values.put(Pets.Pet.COLUMN_3, address);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Pets.Pet.TABLE_NAME, null, values);

        return newRowId;

    }

    public Boolean deletePetInfo(String petName){
        // Define 'where' part of query.

        SQLiteDatabase db = getWritableDatabase();

        String selection = Pets.Pet.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { petName };
        // Issue SQL statement.
        int deletedRows = db.delete(Pets.Pet.TABLE_NAME, selection, selectionArgs);

        if (deletedRows>0){
            return true;
        }
        else {
            return false;
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + Pets.Pet.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}


