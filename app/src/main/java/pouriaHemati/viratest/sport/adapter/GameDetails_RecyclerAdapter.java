package pouriaHemati.viratest.sport.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import pouriaHemati.viratest.R;
import pouriaHemati.viratest.base.BaseActivity;
import pouriaHemati.viratest.model.JGame;


public class GameDetails_RecyclerAdapter extends RecyclerView.Adapter<GameDetails_RecyclerAdapter.ViewHolder> {
    private ModelItemJGame requestItems;
    private Context context;
    private Picasso picasso;


    public GameDetails_RecyclerAdapter(Context context, ModelItemJGame requestItems ) {
        this.context = context;
        this.requestItems = requestItems;


    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        public int team1;
        public int team2;
        public String nameTeam1;
        public String nameTeam2;
        public String goalTeam1;
        public String goalTeam2;
        public String timeGame;
        public boolean live;
        public boolean gameCancel;
        public String startGame;

        public LinearLayout lay_recycler_game_live;
        public LinearLayout lay_recycler_game_cancel;
        public TextView txt_recycler_game_time;
        public TextView txt_recycler_game_score_team1;
        public TextView txt_recycler_game_score_team2;
        public TextView txt_recycler_game_score;
        public TextView txt_recycler_game_start;
        public ImageView img_team1;
        public ImageView img_team2;




        public ViewHolder(View itemView) {
            super(itemView);

            lay_recycler_game_live = itemView.findViewById(R.id.lay_recycler_game_live);
            lay_recycler_game_cancel = itemView.findViewById(R.id.lay_recycler_game_cancel);
            txt_recycler_game_time = itemView.findViewById(R.id.txt_recycler_game_time);
            txt_recycler_game_score_team1 = itemView.findViewById(R.id.txt_recycler_game_score_team1);
            txt_recycler_game_score_team2 = itemView.findViewById(R.id.txt_recycler_game_score_team2);
            txt_recycler_game_score = itemView.findViewById(R.id.txt_recycler_game_score);
            txt_recycler_game_start = itemView.findViewById(R.id.txt_recycler_game_start);
            img_team1 = itemView.findViewById(R.id.img_team1);
            img_team2 = itemView.findViewById(R.id.img_team2);
//            name = itemView.findViewById(R.id.txt_name_comment_recycler);
//            date = itemView.findViewById(R.id.txt_date_comment_recycler);
//            description = itemView.findViewById(R.id.txt_description_comment_recycler);
//            img_profile_comment_recycler = itemView.findViewById(R.id.img_profile_comment_recycler);




        }

        @Override
        public void onClick(View v) {

        }


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_game_details, parent, false);
        return new ViewHolder(view);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ArrayList<JGame> gameModels = requestItems.jGames;

        picasso = Picasso.with(BaseActivity.getContext());

        holder.img_team1.setImageDrawable(gameModels.get(position).getTeam1());
        holder.img_team2.setImageDrawable(gameModels.get(position).getTeam2());


        if (gameModels.get(position).isLive()){
            holder.txt_recycler_game_score.setVisibility(View.VISIBLE);
            holder.lay_recycler_game_live.setVisibility(View.VISIBLE);
            holder.txt_recycler_game_start.setText(null);
            holder.txt_recycler_game_time.setText(gameModels.get(position).getTimeGame());
            holder.txt_recycler_game_score_team1.setText(String.valueOf(gameModels.get(position).getGoalTeam1()));
            holder.txt_recycler_game_score_team2.setText(String.valueOf(gameModels.get(position).getGoalTeam2()));
        } else {
            holder.lay_recycler_game_live.setVisibility(View.GONE);
            holder.txt_recycler_game_time.setText(null);
            holder.txt_recycler_game_score_team1.setText(null);
            holder.txt_recycler_game_score_team2.setText(null);
            holder.txt_recycler_game_score.setVisibility(View.GONE);
           holder.txt_recycler_game_start.setText(gameModels.get(position).getStartGame());
        }


        if (gameModels.get(position).isGameCancel()){
            holder.txt_recycler_game_start.setText(null);
            holder.lay_recycler_game_cancel.setVisibility(View.VISIBLE);
        } else {
            holder.lay_recycler_game_cancel.setVisibility(View.GONE);
        }

        if (gameModels.get(position).getGoalTeam1() > 0){
            holder.txt_recycler_game_score_team1.setTextColor(Color.parseColor("#2680EB"));
        } else {
            holder.txt_recycler_game_score_team1.setTextColor(Color.parseColor("#000000"));
        }
        if (gameModels.get(position).getGoalTeam2() > 0){
            holder.txt_recycler_game_score_team2.setTextColor(Color.parseColor("#2680EB"));
        } else {
            holder.txt_recycler_game_score_team2.setTextColor(Color.parseColor("#000000"));
        }




    }


    @Override
    public int getItemCount() {
        return requestItems.jGames.size();
    }


}