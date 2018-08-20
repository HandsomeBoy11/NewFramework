package com.helw.m.anew.ui.tab1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018/8/9.
 */

public class HomeIconPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments=new ArrayList<>();

    public HomeIconPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void setData(List<Fragment> data) {
        fragments.clear();
        this.fragments = data;
        notifyDataSetChanged();
    }
}
