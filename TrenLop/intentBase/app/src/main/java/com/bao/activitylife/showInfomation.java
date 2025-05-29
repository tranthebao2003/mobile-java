package com.bao.activitylife;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class showInfomation extends AppCompatActivity {
    TextView email2, password2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_infomation);
//        ánh xạ
        email2 = findViewById(R.id.email2);
        password2 = findViewById(R.id.pasword2);

        Intent i = getIntent();
        email2.setText(i.getExtras().getString("email"));
        password2.setText(i.getExtras().getString("password"));
    }

}