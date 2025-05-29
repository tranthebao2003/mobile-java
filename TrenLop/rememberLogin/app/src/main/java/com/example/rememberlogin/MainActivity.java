package com.example.rememberlogin;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userName;
    EditText password;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Gán các thành phần giao diện
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        checkBox = findViewById(R.id.checkBox);

        findViewById(R.id.buttonlogin).setOnClickListener(this);

        // Kiểm tra auto-login khi ứng dụng khởi động
        if (readAutoLogin()) {
            Toast.makeText(this, "Welcome back!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
                String usernameInput = userName.getText().toString();
                String passwordInput = password.getText().toString();

                if (usernameInput.isEmpty() || passwordInput.isEmpty()) {
                    Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                } else {
                    // Nếu checkbox được chọn, lưu thông tin đăng nhập
                    if (checkBox.isChecked()) {
                        saveAutoLogin();
                        Toast.makeText(this, "Auto-login enabled", Toast.LENGTH_SHORT).show();
                    }
                    // Chuyển sang màn hình đăng nhập thành công
                    Intent intent = new Intent(this, dangnhap.class);
                    startActivity(intent);
                    finish();
                }

    }

    private void saveAutoLogin() {
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", userName.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.apply(); // Nên dùng apply() thay vì commit() để tránh chặn luồng chính.
    }

    private boolean readAutoLogin() {
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        String username = preferences.getString("username", "");

        if (username != null && !username.equals("")) {
            Intent intent = new Intent(this, dangnhap.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }

}
