package com.bao.roomdbapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bao.roomdbapp.adapters.NotesAdapter;
import com.bao.roomdbapp.notedb.Note;
import com.bao.roomdbapp.notedb.NoteDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class NoteListActivity extends AppCompatActivity implements NotesAdapter.OnNoteItemClick {

//    variables and the widgets
    private TextView textViewMsq;
    private RecyclerView recyclerView;
    private NoteDatabase noteDatabase;
    private List<Note> notes;
    private NotesAdapter notesAdapter;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("NoteList Activity");
        setContentView(R.layout.activity_main);

//        methods:
        initializeViews();
        displayList();
    }


    @Override
    public void onNoteClick(int position) {
//        alert dialog that will show to the user then FAB is clicked
//        to ask for UPDATE OR DELETE NOTES!
        this.pos = position;
        new AlertDialog.Builder(NoteListActivity.this)
                .setItems(new String[]{"Delete", "Update"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i){
                            case 0:
                                noteDatabase.getNoteDao().deleteNote(notes.get(position));
                                notes.remove(position);
                                listVisibility();
                                break;
                            case 1:
                                startActivityForResult(
                                        new Intent(NoteListActivity.this
                                                ,AddNoteActivity.class)
                                                .putExtra("note", notes.get(position)),
                                        100
                                );
                                break;
                        }
                    }
                }).show();
    }

    private void displayList(){
        noteDatabase = NoteDatabase.getInstance(NoteListActivity.this);
        new RetrieveTask(this).execute();
    }

//    tương tự như cái bên trong AddNoteActivity
    private static class RetrieveTask extends AsyncTask<Void, Void, List<Note>> {

//        NoteListActivity: chính là giao diện chính hiển thị lên cho user
        private WeakReference<NoteListActivity> activityReference;

//        the only retain weak reference to the activity
        RetrieveTask(NoteListActivity context){
            activityReference = new WeakReference<>(context);
        }

        @Override
        protected List<Note> doInBackground(Void... voids) {
            if (activityReference.get() != null){
//                trả về list các đối tượng note làm tham số đầu vào của hàm onPostExecute
                return activityReference.get().noteDatabase.getNoteDao().getNotes();
            }
            else{
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Note> notes) {
            if(notes != null && notes.size() > 0){
                activityReference.get().notes.clear();
                activityReference.get().notes.addAll(notes);

//                hide the empty textView;
                activityReference.get().textViewMsq.setVisibility(View.GONE);
                activityReference.get().notesAdapter.notifyDataSetChanged();
            }
        }
    }

//    lay du lieu tu adapter de hien thi len
    private void initializeViews() {
        textViewMsq = findViewById(R.id.tv_empty);

        FloatingActionButton fab = findViewById(R.id.fab);
//        khi click vao cai fab
        fab.setOnClickListener(listener);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(NoteListActivity.this));
        notes = new ArrayList<>();
        notesAdapter = new NotesAdapter(notes, NoteListActivity.this);
        recyclerView.setAdapter(notesAdapter);
    }

//    khi click vao fab thi sẽ kich hoat event nay
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivityForResult(new
                            Intent(NoteListActivity.this,
                            AddNoteActivity.class),
                    100);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode > 0){
            if(requestCode == 1){
                notes.add((Note) data.getSerializableExtra("note"));

            } else if(resultCode == 2){
                notes.set(pos, (Note) data.getSerializableExtra("note"));
            }
            listVisibility();
        }
    }

    private void listVisibility() {
        int emptyMsgVisibilty = View.GONE;
        if(notes.size() == 0){
            // no items to display
            if(textViewMsq.getVisibility() == View.GONE)
                emptyMsgVisibilty = View.VISIBLE;
        }
        textViewMsq.setVisibility(emptyMsgVisibilty);
        notesAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        noteDatabase.cleanUp();
        super.onDestroy();
    }
}