package com.bao.senddatabetweenactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button button;

// 2 cái khai báo biến này 1 là đặt ở đây cho nó làm thuộc tính của
//    class này lun, hoặc đặt nó vào hàm onClick chứ nếu đặt
//    trong hàm setOnClickListener thì nó chỉ có tác dụng trong hàm
//    đó thôi dẫn đến mặc dù ko báo lỗi nhưng dữ liệu ko truyền qua
//    activity khác được
    String emailString;
    String passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        button = findViewById(R.id.btnLogin);

      button.setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View view) {
              emailString = email.getText().toString();
              passwordString = password.getText().toString();

              Intent i = new Intent(getApplicationContext(), ActivityB.class);
              i.putExtra("email", emailString);
              i.putExtra("pass", passwordString);

              startActivity(i);
          }
      });

    }

}