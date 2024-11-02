package com.bao.viewpage;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class CustomPagerAdapter extends PagerAdapter {

//    variables
    private Context mContext;

//    constructor

    public CustomPagerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        Log.d("modelObject", "" + ModelObject.values()[position]);
//        modelObject sẽ là 1 hang so minh dinh nghĩa trong enum
        ModelObject modelObject = ModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);

//        Log.d("getmLayoutResId", "" + modelObject.getmLayoutResId());
//        Log.d("R.layout.view_green", "" +R.layout.view_green);: trả ve so nguyen
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getmLayoutResId(),
                container,
                false);

        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
//        trong th nay no tra ve 3 cai enum
//        Log.d("getCount in customPagerAdapter", "" + ModelObject.values().length);
        return ModelObject.values().length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public CharSequence getpageTitle(int position){
        ModelObject customPagerEnum = ModelObject.values()[position];
        return  mContext.getString(customPagerEnum.getmLayoutResId());
    }
}
