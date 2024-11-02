package com.bao.sqlliteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddCountryActivity extends Activity implements View.OnClickListener {

//    widgets:
    private Button addTodoBtn;
    private EditText subjectEditText, descEditText;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        setTitle("Add record");

//        Instantiation of widgets:
        subjectEditText = findViewById(R.id.subject_edittext);
        descEditText = findViewById(R.id.description_edittext);
        addTodoBtn = findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this) ;
    }

    @Override
    public void onClick(View view) {
        int idLayout = view.getId();

        if(R.id.add_record == idLayout) {
//            nhan content tu các edit text
            final String name = subjectEditText.getText().toString();
            final String desc = subjectEditText.getText().toString();

//            gọi hàm insert để thêm vào database
            dbManager.insert(name, desc);

//            sau khi thêm xong chuyển về lại màn hình chính
            Intent main = new Intent(AddCountryActivity.this,
                    CountryListActivity.class)
                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(main);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}