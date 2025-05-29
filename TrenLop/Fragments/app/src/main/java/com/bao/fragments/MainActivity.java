package com.bao.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentB.Counter{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    public void incrementValue(int count) {
//        FragmentB fragmentB;
//        fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragment_b);
//        fragmentB.setCount(count);
//    }

    public void incrementValue(int count) {
        FragmentB fragmentB;
        fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragment_b);
        if(fragmentB != null){
            fragmentB.setCount(count);
        }

    }
}