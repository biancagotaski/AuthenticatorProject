package com.developer.bianca.authenticatorproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class QuestionPagerAdapter extends FragmentPagerAdapter{

    public QuestionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        switch (position){
//            case 0:
//                return QuestionStackOverflowFragment.newInstance(Constants.ACTIVE_REGISTERS_ENDPOINT);
//            default:
                return null;
//        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
