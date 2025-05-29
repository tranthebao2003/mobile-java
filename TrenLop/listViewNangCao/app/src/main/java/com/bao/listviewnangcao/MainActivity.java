package com.bao.listviewnangcao;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewCity;
    ArrayList<City> cityArrayList = new ArrayList<>();
    CityAdapter cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewCity = findViewById(R.id.listViewcity);
        cityArrayList.add(new City("thanh pho A", R.drawable.facebook, "https://meet.google.com/teo-qdqp-jck?authuser=2"));
        cityArrayList.add(new City("thanh pho A", R.drawable.linkedin, "https://www.youtube.com/"));
        cityArrayList.add(new City("thanh pho A", R.drawable.tik_tok, "https://web.facebook.com/?_rdc=1&_rdr"));

        cityAdapter = new CityAdapter(this, R.layout.dong_thanh_pho, cityArrayList);
        listViewCity.setAdapter(cityAdapter);
    }
}