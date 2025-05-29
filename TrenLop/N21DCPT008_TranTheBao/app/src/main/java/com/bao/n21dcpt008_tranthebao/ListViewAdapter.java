package com.bao.n21dcpt008_tranthebao;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bao.n21dcpt008_tranthebao.model.FoodLv;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<FoodLv> foodLvs;

    public ListViewAdapter(Context context, int layout, List<FoodLv> foodLvs) {
        this.context = context;
        this.layout = layout;
        this.foodLvs = foodLvs;
    }

    @Override
    public int getCount() {
        return foodLvs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, null);

        ImageView imgHinh = convertView.findViewById(R.id.img);
        TextView txtTitle = convertView.findViewById(R.id.title);
        TextView txtSubTitle = convertView.findViewById(R.id.subTitle);
        TextView txtPrice = convertView.findViewById(R.id.price);


        FoodLv foodLv = foodLvs.get(position);
        imgHinh.setImageResource(foodLv.getImg());
        txtTitle.setText(foodLv.getTitle());
        txtSubTitle.setText(foodLv.getSubTitle());
        txtPrice.setText(foodLv.getPrice());

        return convertView;
    }
}

