package com.bao.gridlayout;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class AdapterViDu extends BaseAdapter {
    private Context mContext;

    public AdapterViDu(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

//  trong bài này ko dùng
    @Override
    public Object getItem(int position) {
        return null;
    }

//   trong bài này ko dùng
    @Override
    public long getItemId(int position) {
        return 0;
    }

//    phương thức quan trọng nhất
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView;

        if(convertView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300,300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,100,8,8);
        } else{
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
//        Log.d("idAnh", "" + mThumbIds[position]);
        return imageView;
    }

//    array of image, nó là mảng Integer chứa các phần tử là id của ảnh trong
//    folder drawable chứ ko phải chứa tấm ảnh đâu. có thể bỏ comment ở trên
//    để xem
    public Integer[] mThumbIds = {
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5,
        R.drawable.img6,
        R.drawable.img7,
        R.drawable.img8,
    };
}
