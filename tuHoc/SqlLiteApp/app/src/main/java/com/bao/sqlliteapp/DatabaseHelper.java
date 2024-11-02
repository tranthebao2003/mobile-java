package com.bao.sqlliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

//    table Name:
    public static final String TABLE_NAME = "COUNTRIES";

//    table Columns:
    public static final String _ID = "_id";
    public static final String SUBJECT = "subject";
    public static final String DESC = "description";

//    database information
//    Neu ko co tu khoa public, private phia truoc thi no lả package-private
//    nghia la no co the truy cap thong qua cac class nam trong cung package
    static final String DB_NAME = "MASTER_ANDROID_APP.DB";

//    database Version
//    Phiên bản cơ sở dữ liệu là 1. Phiên bản này sẽ được
//    tăng khi có thay đổi về cấu trúc bảng.
    static final int DB_VERSION = 1;

//    creating table query:
//    CREATE_TABLE: Câu lệnh SQL để tạo bảng COUNTRIES. Bảng này có ba cột:
//    _ID: Khóa chính, tự động tăng.
//    SUBJECT: Cột kiểu TEXT không cho phép giá trị NULL.
//    DESC: Cột kiểu TEXT.
    private static final String CREATE_TABLE = "create table " + TABLE_NAME
        + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECT
        + " TEXT NOT NULL, " + DESC + " TEXT);";

//    constructor:
    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

//    Phương thức onCreate được gọi khi cơ sở dữ liệu được tạo lần đầu.
//    Phương thức này thực thi câu lệnh CREATE_TABLE để tạo bảng COUNTRIES
    @Override
    public void onCreate(SQLiteDatabase db) {
//        Executing the Query
        db.execSQL(CREATE_TABLE);
    }

    @Override
//    Phương thức onUpgrade được gọi khi có sự thay đổi về DB_VERSION. Nó xóa bảng
//    hiện tại và gọi lại onCreate để tạo lại bảng với cấu trúc mới.
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
