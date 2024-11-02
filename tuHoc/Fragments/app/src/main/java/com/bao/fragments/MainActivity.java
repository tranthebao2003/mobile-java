package com.bao.fragments;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// vì mình đã định nghĩa fragment1 trong activity_main.xml rồi nên đoạn dưới ko cần
//        nữa fragment1 vẫn có thể thay đổi khi mik click vào fragment2 khi app
//        vẫn đang chạy (runtime)

//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.fragment1, new fragment1())
//                .commit();
    }
}