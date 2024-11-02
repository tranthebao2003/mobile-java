package com.bao.navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
//    declaring some objects
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.open, R.string.close);

        dl.addDrawerListener(t);
        t.syncState();

//      vi theme (trong file AndroidManifest.xml) nay co san toolbar nen minh co
//      the su dung dong nay ma khong can them toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = findViewById(R.id.nv);

//      add listener cho tung item trong navigationView
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                tra ve id ma user click vao
                int id = item.getItemId();

//                nêu dùng switch, cae thi case no bi loi do no yeu cau 1 hang so
//                ma R.id.settings khong duoc xem la 1 hang so nen bi loi, bat buoc
//                doi qua if else

//                R.id.account chính là những item trong navigation_menu
//                neu id user click vao no trung voi id nao do trong nhung item thì minh show toast len thoi
                if(id == R.id.account){
                    Toast.makeText(MainActivity.this, "My Account", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.settings){
                    Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                } else if(id == R.id.mycart){
                    Toast.makeText(MainActivity.this, "My Cart", Toast.LENGTH_SHORT).show();
                }
//                cho biet su kien da duoc xu li hoan tat
                return true;
            }
        });
    }

//    xu li khi 1 muc duoc chon
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}