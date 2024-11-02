package com.bao.roomdbapp.notedb;

import androidx.room.TypeConverter;

import java.util.Date;

public class DataRoomConverter {

//  phai chuyen doi như vay vi room database không hỗ trơ
//  luu kieu phuc tao nhu date

//  params kieu long tra ve kieu Date
//  chuyen tu kieu long sang kieu Date
    @TypeConverter
    public static Date toDate(Long value){
        return value == null? null : new Date(value);
    }

//  params kieu Date tra ve kieu Long
//  chuyen tu kieu Date sang kieu Long
    @TypeConverter
    public static long toLong(Date value){
        return  value == null ? null : value.getTime();
    }
}
