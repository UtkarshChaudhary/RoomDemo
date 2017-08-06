package com.example.lenovo.roomdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by lenovo on 21-07-2017.
 */

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    public static final String DB_NAME = "notes_db";
private static NoteDatabase INSTANCE;
    private static Object LOCK=new Object();

    public static NoteDatabase getInstance(Context context){
        if(INSTANCE==null){
            synchronized (LOCK){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext()
                    ,NoteDatabase.class,NoteDatabase.DB_NAME).build();
                }
            }
        }
        return INSTANCE;
    }

    abstract NoteDao noteDao();
}
