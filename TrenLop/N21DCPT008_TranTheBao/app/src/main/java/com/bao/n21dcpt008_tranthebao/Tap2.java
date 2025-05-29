package com.bao.n21dcpt008_tranthebao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bao.n21dcpt008_tranthebao.model.ArrayFoodGv;

public class Tap2 extends Fragment {
    GridView gridView;
    GridViewAdapter gridviewAdapter;
    public Tap2(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tap2, container, false);
        gridView= view.findViewById(R.id.grid_view_food);
        gridviewAdapter= new GridViewAdapter(view.getContext(), new ArrayFoodGv().setListData());

        gridView.setAdapter(gridviewAdapter);

        return view;
    }
}