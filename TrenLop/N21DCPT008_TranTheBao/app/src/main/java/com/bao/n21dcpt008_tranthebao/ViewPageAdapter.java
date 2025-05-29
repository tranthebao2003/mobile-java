package com.bao.n21dcpt008_tranthebao;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageAdapter extends FragmentStatePagerAdapter {

    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tap1();
            case 1:
                return new Tap2();
            case 2:
                return new Tap3();
        }
        return null;
    }

    //    vì có 3 fragment
    @Override
    public int getCount() {
        return 3;
    }
}
