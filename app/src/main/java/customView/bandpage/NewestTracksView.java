package customView.bandpage;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hotpepper.beatzon.R;
import com.hotpepper.beatzon.activities.adapters.NewestTrackAdapter;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abhinandan on 3/5/17.
 */

public class NewestTracksView implements RecyclerViewOnClick {
    Context mContext;
    LinearLayout newestTracks;
    @BindView(R.id.newest_tracks)
    RecyclerView recyclerView;

    public NewestTracksView(Context mContext, LinearLayout container) {
        this.mContext = mContext;
        newestTracks = (LinearLayout) View.inflate(mContext, R.layout.customview_newest_tracks,null);
        container.addView(newestTracks);
        ButterKnife.bind(this,container);
    }


    public void updateUI(){

        List<String> newestTrackList = new ArrayList<>();
        newestTrackList.add("1");
        newestTrackList.add("1");
        newestTrackList.add("1");
        newestTrackList.add("1");


        NewestTrackAdapter newestTrackAdapter = new NewestTrackAdapter(mContext, newestTrackList, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(newestTrackAdapter);
        recyclerView.setNestedScrollingEnabled(false);



    }

    @Override
    public void onItemClick(View v, int position) {

        Toast.makeText(mContext,"Clicked",Toast.LENGTH_SHORT).show();

    }
}

