package com.bao.activitylife;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

     EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ánh xạ
        email =findViewById(R.id.email);
        password = findViewById(R.id.password);
        Log.d("TAG", "onCreate: ");

        Intent i2 = getIntent();
        email.setText(i2.getExtras().getString("email2"));
    }

//    vòng đời của activity để lưu trữ dữ liệu t 1 bước nào đó ...

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Tag", "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Tag", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Tag", "onDestroy: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Tag", "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Tag", "onResume: ");
    }

    public void login(View view) {
        Intent intent1 = new Intent(this, showInfomation.class);
        intent1.putExtra("email", email.getText().toString());
        intent1.putExtra("password", password.getText().toString());
        startActivity(intent1);
    }
}