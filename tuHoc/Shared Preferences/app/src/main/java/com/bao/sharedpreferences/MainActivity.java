package com.bao.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//    shared preference
    SharedPreferences sharedPreferences;
    EditText name, email;

//  myprefrences no la thuoc tinh của class MainActivity
//  tac dung chu "static" la de minh xai thang nay khong can
//  su dung tu khoa "new" mà chi can MainActivity.myprefrences
//  la duoc, con final (giong const trog js) de khai bao hang so
    public static final String myprefrences = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);

//      Khởi tạo SharedPreferences với tên "mypref"
//      Context.MODE_PRIVATE: Chỉ ứng dụng này mới có thể truy cập SharedPreferences, giúp
//      dữ liệu bảo mật ở mức cơ bản.
        sharedPreferences = getSharedPreferences(myprefrences, Context.MODE_PRIVATE);

//        checking for any data stored
//        sharedPreferences.contains(Name): Kiểm tra xem SharedPreferences có chứa dữ liệu cho khóa Name không.
//        Nếu Name tồn tại trong SharedPreferences,
//        dòng name.setText(sharedPreferences.getString(Name, "")); sẽ
//        lấy giá trị của Name và hiển thị nó trong TextView (name). tương tự email
        if(sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name, ""));
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email, ""));
        }
    }

//    saving data
    public void Save(View view){
//      lay du lieu tu editName
        String n = name.getText().toString();
//      lay du lieu tu editEmail
        String e = email.getText().toString();


//       su dung SharedPreferences.Editor de luu du lieu vao SharedPreferences
//        tao 1 editor cho phép thêm, sửa hoặc xóa dữ liệu trong SharedPreferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

//      editor.putString(Name, n);: Thêm một cặp key-value vào SharedPreferences với key là Name và value là chuỗi n
        editor.putString(Name, n);
//      tương tự như ở trên
        editor.putString(Email, e);

//      luu thay doi 1 cach async không chặn luồng chính
        editor.apply();

//        lưu thay đổi 1 cách sync chan luong chinh
//        editor.commit();
    }

//    clearing data fields
    public void Clear(View view){
        name.setText("");
        email.setText("");
    }

//    Getting Data:
    public void Get(View view){

//      Phương thức Get trong đoạn mã trên lấy dữ liệu đã lưu từ SharedPreferences
//      và hiển thị trong các trường editView cho tên (name) và email (email).

//      tuong tu nhu o tren ham save
        if(sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name, ""));
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email, ""));
        }
    }
}