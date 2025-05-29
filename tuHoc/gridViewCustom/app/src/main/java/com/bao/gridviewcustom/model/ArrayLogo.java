package com.bao.gridviewcustom.model;

import com.bao.gridviewcustom.R;

import java.util.ArrayList;

public class ArrayLogo {
    public ArrayList<Logo> setListData(){
        ArrayList<Logo> arrayList = new ArrayList<>();
        arrayList.add(new Logo(R.drawable.facebook, "facebook"));
        arrayList.add(new Logo(R.drawable.facebook_1, "facebook_1"));
        arrayList.add(new Logo(R.drawable.facebook_2, "facebook_2"));
        arrayList.add(new Logo(R.drawable.facebook_3, "facebook_3"));
        arrayList.add(new Logo(R.drawable.facebookffff, "facebookffff"));
        arrayList.add(new Logo(R.drawable.linkedin, "linkedin"));
        arrayList.add(new Logo(R.drawable.messenger, "messenger"));
        arrayList.add(new Logo(R.drawable.tik_tok, "tik_tok"));
        arrayList.add(new Logo(R.drawable.youtube, "youtube"));

        return arrayList;
    }
}
