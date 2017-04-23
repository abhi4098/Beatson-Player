package com.hotpepper.beatzon.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hotpepper.beatzon.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

/**
 * Created by Nitish Singh on 17/8/16.
 */
public class LatestTrackAdapter extends RecyclerView.Adapter<LatestTrackAdapter.ViewHolder> {

    Context mContext;
    List<String> trackList;
    RecyclerViewOnClick recyclerViewOnItemClickListener;

    public LatestTrackAdapter(Context mContext, List<String> trackList, RecyclerViewOnClick recyclerViewOnItemClickListener) {
        this.mContext = mContext;
        this.trackList = trackList;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_home_page_tile_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.imgTrack.setBackgroundResource(R.drawable.play_icon);
        holder.imgTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewOnItemClickListener.onItemClick(v,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imgTrack)
        ImageView imgTrack;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
