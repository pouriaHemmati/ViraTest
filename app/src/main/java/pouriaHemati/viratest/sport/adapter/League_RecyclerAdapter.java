package pouriaHemati.viratest.sport.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import pouriaHemati.viratest.R;
import pouriaHemati.viratest.base.BaseActivity;
import pouriaHemati.viratest.model.JLeague;


public class League_RecyclerAdapter extends RecyclerView.Adapter<League_RecyclerAdapter.ViewHolder> {

    private Context context;
    private ModelItemJLeague requestItems;
    private OnItemClickListenerLeague onItemClickListenerLeague;
    private Picasso picasso;
    private LinearLayout selected_item;

    public League_RecyclerAdapter(Context context, ModelItemJLeague requestItems, OnItemClickListenerLeague onItemClickListenerLeague) {
        this.context = context;
        this.requestItems = requestItems;
        this.onItemClickListenerLeague = onItemClickListenerLeague;


    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView img_recycler_league;
        public LinearLayout lay_recycler_league;


        public ViewHolder(View itemView) {
            super(itemView);

            img_recycler_league = itemView.findViewById(R.id.img_recycler_league);
            lay_recycler_league = itemView.findViewById(R.id.lay_recycler_league);


        }

        @Override
        public void onClick(View v) {

        }


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_league, parent, false);
        return new ViewHolder(view);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ArrayList<JLeague> jLeagues = requestItems.jLeagues;
        picasso = Picasso.with(BaseActivity.getContext());


        picasso.load(jLeagues.get(position).getImage())
                .into(holder.img_recycler_league);
        holder.setIsRecyclable(false);


        holder.lay_recycler_league.setOnClickListener(v -> {
            onItemClickListenerLeague.onClickLastLeague(position);
            if (selected_item == null) {
                holder.lay_recycler_league.setBackgroundResource(R.drawable.radius_circular_blue);
            } else {
                if (holder.lay_recycler_league != selected_item) {
                    holder.lay_recycler_league.setBackgroundResource(R.drawable.radius_circular_blue);
                    selected_item.setBackgroundResource(R.drawable.radius_circular_gray);
                }
            }
            selected_item = holder.lay_recycler_league;

        });


    }


    @Override
    public int getItemCount() {
        return requestItems.jLeagues.size();
    }


}