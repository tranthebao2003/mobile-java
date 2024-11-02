package com.bao.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class fragment2 extends ListFragment {



    String [] AndroidApps = new String[]{
            "the bao",
            "The hai",
            "The bao 2003",
            "hai2333",
            "bay 1973"
    };

    String [] Descriptions = new String[]{
            "hoc sinh lop 10",
            "Hoc sinh nam 4",
            "Sinh nam 2003",
            "khong biet mieu ta gi",
            "lam cong nhan"
    };

    public fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2,
                container,
                false);
//        getActivity(): trả về context mà fragment2 này liên kết
//        cụ thể ở đây là MainActivity
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, AndroidApps
        );

        setListAdapter(adapter);

        return  view;
    }

//    được gọi tu dong khi user click vào imtem trong ListView
//    position đại diện cho vị trí (index) của item mà người dùng
//    vừa nhấp vào trong danh sách.
//     Android sẽ tự động gọi phương thức này và cung cấp
//     giá trị position của item tương ứng khi người dùng
//     nhấn vào một phần tử trong ListView.
    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
//        R.id.fragment1: là id của fragment1 trong file xml của activity_main
//        Sau do minh moi ep kieu no sang fragment1 roi gan no cho txt
//        trong txt minh co viet ham change set noi dung cho 2 TextView

        fragment1 txt = (fragment1)
                getParentFragmentManager().findFragmentById(R.id.fragment1);
        txt.change(AndroidApps[position], "Version : " + Descriptions[position]);
        getListView().setSelector(android.R.color.holo_blue_bright);
    }
}