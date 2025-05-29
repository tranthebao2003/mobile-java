package com.bao.gridviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImgAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Img> imgList;

    public ImgAdapter(Context context, int layout, List<Img> imgList) {
        this.context = context;
        this.layout = layout;
        this.imgList = imgList;
    }

    @Override
    public int getCount() {
        return imgList.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        ImageView imageView = view.findViewById(R.id.img);
        TextView textView = view.findViewById(R.id.title);

        Img img = imgList.get(i);
        imageView.setImageResource(img.getImg());
        textView.setText(img.getName());

        return view;
    }
}
