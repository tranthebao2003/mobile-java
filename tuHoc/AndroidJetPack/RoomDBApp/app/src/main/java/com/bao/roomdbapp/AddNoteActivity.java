package com.bao.roomdbapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.bao.roomdbapp.notedb.Note;
import com.bao.roomdbapp.notedb.NoteDatabase;
import com.google.android.material.textfield.TextInputEditText;

import java.lang.ref.WeakReference;

public class AddNoteActivity extends AppCompatActivity {
//    variables
    private TextInputEditText et_title, et_content;
    private boolean update;
    private Button button;

//    object:
    private NoteDatabase noteDatabase;
    private Note note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

//        widgets:
        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);

        button = findViewById(R.id.but_save);

//        objects: tao 1 instance của database
        noteDatabase = NoteDatabase.getInstance(AddNoteActivity.this);

//        check for correct object and data:
//        check intent co du lieu chua, neu co roi thi update
//        getSerializableExtra la để nhận kiểu tuần tự đã note về
//        phần Note.java
        if((note = (Note) getIntent().getSerializableExtra("note")) != null){
            getSupportActionBar().setTitle("Update Note");
            update = true;
            button.setText("Update");
            et_title.setText(note.getTitle());
            et_content.setText(note.getContent());
        }
//        handling button click events
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if we need to update the note:
                if(update){
                    note.setContent(et_content.getText().toString());
                    note.setTitle(et_title.getText().toString());
                    noteDatabase.getNoteDao().updateNote(note);
                    setResult(note, 2);

//                    create a new note
                } else{
                    note = new Note(et_content.getText().toString(),
                            et_title.getText().toString());
                    new InsertTask(AddNoteActivity.this, note).execute();
                }
            }
        });
    }

//    set Results method:
//    Phương thức setResult(Note note, int flag) được sử dụng để trả về kết quả t
//    ừ AddNoteActivity sang Activity gọi nó (chẳng hạn như MainActivity)
    private void setResult(Note note, int flag){
        setResult(flag, new Intent().putExtra("note", note));
        finish();
    }

//    Insert task:
    private static class InsertTask extends AsyncTask<Void, Void, Boolean>{
        private WeakReference<AddNoteActivity> activityWeakReference;
        private Note note;

//        only retain a weak reference to the activity:
        InsertTask(AddNoteActivity context, Note note){
            activityWeakReference = new WeakReference<>(context);
            this.note = note;
        }

//        do in background methods runs on a worker thread

        @Override
        protected Boolean doInBackground(Void... voids) {
//      retrieving auto incremented note id

            long j = activityWeakReference.get().noteDatabase.getNoteDao().insertNote(note);
            note.setNote_id(j);

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(aBoolean){
                activityWeakReference.get().setResult(note, 1);
                activityWeakReference.get().finish();
            }
        }
    }
}