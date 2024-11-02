package com.bao.recycleview;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Movie> movieList = new ArrayList<>();
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleViewId);

        myAdapter = new MyAdapter(movieList);

//       getApplicationContext(): trả về context của Activity này
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        set loai layout cho ca RecyclerView hien thi cho user o day minh dung linear ngoai ra con co grid ...
        recyclerView.setLayoutManager(layoutManager);

//      de set animation mình ko chinh thì de mac dinh
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);

        InsertData();
    }


    private void InsertData() {
        Movie movie = new Movie("Phim 1", "Action", "2002");
        movieList.add(movie);
        movie = new Movie("Phim 2", "kinh di", "2022");
        movieList.add(movie);
        movie = new Movie("Phim 3", "hai huoc", "2018");
        movieList.add(movie);
        movie = new Movie("Phim 4", "hai huoc", "2008");
        movieList.add(movie);
        movie = new Movie("Phim 5", "hanh dong", "2011");
        movieList.add(movie);
        movie = new Movie("Phim 7", "kinh dị", "2001");
        movieList.add(movie);


//        thông báo cho adapter rằng dữ liệu đã thay đổi để draw lại giao diện
        myAdapter.notifyDataSetChanged();
    }
}

