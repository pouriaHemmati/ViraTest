package pouriaHemati.viratest.sport;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pouriaHemati.viratest.R;
import pouriaHemati.viratest.base.BaseActivity;
import pouriaHemati.viratest.model.JGame;
import pouriaHemati.viratest.sport.adapter.GameDetails_RecyclerAdapter;
import pouriaHemati.viratest.sport.adapter.ModelItemJGame;
import pouriaHemati.viratest.util.HideShowScrollListener;


public class TodayFragment extends Fragment {

    ArrayList<JGame> teams_item_volume;
    JGame modelItem_volume;
    JGame modelItem_volume1;
    JGame modelItem_volume2;
    JGame modelItem_volume3;
    JGame modelItem_volume4;
    JGame modelItem_volume5;
    JGame modelItem_volume6;
    JGame modelItem_volume7;
    JGame modelItem_volume8;
    JGame modelItem_volume9;
    JGame modelItem_volume10;
    ModelItemJGame modelItemJGame;
    GameDetails_RecyclerAdapter gameDetails_recyclerAdapter;
    @BindView(R.id.recycler_show_game)
    RecyclerView recycler_show_game;

    View view;

    private static TodayFragment instanceTodayFragment = null;

    public static TodayFragment getInstanceTodayFragment(){
        if (instanceTodayFragment== null)
            instanceTodayFragment = new TodayFragment();
        return instanceTodayFragment;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_home2, container, false);
        ButterKnife.bind(this, view);


        teams_item_volume = new ArrayList<>();
        modelItem_volume = new JGame();
        modelItem_volume.setTeam1(getResources().getDrawable(R.drawable.ic_chelsi));
        modelItem_volume.setNameTeam1("چلسی");
        modelItem_volume.setGoalTeam1(0);
        modelItem_volume.setTeam2(getResources().getDrawable(R.drawable.ic_lester));
        modelItem_volume.setNameTeam2("لستر سیتی");
        modelItem_volume.setGoalTeam2(1);
        modelItem_volume.setTimeGame("35'");
        modelItem_volume.setLive(true);
        modelItem_volume.setGameCancel(false);
        modelItem_volume.setStartGame("20:30");
        teams_item_volume.add(modelItem_volume);

        modelItem_volume1 = new JGame();
        modelItem_volume1.setTeam1(getResources().getDrawable(R.drawable.ic_mancity));
        modelItem_volume1.setNameTeam1("منچستر سیتی");
        modelItem_volume1.setGoalTeam1(0);
        modelItem_volume1.setTeam2(getResources().getDrawable(R.drawable.ic_bournli));
        modelItem_volume1.setNameTeam2("لبرونلی");
        modelItem_volume1.setGoalTeam2(0);
        modelItem_volume1.setTimeGame("0'");
        modelItem_volume1.setLive(false);
        modelItem_volume1.setGameCancel(false);
        modelItem_volume1.setStartGame("22:30");
        teams_item_volume.add(modelItem_volume1);

        modelItem_volume2 = new JGame();
        modelItem_volume2.setTeam1(getResources().getDrawable(R.drawable.ic_briton));
        modelItem_volume2.setNameTeam1("برایتون");
        modelItem_volume2.setGoalTeam1(2);
        modelItem_volume2.setTeam2(getResources().getDrawable(R.drawable.ic_aston));
        modelItem_volume2.setNameTeam2("استون ویلا");
        modelItem_volume2.setGoalTeam2(1);
        modelItem_volume2.setTimeGame("65'");
        modelItem_volume2.setLive(true);
        modelItem_volume2.setGameCancel(false);
        modelItem_volume2.setStartGame("20:00");
        teams_item_volume.add(modelItem_volume2);

        modelItem_volume3 = new JGame();
        modelItem_volume3.setTeam1(getResources().getDrawable(R.drawable.ic_newcastel));
        modelItem_volume3.setNameTeam1("نیوکستل");
        modelItem_volume3.setGoalTeam1(0);
        modelItem_volume3.setTeam2(getResources().getDrawable(R.drawable.ic_lester));
        modelItem_volume3.setNameTeam2("لستر سیتی");
        modelItem_volume3.setGoalTeam2(0);
        modelItem_volume3.setTimeGame("0'");
        modelItem_volume3.setLive(false);
        modelItem_volume3.setGameCancel(true);
        modelItem_volume3.setStartGame("23:00");
        teams_item_volume.add(modelItem_volume3);

        modelItem_volume4 = new JGame();
        modelItem_volume4.setTeam1(getResources().getDrawable(R.drawable.ic_chelsi));
        modelItem_volume4.setNameTeam1("چلسی");
        modelItem_volume4.setGoalTeam1(0);
        modelItem_volume4.setTeam2(getResources().getDrawable(R.drawable.ic_mancity));
        modelItem_volume4.setNameTeam2("منچستر سیتی");
        modelItem_volume4.setGoalTeam2(0);
        modelItem_volume4.setTimeGame("0'");
        modelItem_volume4.setLive(false);
        modelItem_volume4.setGameCancel(false);
        modelItem_volume4.setStartGame("23:50");
        teams_item_volume.add(modelItem_volume4);


        modelItem_volume5 = new JGame();
        modelItem_volume5.setTeam1(getResources().getDrawable(R.drawable.ic_aston));
        modelItem_volume5.setNameTeam1("استون ویلا");
        modelItem_volume5.setGoalTeam1(0);
        modelItem_volume5.setTeam2(getResources().getDrawable(R.drawable.ic_newcastel));
        modelItem_volume5.setNameTeam2("نیوکاسل");
        modelItem_volume5.setGoalTeam2(0);
        modelItem_volume5.setTimeGame("0'");
        modelItem_volume5.setLive(false);
        modelItem_volume5.setGameCancel(false);
        modelItem_volume5.setStartGame("23:55");
        teams_item_volume.add(modelItem_volume5);

        modelItemJGame = new ModelItemJGame(teams_item_volume);

        TabLayout navBar = getActivity().findViewById(R.id.tabLayout);
        ConstraintLayout lay_filter = getActivity().findViewById(R.id.lay_filter);
        RecyclerView recycler_league = getActivity().findViewById(R.id.recycler_league);

        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {


                recycler_show_game.addOnScrollListener(new HideShowScrollListener() {

                    @Override
                    public void onHide() {
                        final Handler handler = new Handler();

                        navBar.animate().setInterpolator(new AccelerateDecelerateInterpolator()).translationY(navBar.getHeight());
                        lay_filter.animate().setInterpolator(new AccelerateDecelerateInterpolator()).translationY(-lay_filter.getHeight());
                        recycler_league.animate().setInterpolator(new AccelerateDecelerateInterpolator()).translationY(-recycler_league.getHeight());

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // do your hiding animation here
                                recycler_league.setVisibility(View.GONE);
                                navBar.setVisibility(View.GONE);
                                lay_filter.setVisibility(View.GONE);
                            }
                        }, 150);
                    }

                    @Override
                    public void onShow() {
                        final Handler handler = new Handler();
                        navBar.animate().setInterpolator(new AccelerateDecelerateInterpolator()).translationY(0);
                        lay_filter.animate().setInterpolator(new AccelerateDecelerateInterpolator()).translationY(0);
                        recycler_league.animate().setInterpolator(new AccelerateDecelerateInterpolator()).translationY(0);
                        // do your showing animation here

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                recycler_league.setVisibility(View.VISIBLE);
                                navBar.setVisibility(View.VISIBLE);
                                lay_filter.setVisibility(View.VISIBLE);
                            }
                        }, 150);
                    }
                });
            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        gameDetails_recyclerAdapter = new GameDetails_RecyclerAdapter(BaseActivity.getContext(), modelItemJGame);
        recycler_show_game.setLayoutManager(new LinearLayoutManager(BaseActivity.getContext(), LinearLayoutManager.VERTICAL, false));
        recycler_show_game.setAdapter(gameDetails_recyclerAdapter);
    }
}
