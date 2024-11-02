package com.bao.sqlliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager open() throws SQLException{
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
//      this:  trả về DBManager
        return this;
    }

    public void close(){
        dbHelper.close();
    }

//    add data
    public void insert(String name, String desc){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT, name);
        contentValues.put(DatabaseHelper.DESC, desc);
        database.insert(DatabaseHelper.TABLE_NAME, null,contentValues);
    }

//    get all data
    public Cursor fetch(){
        String[] columns = new String[]{DatabaseHelper._ID,
        DatabaseHelper.SUBJECT, DatabaseHelper.DESC};

//        tra ve toan bo record cua ca 3 cot
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME,
                columns,
                null,
                null,
                null,
                null,
                null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

//    update data by id
    public int update(long _id, String name, String desc){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.SUBJECT, name);
        contentValues.put(DatabaseHelper.DESC, desc);

        int i = database.update(DatabaseHelper.TABLE_NAME,
                contentValues, DatabaseHelper._ID + " = " + _id,
                null);
        return i;
    }

//    delete data by id
    public void delete(long _id){
        database.delete(DatabaseHelper.TABLE_NAME,
                DatabaseHelper._ID + " = " + _id,
                null);
    }

}
