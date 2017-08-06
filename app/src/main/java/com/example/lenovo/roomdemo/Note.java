package com.example.lenovo.roomdemo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;

/**
 * Created by lenovo on 20-07-2017.
 */

@Entity(tableName = "notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;
    private String description;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Note(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Note(String title,String desc){
        this.title=title;
        this.description=desc;
    }
    public static ArrayList<Note> getRandomNotes(int noOfNotes){
        ArrayList<Note> notes=new ArrayList<>();
        for(int i=0;i<noOfNotes;i++){
            Note note=new Note("Title "+i,"Description "+i);
            notes.add(note);
        }
        return notes;
    }
}
