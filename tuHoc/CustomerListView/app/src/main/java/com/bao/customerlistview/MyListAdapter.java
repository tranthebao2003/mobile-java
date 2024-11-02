package com.bao.customerlistview;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


public class MyListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] mainTitle;
    private final String [] description;
    private final Integer[] imgss;

//    Contructor

    public MyListAdapter(@NonNull Activity context1, String[] mainTitle, String[] description, Integer[] imgss) {
        super(context1, R.layout.item_custom_layour,mainTitle);
        this.context = context1;
        this.mainTitle = mainTitle;
        this.description = description;
        this.imgss = imgss;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
//        null: Tham số này chỉ định parent view của rowView. Khi là null, view không
//        được thêm trực tiếp vào bất kỳ parent nào trong quá trình inflate

//        true: Tham số này chỉ định xem có cần đính kèm rowView vào parent
//        ngay sau khi inflate hay không. Khi đặt là true, hệ thống
//        sẽ tự động attach view mới tạo vào parent. Trong hầu hết các
//        trường hợp khi dùng adapter, ta có thể để giá trị này là false
//        hoặc null để tự thêm sau.
        View rowView = inflater.inflate(R.layout.item_custom_layour, null, true);

        TextView titleText = rowView.findViewById(R.id.mediumText);
        TextView subText = rowView.findViewById(R.id.subText);

        ImageView imageView = rowView.findViewById(R.id.avarta);


        titleText.setText(mainTitle[position]);
        subText.setText(description[position]);
        imageView.setImageResource(imgss[position]);

        return rowView;
    };
}
