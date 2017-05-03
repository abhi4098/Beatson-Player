package customView.bandpage;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hotpepper.beatzon.R;
import com.hotpepper.beatzon.activities.adapters.MostPopularTrackAdapter;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abhinandan on 3/5/17.
 */

public class MostPopularTracksView implements RecyclerViewOnClick {
    Context mContext;
    LinearLayout mostPopularTrackLayout;
    @BindView(R.id.most_popular_track_rv)
    RecyclerView recyclerView;

    public MostPopularTracksView(Context mContext, LinearLayout container) {
        this.mContext = mContext;
        mostPopularTrackLayout = (LinearLayout) View.inflate(mContext, R.layout.customview_most_popular_tracks_layout,null);
        container.addView(mostPopularTrackLayout);
        ButterKnife.bind(this,container);
    }


    public void updateUI(){

        List<String> mostPopularTrackList = new ArrayList<>();
        mostPopularTrackList.add("1");
        mostPopularTrackList.add("1");
        mostPopularTrackList.add("1");
        mostPopularTrackList.add("1");


        MostPopularTrackAdapter mostPopularTrackAdapter = new MostPopularTrackAdapter(mContext, mostPopularTrackList, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mostPopularTrackAdapter);
        recyclerView.setNestedScrollingEnabled(false);



    }

    @Override
    public void onItemClick(View v, int position) {

        Toast.makeText(mContext,"Clicked",Toast.LENGTH_SHORT).show();

    }
}
