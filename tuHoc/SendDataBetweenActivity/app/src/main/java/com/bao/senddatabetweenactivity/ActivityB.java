package com.bao.senddatabetweenactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity {

    TextView showEmail, showPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);;

        showEmail  = findViewById(R.id.showEmail);
        showPassword  = findViewById(R.id.showPassword);

//        getting extra from in tent
        Intent iGet = getIntent();
        String emailGet = iGet.getStringExtra("email");
        String passGet = iGet.getStringExtra("pass");

//        display welcome text
        showEmail.setText("Your email is: " + emailGet);
        showPassword.setText("Your password is: " + passGet);
    }
}