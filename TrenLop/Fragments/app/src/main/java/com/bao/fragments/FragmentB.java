package com.bao.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    TextView textView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v;
        v = inflater.inflate(R.layout.fragment_b, container, false);

        textView = v.findViewById(R.id.textView);

        return v;
    }

    public void setCount(int count) {
        textView.setText("count: "+count);
    }

    public interface Counter{
        public void incrementValue(int count);
    }
}
