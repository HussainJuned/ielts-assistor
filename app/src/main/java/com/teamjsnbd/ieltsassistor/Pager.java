package com.teamjsnbd.ieltsassistor;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by nuur on 10/17/2017.
 */

class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                Frt_One_FOne frt_one_fOne = new Frt_One_FOne();
                return frt_one_fOne;
            case 1:
                Frt_One_FTwo frt_one_fTwo = new Frt_One_FTwo();
                return frt_one_fTwo;
            case 2:
                Frt_One_FThree frt_one_fThree = new Frt_One_FThree();
                return frt_one_fThree;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}