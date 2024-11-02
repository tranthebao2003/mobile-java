package com.bao.databinding;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.bao.databinding.databinding.ActivityMainBinding;

//Class nay chính là View
public class MainActivity extends AppCompatActivity implements MainActivityContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        step 1 : add dependency (in file build grad;e (module: app)

//        step 2 : creating layout with databinding configuration

//        step 3 : Assigning variable to widgets

//        step 4: creating the model class: studentData

//        step 5: creating MainActivity presenter activity in order to present data

//        step 6: Creating MainActivity Contract Interface

//        step 7: adding the code to Main Activity and display them into correct widgets

//        step 8: Let's run the app and see the magic of data binding

//        this nay la context của mainActivity
//        ActivityMainBinding do chính layout ở activity_main nó tạo ra
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        this nay la view của mainActivity
        MainActivityPresenter mainActivityPresenter = new MainActivityPresenter(this, getApplicationContext());

        StudentData studentData = new StudentData("Student Grade", "10");

//      StudentData được gán cho layout thông qua binding.setGrader(studentData).
//      Nhờ Data Binding, khi giá trị của student hoặc grade thay đổi,
//      UI sẽ tự động cập nhật.
        binding.setGrader(studentData);
        binding.setPresenter(mainActivityPresenter);
    }

//    vi no implement tu view
    @Override
    public void showData(StudentData studentData) {
//        nhận từ hàm onShowData viết trong MainActivityPresenter
        String grade = studentData.getGrade();
        Toast.makeText(this, grade, Toast.LENGTH_SHORT).show();
    }
}