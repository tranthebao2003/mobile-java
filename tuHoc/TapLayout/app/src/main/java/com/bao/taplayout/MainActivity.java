package com.bao.taplayout;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tabChats = findViewById(R.id.tabChats);
        TabItem tabStatus = findViewById(R.id.tabStatus);
        TabItem tabCalls = findViewById(R.id.tabCalls);
        ViewPager viewPager = findViewById(R.id.viewPager);

//        tabLayout.getTabCount(); tra ve so luong item ma tabLayout có
        PagerAdapter pagerAdapter = new PageAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

//        one last step is to change the tabs view then the tab is selected or clicked
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            TabLayout.Tab: dieu nay cho thay Tap la 1 class nam trong
//            class TabLayout va no la static class nen minh khong can new
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

//            chua su dung
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
//            chua su dung
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}