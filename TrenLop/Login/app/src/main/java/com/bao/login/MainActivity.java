package com.bao.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnLogin, btnLogout;
    EditText username, password;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(this);

        btnLogout = findViewById(R.id.logout);
        btnLogout.setOnClickListener(this);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        checkBox = findViewById(R.id.checkBox);
    }

    private void saveAutoLogin(){
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();
    }

    private boolean readAutoLogin(){
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        String username = preferences.getString("username", "");

        if(username != null && !username.equals("")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }

    private void clearAutoLogin(){
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

    @Override
    public void onClick(View view) {
        Log.d("test", "onClick: test onclick");
        Intent intent = new Intent(this, TrangChu.class);
        startActivity(intent);
    }
}