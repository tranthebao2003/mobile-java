package com.bao.gridviewcustom.design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bao.gridviewcustom.R;
import com.bao.gridviewcustom.model.Logo;

import java.util.ArrayList;

public class GridviewAdapter extends ArrayAdapter<Logo> {
    public GridviewAdapter(@NonNull Context context, ArrayList<Logo> logos) {
        super(context,0, logos);
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

        Logo logo = getItem(position);
        holderView.icons.setImageResource(logo.getInconId());
        holderView.tv.setText(logo.getLetters());

        return convertView;
    }

    private static class HolderView{
        private final ImageView icons;
        private final TextView tv;

        public HolderView(View view) {
            this.icons = view.findViewById(R.id.icon_id);
            this.tv = view.findViewById(R.id.textViewId);
        }
    }
}
