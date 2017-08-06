package com.example.lenovo.roomdemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by lenovo on 21-07-2017.
 */

public class AddNote extends AppCompatActivity{

    private EditText mTitleEditText;
    private EditText mDescEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        mTitleEditText=(EditText)findViewById(R.id.titleEditText);
        mDescEditText=(EditText)findViewById(R.id.descEditText);
    }
public void addNote(View view){
    final Note note=new Note(mTitleEditText.getEditableText().toString(),
            mDescEditText.getEditableText().toString());
    NoteDatabase db=NoteDatabase.getInstance(this);
    final NoteDao dao=db.noteDao();

    new AsyncTask<Void, Void, Void>() {

       //doInBackground works on background thread
        @Override
        protected Void doInBackground(Void... params) {
          dao.insertNote(note);
            return null;
           }

        @Override
        protected void onPostExecute(Void aVoid) {
            Intent result=new Intent();
            result.putExtra("title",note.getTitle());
            result.putExtra("desc",note.getDescription());
            setResult(RESULT_OK,result);
            AddNote.this.finish();
        }
    }.execute();

}

}
