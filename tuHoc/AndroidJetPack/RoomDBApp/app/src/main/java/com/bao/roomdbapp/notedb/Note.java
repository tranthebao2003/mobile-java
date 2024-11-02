package com.bao.roomdbapp.notedb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity (tableName = Constants.Table_Name_Note)
public class Note implements Serializable {

//    columns:
    @PrimaryKey(autoGenerate = true)
    private long note_id;

    @ColumnInfo(name = "note_content")
    private String content;

    private String title;
    private Date date;

//    constructor

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = new Date(System.currentTimeMillis());
    }

//  Annotation @Ignore được sử dụng trong Room để bỏ qua một phương thức
//  hoặc một thuộc tính khi Room tạo bảng từ Entity
    @Ignore
    public Note(){}

    public long getNote_id() {
        return note_id;
    }

    public void setNote_id(long note_id) {
        this.note_id = note_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return note_id == note.note_id && Objects.equals(content, note.content) && Objects.equals(title, note.title) && Objects.equals(date, note.date);
    }

//    Phương thức này tạo hashCode cho đối tượng dựa trên note_id và title.
//    Mã băm này giúp đảm bảo rằng các đối tượng có dữ liệu khác nhau
//    sẽ có giá trị hashCode khác nhau, cải thiện hiệu quả của các cấu
//    trúc dữ liệu dựa trên hash.
    @Override
    public int hashCode() {
        int result = (int) note_id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        return "Note{" + "note_id = " + note_id + ", content = " + content
                + ", title = " + title + ", data = " + date + "}";
    }
}
