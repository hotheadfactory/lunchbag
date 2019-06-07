package com.lunchbag.lunchbag;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class tabpagerAdapter extends FragmentStatePagerAdapter {

    String[] tabArray = new String[]{"룰렛", "리뷰", "검색"};
    Integer tabnumber = 3;

    public tabpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabArray[position];

    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                Roulette Roulette1 = new Roulette();
                return Roulette1;

            case 1:
                Review Review1 = new Review();
                return Review1;

            case 2:
                Search Search1 = new Search();
                return Search1;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}
