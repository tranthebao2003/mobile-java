package com.bao.n21dcpt008_tranthebao;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bao.n21dcpt008_tranthebao.model.FoodGv;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter<FoodGv> {


    public GridViewAdapter(@NonNull Context context,  ArrayList<FoodGv> foodGvs) {
        super(context, 0, foodGvs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        HolderView holderView;

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_view_item,
                    parent, false);

            holderView = new HolderView(convertView);
            convertView.setTag(holderView);
        }

        else{
            holderView = (HolderView) convertView.getTag();
        }

        FoodGv foodGv = getItem(position);
        holderView.img.setImageResource(foodGv.getImg());
        holderView.title.setText(foodGv.getTitle());

        return convertView;
    }

    private static class HolderView{
        private final ImageView img;
        private final TextView title;

        public HolderView(View view) {
            this.img = view.findViewById(R.id.img);
            this.title = view.findViewById(R.id.title);
        }
    }
}
