package com.bao.lifecircle;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
//    final chỉ rằng giá trị của biến TAG không thể thay đổi sau
//    khi được gán ban đầu.
//    Đây là cách phổ biến để khai báo các hằng số,
//    chẳng hạn như TAG dùng để log trong Android.
    private static final String TAG = "Message";


    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"onCreate method is called");


        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), ActivitiB.class);
//                startActivity(i);

                gotoActivityB();
            }

        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse("https://edu.google.com/workspace-for-education/classroom/"));
                startActivity(i2);
            }
        });
    }

    private void gotoActivityB() {
        Intent i = new Intent(this, ActivitiB.class);
        startActivity(i);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart method is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart method is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume method is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy method is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause method is called");
    }
}