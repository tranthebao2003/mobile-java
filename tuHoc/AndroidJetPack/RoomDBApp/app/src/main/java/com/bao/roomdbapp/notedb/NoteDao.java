package com.bao.roomdbapp.notedb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {

//    lấy all data tu all cot cua bang  Constants.Table_Name_Note
    @Query("SELECT * FROM" + Constants.Table_Name_Note)
    List<Note> getNotes();

//    insert the Data:
    @Insert
    public long insertNote(Note note);

    @Update
    public void updateNote(Note repos);

    @Delete
    public void deleteNote(Note note);

//    delete all notes from the database:
//    , tham số Note... note sử dụng varargs (viết tắt của variable arguments) trong
//    Java, cho phép bạn truyền một hoặc nhiều đối tượng Note vào phương
//    thức này mà không cần định trước số lượng cụ thể
//    bên trong phương thức no se được xử li dươi dạng mảng Note[]
    @Delete
    public void deleteNotes(Note... note);
}
