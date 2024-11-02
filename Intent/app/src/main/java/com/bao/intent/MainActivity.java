package com.bao.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int [] listBtnId = {R.id.btnShowWeb, R.id.callSomeOne, R.id.btnSendMessage,
            R.id.editContact, R.id.viewContact};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        for(int id: listBtnId){
            Button btnTemp = (Button) findViewById(id);
            btnTemp.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        int id = view.getId();

        if(id == R.id.btnShowWeb){
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.youtube.com/"));
        } else if(id == R.id.callSomeOne){
            intent.setAction(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel: 0377253857"));
        } else if(id == R.id.btnSendMessage){
            intent.setAction(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("sms: 0377253857"));
            intent.putExtra("sms_body", "xin chào");
        } else if(id == R.id.viewContact){
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("content://contacts/people/"));
        } else if(id == R.id.editContact){
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("content://contacts/people/1"));
        }
        startActivity(intent);

    }
}