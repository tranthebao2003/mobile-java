package com.bao.gridlayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridy);

//      set adapter cho gridView tạo instance của class AdapterViDu
//      truyền vào this (this ở đây chính là context của activity đang chứa hàm này)
        gridView.setAdapter(new AdapterViDu(this));
        gridView.setNumColumns(3);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                ở đây mình ko thể chỉ dùng this để chỉ ra MainActivity bởi vì
//                hàm này là hàm nằm trong onCreate chu ko phải là 1 method của MainActivity
//                nên nếu dùng this no ko hieu
                Toast.makeText(MainActivity.this, "You hit grid item number: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}