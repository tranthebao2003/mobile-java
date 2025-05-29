package com.bao.navigationdrawer;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageButton imgButton;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        imgButton = findViewById(R.id.buttonDrawerToggle);
        navigationView = findViewById(R.id.navigationView);

        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.open();
            }
        });

        View headerView = navigationView.getHeaderView(0);
        ImageView userImg = headerView.findViewById(R.id.userImg);
        TextView textUsername = headerView.findViewById(R.id.textUsername);

//       navigationView.getHeaderView(0);: Phương thức này lấy header view đầu tiên (ở vị trí 0) từ NavigationView.
        userImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, textUsername.getText(), Toast.LENGTH_SHORT).show();
            }
        });


//        set onclick cho tung item
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                switch (itemId){
                    case R.id.navMenu:
                        Toast.makeText(MainActivity.this, "Menu clicked", Toast.LENGTH_SHORT).show();
                    case R.id.navCart:
                        Toast.makeText(MainActivity.this, "Cart clicked", Toast.LENGTH_SHORT).show();
                    case R.id.navFavourite:
                        Toast.makeText(MainActivity.this, "Favourite clicked", Toast.LENGTH_SHORT).show();
                    case R.id.navOrders:
                        Toast.makeText(MainActivity.this, "Orders clicked", Toast.LENGTH_SHORT).show();
                    case R.id.navHistory:
                        Toast.makeText(MainActivity.this, "History clicked", Toast.LENGTH_SHORT).show();
                    case R.id.navFeedback:
                        Toast.makeText(MainActivity.this, "Feedback clicked", Toast.LENGTH_SHORT).show();
                    case R.id.navTerms:
                        Toast.makeText(MainActivity.this, "Terms clicked", Toast.LENGTH_SHORT).show();
                    case R.id.navContact:
                        Toast.makeText(MainActivity.this, "Contact clicked", Toast.LENGTH_SHORT).show();
                    case R.id.navShare:
                        Toast.makeText(MainActivity.this, "Share clicked", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });
    }
}