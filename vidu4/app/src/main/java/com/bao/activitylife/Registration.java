package com.bao.activitylife;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Registration extends AppCompatActivity {
    EditText editEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        editEmail = findViewById(R.id.editEmail);
    }

    public void login2(View view) {
        Intent intent2 = new Intent(this, MainActivity.class);
        intent2.putExtra("email2", editEmail.getText().toString());
        startActivity(intent2);
    }
}