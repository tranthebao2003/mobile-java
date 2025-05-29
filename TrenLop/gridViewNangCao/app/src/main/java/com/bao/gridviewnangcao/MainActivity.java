package com.bao.gridviewnangcao;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Img> imgList;
    ImgAdapter imgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridViewImg);
        imgList = new ArrayList<>();
        imgList.add(new Img(R.drawable.facebook, "facebook"));
        imgList.add(new Img(R.drawable.facebook_1, "facebook_1"));
        imgList.add(new Img(R.drawable.facebook_2, "facebook_2"));
        imgList.add(new Img(R.drawable.facebook_3, "facebook_3"));
        imgList.add(new Img(R.drawable.facebookffff, "facebookffff"));
        imgList.add(new Img(R.drawable.linkedin, "linkedin"));
        imgList.add(new Img(R.drawable.messenger, "messenger"));
        imgList.add(new Img(R.drawable.tik_tok, "tik_tok"));
        imgList.add(new Img(R.drawable.youtube, "youtube"));

        imgAdapter = new ImgAdapter(this, R.layout.dong_hinh_danh, imgList);
        gridView.setAdapter(imgAdapter);

    }
}