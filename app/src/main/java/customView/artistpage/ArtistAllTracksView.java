package customView.artistpage;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hotpepper.beatzon.R;
import com.hotpepper.beatzon.activities.adapters.AllTrackAdapter;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abhinandan on 3/5/17.
 */

public class ArtistAllTracksView implements RecyclerViewOnClick {
    Context mContext;
    LinearLayout allTracksLayout;
    @BindView(R.id.all_tracks)
    RecyclerView recyclerView;

    public ArtistAllTracksView(Context mContext, LinearLayout container) {
        this.mContext = mContext;
        allTracksLayout = (LinearLayout) View.inflate(mContext, R.layout.customview_all_tracks_layout,null);
        container.addView(allTracksLayout);
        ButterKnife.bind(this,container);
    }


    public void updateUI(){

        List<String> artistAllTracksList = new ArrayList<>();
        artistAllTracksList.add("1");
        artistAllTracksList.add("1");
        artistAllTracksList.add("1");
        artistAllTracksList.add("1");
        artistAllTracksList.add("1");
        artistAllTracksList.add("1");
        artistAllTracksList.add("1");
        artistAllTracksList.add("1");

        AllTrackAdapter allTrackAdapter = new AllTrackAdapter(mContext, artistAllTracksList, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(allTrackAdapter);
        recyclerView.setNestedScrollingEnabled(false);



    }

    @Override
    public void onItemClick(View v, int position) {

        Toast.makeText(mContext,"Clicked",Toast.LENGTH_SHORT).show();

    }
}
