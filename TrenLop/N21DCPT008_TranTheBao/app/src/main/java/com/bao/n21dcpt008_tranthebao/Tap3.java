package com.bao.n21dcpt008_tranthebao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bao.n21dcpt008_tranthebao.model.ArrayFoodGv;

public class Tap3 extends Fragment {
    public Tap3(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tap3, container, false);

        return view;
    }
}