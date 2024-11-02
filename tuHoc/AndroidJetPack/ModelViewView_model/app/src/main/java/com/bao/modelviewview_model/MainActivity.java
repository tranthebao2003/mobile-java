package com.bao.modelviewview_model;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;


public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

//        creating instance of the view model class
//        ViewModelProvider được dùng để tạo hoặc truy xuất ViewModel (ScoreViewModel).
//        this là Activity hiện tại, đảm bảo ScoreViewModel tồn tại xuyên suốt vòng đời của Activity.
//        Nếu ScoreViewModel đã tồn tại, ViewModelProvider sẽ trả về cùng một
//        instance để giữ dữ liệu nhất quán trong vòng đời Activity.
        ScoreViewModel model = new ViewModelProvider(this).get(ScoreViewModel.class);

        DisplayPoints(model);
    }

    private void DisplayPoints(ScoreViewModel model) {
//        getting number of points

        textView.setText(""+model.scoreA);
        Toast.makeText(this, "Points of A " + model.scoreA, Toast.LENGTH_SHORT).show();
    }
}