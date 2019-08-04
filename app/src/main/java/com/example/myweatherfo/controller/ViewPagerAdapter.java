/**
 * created by Heritier Muhire
 * Student Id: S1719021
 */
package com.example.myweatherfo.controller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> fragmentListTitles = new ArrayList<>();

    private int numOfTabs;

    public ViewPagerAdapter(FragmentManager fm /**int numOfTabs)*/ ){
        super(fm);

//        this.numOfTabs = numOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
//        switch (position) {
//            case 0:
//                return new Day1Fragment();
//            case 1:
//                return new Day2Fragment();
//            case 2:
//                return new Day3Fragment();
//            default:
//                return null;
//        }
    }

    @Override
    public int getCount() {
        return fragmentListTitles.size();
//        return numOfTabs;
    }

    public CharSequence getPageTitle(int position){
        return fragmentListTitles.get(position);

    }

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        fragmentListTitles.add(title);
    }
}
