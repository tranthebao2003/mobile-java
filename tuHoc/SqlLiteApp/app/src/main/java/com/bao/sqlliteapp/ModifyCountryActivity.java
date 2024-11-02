package com.bao.sqlliteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class ModifyCountryActivity extends Activity implements View.OnClickListener {

//    widgets:
    private EditText titleText;
    private Button updateBtn, deleteBtn;
    private EditText descText;

    private long _id;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Modify Record");
        setContentView(R.layout.activity_modify_country);

        dbManager = new DBManager(this);
        dbManager.open();

        titleText = findViewById(R.id.subject_edittext);
        descText = findViewById(R.id.description_edittext);

        updateBtn = findViewById(R.id.btn_update);
        deleteBtn = findViewById(R.id.btn_delete);

//       nhan dữ liệu từ CountryListActivity truyền qua
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");

        _id = Long.parseLong(id);

//      show text nhan duoc len layout
        titleText.setText(name);
        descText.setText(desc);

//        ModifyCountryActivity đóng vai trò là một OnClickListener.
//        Khi nhấn updateBtn hoặc deleteBtn, phương thức onClick(View v)
//        trong ModifyCountryActivity sẽ được gọi để xử lý sự kiện cho cả hai nút.
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
    }

//    xu li su kien onclick
    @Override
    public void onClick(View view) {
        int idLayout = view.getId();

//        neu user click vao btn update
        if(idLayout == R.id.btn_update){
//            nhan text tu layout
            String title = titleText.getText().toString();
            String desc = descText.getText().toString();

//            goi ham update trong class DBManager
            dbManager.update(_id, title, desc);
//            gọi hàm returnHome trong class này
            this.returnHome();

        }
//        neu user click vao btn delete
        else if(idLayout == R.id.btn_delete){
            dbManager.delete(_id);
            this.returnHome();
        }
    }

    public void returnHome(){
//        chuyển từ màn hình này sang CountryListActivity
//        flag is used to clear the activity stack. If CountryListActivity
//        is already running, it will be resumed, and all other activities
//        on top of it will be destroyed.
        Intent home_intent = new Intent(getApplicationContext(),
                CountryListActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);


        startActivity(home_intent);
//        tạo animation
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


}