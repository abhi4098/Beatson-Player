package customViews.homepage;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hotpepper.beatzon.R;

import java.util.ArrayList;
import java.util.List;

import com.hotpepper.beatzon.activities.adapters.LatestTrackAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

/**
 * Created by Nitish Singh on 17/8/16.
 */
public class LatestTracksView implements RecyclerViewOnClick{
    Context mContext;
    LinearLayout latestTrackLayout;
    @BindView(R.id.latest_track_lv)
    RecyclerView recyclerView;

    public LatestTracksView(Context mContext, LinearLayout container) {
        this.mContext = mContext;
        latestTrackLayout = (LinearLayout) View.inflate(mContext, R.layout.customview_latest_track_layout,null);
        container.addView(latestTrackLayout);
        ButterKnife.bind(this,container);
    }


    public void updateUI(){

        List<String> trackList = new ArrayList<>();
        trackList.add("1");
        trackList.add("1");
        trackList.add("1");
        trackList.add("1");
        trackList.add("1");
        trackList.add("1");
        trackList.add("1");
        trackList.add("1");
        trackList.add("1");
        trackList.add("1");
        trackList.add("1");

        LatestTrackAdapter trackAdapter = new LatestTrackAdapter(mContext,trackList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(trackAdapter);
        recyclerView.setNestedScrollingEnabled(false);



    }

    @Override
    public void onItemClick(View v, int position) {

        Toast.makeText(mContext,"Clicked",Toast.LENGTH_SHORT).show();

    }
}
