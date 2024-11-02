package com.bao.roomdbapp.notedb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Note.class}, version = 1)
@TypeConverters({DataRoomConverter.class})
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NoteDao getNoteDao();
    private static NoteDatabase noteDB;

//    synchronized
    public static NoteDatabase getInstance(Context context){
        if(noteDB == null){
            noteDB = buildDatabaseInstance(context);
        }
        return noteDB;
    }

    private static NoteDatabase buildDatabaseInstance(Context context){
        return Room.databaseBuilder(context, NoteDatabase.class, Constants.DB_NAME).
                allowMainThreadQueries().build();
    }

    public void cleanUp(){
        noteDB = null;
    }
}
