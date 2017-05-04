package customView.artistpage;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hotpepper.beatzon.R;
import com.hotpepper.beatzon.activities.adapters.ArtistMostPopularTracksAdapter;
import com.hotpepper.beatzon.activities.adapters.MostPopularTrackAdapter;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abhinandan on 3/5/17.
 */

public class ArtistMostPopularTracksView implements RecyclerViewOnClick {
    Context mContext;
    LinearLayout artistmostPopularTrackLayout;
    @BindView(R.id.artist_most_popular_track_rv)
    RecyclerView recyclerView;

    public ArtistMostPopularTracksView(Context mContext, LinearLayout container) {
        this.mContext = mContext;
        artistmostPopularTrackLayout = (LinearLayout) View.inflate(mContext, R.layout.customview_artist_most_populat_layout,null);
        container.addView(artistmostPopularTrackLayout);
        ButterKnife.bind(this,container);
    }


    public void updateUI(){

        List<String> artistMostPopularTrackList = new ArrayList<>();
        artistMostPopularTrackList.add("1");
        artistMostPopularTrackList.add("1");
        artistMostPopularTrackList.add("1");



        ArtistMostPopularTracksAdapter artistMostPopularTrackAdapter = new ArtistMostPopularTracksAdapter(mContext, artistMostPopularTrackList, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(artistMostPopularTrackAdapter);
        recyclerView.setNestedScrollingEnabled(false);



    }

    @Override
    public void onItemClick(View v, int position) {

        Toast.makeText(mContext,"Clicked",Toast.LENGTH_SHORT).show();

    }
}
