package pouriaHemati.viratest.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import pouriaHemati.viratest.sport.FutureFragment;
import pouriaHemati.viratest.sport.TodayFragment;
import pouriaHemati.viratest.sport.TomorrowFragment;
import pouriaHemati.viratest.sport.YesterdayFragment;


public class Pager extends FragmentPagerAdapter {
    
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
                YesterdayFragment yesterdayFragment = new YesterdayFragment();
                return yesterdayFragment;
            case 1:
                TodayFragment todayFragment = new TodayFragment();
                return todayFragment;
            case 2:
                TomorrowFragment tomorrowFragment = new TomorrowFragment();
                return tomorrowFragment;
            case 3:
                FutureFragment futureFragment = new FutureFragment();
                return futureFragment;

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