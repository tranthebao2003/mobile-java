package com.bao.customerlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

//   1- ListView

//   2- Data
    String [] title = {
            "Youtube",
            "Facebook",
            "Linked",
            "Messenger",
            "Tiktok"
};

    String [] description = {
            "Trang mang video",
            "Trang mang xa hoi",
            "Trang mang ket noi viec lam",
            "Ung dung nhan tin",
            "Trang mang vi do ngan pho bien"
    };

//    Images as an array
    Integer[] imgs = {
        R.drawable.youtube,
        R.drawable.facebook,
        R.drawable.linkedin,
        R.drawable.messenger,
        R.drawable.tik_tok,
};

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListAdapter myListAdapter = new MyListAdapter(
                this, title, description, imgs);

        listView = findViewById(R.id.list);
        listView.setAdapter(myListAdapter);

//        handling click events on items
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                item 1 selected:
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                }
//                item 2 selected:
                if(position == 1){
                    Toast.makeText(MainActivity.this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                }
//                item 3 selected:
                if(position == 2){
                    Toast.makeText(MainActivity.this, "Item 3 selected", Toast.LENGTH_SHORT).show();
                }
//                item 4 selected:
                if(position == 3){
                    Toast.makeText(MainActivity.this, "Item 4 selected", Toast.LENGTH_SHORT).show();
                }
//                item 5 selected:
                if(position == 4){
                    Toast.makeText(MainActivity.this, "Item 5 selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}