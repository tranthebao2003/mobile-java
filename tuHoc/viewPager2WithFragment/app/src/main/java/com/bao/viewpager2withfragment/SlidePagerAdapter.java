package com.bao.viewpager2withfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class SlidePagerAdapter extends FragmentStateAdapter {
    public static final int NUMBER_PAGE = 5;

    public SlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        SliderFragment sliderFragment = new SliderFragment();
        Bundle bundle = new Bundle();
//        vi position bat dau tu 0 ma minh muon hien tu
//        slider 1 den 5
        bundle.putString("CONTENT", "SLIDER "+ (position + 1));
        sliderFragment.setArguments(bundle);
        return sliderFragment;
    }

    @Override
//    so luong fragment hien thi
    public int getItemCount() {
        return NUMBER_PAGE;
    }
}
