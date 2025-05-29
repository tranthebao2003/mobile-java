package com.bao.n21dcpt008_tranthebao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bao.n21dcpt008_tranthebao.model.FoodLv;

import java.util.ArrayList;

public class Tap1 extends Fragment {
    ListView listViewFood;
    ArrayList<FoodLv> foodLvs = new ArrayList<>();
    ListViewAdapter listViewAdapter;


    public Tap1(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.tap1, container, false);

        listViewFood = view.findViewById(R.id.listView);
        foodLvs.add(new FoodLv(R.drawable.facebook_1, "Ảnh 1", "subtitle", "33"));
        foodLvs.add(new FoodLv(R.drawable.facebook_2, "Ảnh 2", "subtitle2", "332"));
        foodLvs.add(new FoodLv(R.drawable.facebook_1, "Ảnh 12", "subtitle12", "3344"));


        listViewAdapter = new ListViewAdapter(view.getContext(), R.layout.list_view_item, foodLvs);
        listViewFood.setAdapter(listViewAdapter);
        return view;
    }
}