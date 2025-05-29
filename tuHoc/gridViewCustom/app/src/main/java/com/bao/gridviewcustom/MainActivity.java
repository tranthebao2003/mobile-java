package com.bao.gridviewcustom;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bao.gridviewcustom.design.GridviewAdapter;
import com.bao.gridviewcustom.model.ArrayLogo;
import com.bao.gridviewcustom.model.Logo;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.my_grid_view);
        GridviewAdapter gridviewAdapter = new
                GridviewAdapter(MainActivity.this,
                new ArrayLogo().setListData());

        gridView.setAdapter(gridviewAdapter);
        gridView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
        Logo logo = (Logo) parent.getItemAtPosition(position);
        Toast.makeText(MainActivity.this,
                "Clicked by: " + logo.getLetters(),
                Toast.LENGTH_SHORT).show();
    }
}