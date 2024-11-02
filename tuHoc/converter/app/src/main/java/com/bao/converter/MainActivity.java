package com.bao.converter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

//    declaring widget
    EditText editText;
    TextView textView, textView2, textView4, valueinPounds;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        instaniating widgets
          textView = findViewById(R.id.textView);
          textView2 = findViewById(R.id.textView2);
          textView4 = findViewById(R.id.textView4);
          valueinPounds = findViewById(R.id.valueOfPound);

          editText = findViewById(R.id.editText);

          button = findViewById(R.id.button);

//        Adding a click event for button (executing the convert method when clicked)
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                calling convert From kilo to pound method
                convertKiloToPound();
            }
        });
    }

    private void convertKiloToPound() {
//        this method will convert the values enterd in editText
//        from kilo to pounds

        String valueEnteredKILO = editText.getText().toString();

//        convert string to number
        double kilo = Double.parseDouble(valueEnteredKILO);

//        converting kilo to pounds formula
        double pounds = kilo*2.205;

//        displaying the value resulted in textView
        valueinPounds.setText("" + pounds);
    }
}