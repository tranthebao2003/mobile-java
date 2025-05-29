package com.bao.n21dcpt008_tranthebao.model;

import com.bao.n21dcpt008_tranthebao.R;

import java.util.ArrayList;

public class ArrayFoodGv {
    public ArrayList<FoodGv> setListData(){
        ArrayList<FoodGv> arrayList = new ArrayList<>();
        arrayList.add(new FoodGv(R.drawable.facebook_2, "facebook"));
        arrayList.add(new FoodGv(R.drawable.facebook_1, "facebook_1"));
        arrayList.add(new FoodGv(R.drawable.facebook_2, "facebook_2"));

        return arrayList;
    }
}
