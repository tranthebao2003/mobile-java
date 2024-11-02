package com.bao.sqlliteapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class CountryListActivity extends AppCompatActivity {

    private DBManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;
//    create 1 array String với cac phần tử là các cột
    final String[] from = new String[]{
            DatabaseHelper._ID,
            DatabaseHelper.SUBJECT,
            DatabaseHelper.DESC
    };

//    create 1 array int la nhung so tuong ung voi tung thành phần
//    trong layout activity_view_record
    final int [] to = new int[]{R.id.id, R.id.title, R.id.desc};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        de set title o actionToolbar (neu theme do co actionToolbar mac dinh)
        setTitle("Home");
        setContentView(R.layout.fragment_emp_list);

        dbManager = new DBManager(this);
//       open database
        dbManager.open();

        Cursor cursor = dbManager.fetch();
        listView = findViewById(R.id.list_view);
//      Nếu ListView không có dữ liệu, View được gán (ở đây là R.id.empty) sẽ
//      tự động hiển thị để báo cho user rằng danh sách trống.
        listView.setEmptyView(findViewById(R.id.empty));

//      truyền record tương ứng của các cột trong database vào các item trong listView
        adapter = new SimpleCursorAdapter(this, R.layout.activity_view_record,
                cursor, from, to, 0);

//        nếu có thay đổi thì gọi hàm này để cập nhật nếu flag là 0
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

//        onClickLister for list items"
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long viewid) {
//                mapping nhung thanh phan trong activity_view_record vào textView tuong ung
                TextView idTextView = view.findViewById(R.id.id);
                TextView titleTextView = view.findViewById(R.id.title);
                TextView descTextView = view.findViewById(R.id.desc);

//                lay content ben trong nhung thanh phan activity_view_record
                String id = idTextView.getText().toString();
                String title = titleTextView.getText().toString();
                String desc = descTextView.getText().toString();

//                chuyển sang ModifyCountryActivity và đính kèm dữ liệu
                Intent modify_intent = new Intent(getApplicationContext(), ModifyCountryActivity.class);
                modify_intent.putExtra("title", title);
                modify_intent.putExtra("desc", desc);
                modify_intent.putExtra("id", id);

//                bat dau truyen
                startActivity(modify_intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//      getMenuInflater().inflate(R.menu.menu, menu); sẽ "nạp" (inflate)
//      tệp menu XML (trong trường hợp này là menu.xml) vào đối tượng menu.
//      Phương thức trả về true để chỉ ra rằng menu đã được tạo thành công.
        getMenuInflater().inflate(R.menu.menu , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

//        nếu user ấn vào btn add_record thì chuyển đến AddCountryActivity
        if(id == R.id.add_record){
            Intent add_mem = new Intent(this, AddCountryActivity.class);
            startActivity(add_mem);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

        return super.onOptionsItemSelected(item);

    }
}