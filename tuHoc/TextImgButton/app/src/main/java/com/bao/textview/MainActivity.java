package com.bao.textview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

//    Put here you widgets: (Initialize Widgets)
    TextView textView;
    Button button;
    EditText editText;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        declaring & Initializing text widgets:
        textView = findViewById(R.id.textView11);

//        Setting text programatically
        textView.setText("Text is setted programmatically");
//        declaring & Initializing button widgets:
        button = findViewById(R.id.button);

//        Adding click Event on button click:
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // put here the code you want to execute when the button is clicked
                theButtonClicked();
            }
        });


//        editText widget:
        editText = findViewById(R.id.editText);

//        ImageView widget;
        imageView  = findViewById(R.id.imageView);
    }



//    cách 1
//    creating new method/function to be executed when buttin is clicked
    public void theButtonClicked() {
//        we will display a message in the log console when the button is clicked
//        we will see later on this course about: "LOG Lesson"
//        để show ra trong phần logcat gồm tag and content
//        giống console.log trong js
        Log.v("button", "The button is clicked");
        //        Getting text From EditText:
        Log.v("editText", "The text inside the Edit text: " + editText.getText());

//      changing image when button is clicked:
        imageView.setImageResource(R.drawable.hinh2);
    }
}