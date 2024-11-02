package com.bao.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

//    listView
    ListView listView;

//    data to be displayed into list
    String[] mobileTypes = {
            "Galaxy Note 8", "Iphone 11", "iphone 15pro", "Redme Q3s", "Huawei", "Iphine XSmax"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listviewy);

//        Array adapter
        ArrayAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                mobileTypes
        );

        listView.setAdapter(adapter);

//        handing click events in ListView

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "I will buy: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}