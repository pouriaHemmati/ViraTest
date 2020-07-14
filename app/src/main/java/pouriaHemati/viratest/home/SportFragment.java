package pouriaHemati.viratest.home;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import ir.hamsaa.persiandatepicker.Listener;
import ir.hamsaa.persiandatepicker.PersianDatePickerDialog;
import ir.hamsaa.persiandatepicker.util.PersianCalendar;
import pouriaHemati.viratest.R;
import pouriaHemati.viratest.base.BaseActivity;


import pouriaHemati.viratest.model.JGame;
import pouriaHemati.viratest.model.JLeague;
import pouriaHemati.viratest.sport.adapter.League_RecyclerAdapter;
import pouriaHemati.viratest.sport.adapter.ModelItemJLeague;
import pouriaHemati.viratest.sport.adapter.OnItemClickListenerLeague;
import pouriaHemati.viratest.util.CustomTabLayout;
import pouriaHemati.viratest.util.CustomViewPager;
import pouriaHemati.viratest.util.Pager;
import pouriaHemati.viratest.util.Shamsidate;
import pouriaHemati.viratest.widgets.CustomToastMasseg;

import static android.content.ContentValues.TAG;


public class SportFragment extends Fragment implements OnItemClickListenerLeague {
    private static SportFragment instanceSportFragment = null;

    public static SportFragment getInstanceSportFragment() {
        if (instanceSportFragment == null)
            instanceSportFragment = new SportFragment();

        return instanceSportFragment;
    }

    //This is our tablayout
    private CustomTabLayout tabLayout;
    Pager adapter;
    //This is our viewPager
    private CustomViewPager viewPager;
    View view;
    private FragmentActivity myContext;
    // persianDate
    PersianDatePickerDialog picker;
    // findView
    @BindView(R.id.logo_league)
    ImageView logo_league;

    // picasso
    Picasso picasso;

    // recycler league
    @BindView(R.id.recycler_league)
    RecyclerView recycler_league;
    League_RecyclerAdapter league_recyclerAdapter;
    ModelItemJLeague modelItemJLeague;
    ArrayList<JLeague> league_item_volume;
    JLeague modelItem_volume1;
    JLeague modelItem_volume2;
    JLeague modelItem_volume3;
    JLeague modelItem_volume4;
    JLeague modelItem_volume5;

    CustomToastMasseg customToastMasseg;

    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_sport, container, false);
        ButterKnife.bind(this, view);
        customToastMasseg = CustomToastMasseg.getCustomToastMasseg();
        picasso = Picasso.with(BaseActivity.getContext());

        // set model league
        league_item_volume = new ArrayList<>();
        modelItem_volume1 = new JLeague();
        modelItem_volume1.setImage(R.drawable.calendar);
        league_item_volume.add(modelItem_volume1);

        modelItem_volume2 = new JLeague();
        modelItem_volume2.setImage(R.drawable.heart);
        league_item_volume.add(modelItem_volume2);

        modelItem_volume3 = new JLeague();
        modelItem_volume3.setImage(R.drawable.england);
        league_item_volume.add(modelItem_volume3);

        modelItem_volume4 = new JLeague();
        modelItem_volume4.setImage(R.drawable.mls);
        league_item_volume.add(modelItem_volume4);

        modelItem_volume5 = new JLeague();
        modelItem_volume5.setImage(R.drawable.laliga);
        league_item_volume.add(modelItem_volume5);

        modelItemJLeague = new ModelItemJLeague(league_item_volume);


        //Initializing the tablayout
        tabLayout = (CustomTabLayout) view.findViewById(R.id.tabLayout_day);

        String yesterday = "دیروز";
        String today = "امروز";
        String tomorrow = "فردا";
        String future = "شنبه 22 آبان";
        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText(yesterday));
        tabLayout.addTab(tabLayout.newTab().setText(today));
        tabLayout.addTab(tabLayout.newTab().setText(tomorrow));
        tabLayout.addTab(tabLayout.newTab().setText(future));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        //Adding onTabSelectedListener to swipe views
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // set league recycler
        league_recyclerAdapter = new League_RecyclerAdapter(BaseActivity.getContext(), modelItemJLeague, this);
        recycler_league.setLayoutManager(new LinearLayoutManager(BaseActivity.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recycler_league.setAdapter(league_recyclerAdapter);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //Initializing viewPager
        viewPager = (CustomViewPager) view.findViewById(R.id.pager);
        FragmentManager fragManager = myContext.getSupportFragmentManager();
        //Creating our pager adapter
        adapter = new Pager(fragManager, tabLayout.getTabCount());


        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        tabLayout.getTabAt(1).select();
        viewPager.setCurrentItem(1);
    }

    @Override
    public void onAttach(Activity activity) {
        myContext = (FragmentActivity) activity;
        super.onAttach(activity);
    }


    @Override
    public void onClickLastLeague(int position) {
        if (position == 0)
            datePiker();
        if (position == 1){
            picasso.load(R.drawable.heart)
                    .into(logo_league);
        }else if (position == 2) {
            picasso.load(R.drawable.england)
                    .into(logo_league);
        } else if (position == 3) {
            picasso.load(R.drawable.mls)
                    .into(logo_league);
        } else if (position == 4) {
            picasso.load(R.drawable.laliga)
                    .into(logo_league);
        }

    }

    // listener show time piker
    private void datePiker() {
        PersianCalendar initDate = new PersianCalendar();
        initDate.setPersianDate(1369, 1, 1);
        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/IRANSansMobile(FaNum)_Medium.ttf");
        picker = new PersianDatePickerDialog(getActivity())
                .setPositiveButtonString("باشه")
                .setNegativeButton("بیخیال")
                .setTodayButton("امروز")
                .setTodayButtonVisible(true)
                .setMinYear(1300)
                .setMaxYear(PersianDatePickerDialog.THIS_YEAR)
                .setInitDate(initDate)
                .setActionTextColor(Color.GRAY)
                .setTypeFace(typeface)
                .setTitleType(PersianDatePickerDialog.WEEKDAY_DAY_MONTH_YEAR)
                .setShowInBottomSheet(true)
                .setListener(new Listener() {
                    @Override
                    public void onDateSelected(PersianCalendar persianCalendar) {
                        customToastMasseg.showToastMessage(BaseActivity.getContext(), String.valueOf(persianCalendar.getPersianLongDate()));
                    }

                    @Override
                    public void onDismissed() {

                    }
                });

        picker.show();

    }
}
