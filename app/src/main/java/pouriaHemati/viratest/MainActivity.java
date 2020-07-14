package pouriaHemati.viratest;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import pouriaHemati.viratest.base.BaseActivity;
import pouriaHemati.viratest.base.BaseAppCompatActivity;
import pouriaHemati.viratest.bottomnavigation.MyAdapter;
import pouriaHemati.viratest.home.RecordFragment;
import pouriaHemati.viratest.home.Home2;
import pouriaHemati.viratest.home.Home3;
import pouriaHemati.viratest.home.Home4;
import pouriaHemati.viratest.home.SportFragment;


public class MainActivity extends BaseAppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    // collections
    private int tabIconColor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        myAdapter.addFragment(new Home2(), getResources().getString(R.string.home2));
        myAdapter.addFragment(new Home3(), getResources().getString(R.string.home3));
        myAdapter.addFragment(new RecordFragment(), getResources().getString(R.string.home));
        myAdapter.addFragment(SportFragment.getInstanceSportFragment(), getResources().getString(R.string.sport));
        myAdapter.addFragment(new Home4(), getResources().getString(R.string.home4));


        viewPager.setAdapter(myAdapter);
        viewPager.setOffscreenPageLimit(5);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_user);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_fax);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_add);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_sport);
        tabIconColor = ContextCompat.getColor(this, R.color.iconColorTabSelected);
        tabLayout.getTabAt(3).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_home);


        tabLayout.getTabAt(3).select();

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {


        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);

                        int tabIconColor = ContextCompat.getColor(BaseActivity.getContext(), R.color.iconColorTabSelected);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        int tabIconColor = ContextCompat.getColor(BaseActivity.getContext(), R.color.iconColorTabUnSelected);
                        tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );

            }
        });
    }

}