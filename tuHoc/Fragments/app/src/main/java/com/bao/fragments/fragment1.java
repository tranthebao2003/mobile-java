package com.bao.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class fragment1 extends Fragment {

    TextView text, vers;

    public fragment1() {
        // Required empty public constructor
    }


    @Override
//    View nó giống class cha của TextView vậy vì TextView nó kết thừa từ View
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        text = (TextView) view.findViewById(R.id.AndroidApp);
        vers = (TextView) view.findViewById(R.id.Description);

        return view;
    }

//    thay đổi text trong TextView thôi
    public void change(String txt, String txt1){
        text.setText(txt);
        vers.setText(txt1);
    }
}