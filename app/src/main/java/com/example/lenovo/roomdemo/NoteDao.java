package com.example.lenovo.roomdemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by lenovo on 21-07-2017.
 */

@Dao
public interface NoteDao {

    @Query("SELECT * FROM notes")
    List<Note> getAllNotes();

    @Query("SELECT * FROM notes WHERE title = :title AND description =:desc")
    List<Note> getAllNotesWithName(String title,String desc);

  @Insert
    void insertNote(Note note);
}
