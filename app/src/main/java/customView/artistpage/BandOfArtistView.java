package customView.artistpage;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hotpepper.beatzon.R;
import com.hotpepper.beatzon.activities.adapters.ArtistNewestTrackAdapter;
import com.hotpepper.beatzon.activities.adapters.BandOfArtistAdapter;
import com.hotpepper.beatzon.activities.adapters.NewestTrackAdapter;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abhinandan on 3/5/17.
 */

public class BandOfArtistView implements RecyclerViewOnClick {
    Context mContext;
    LinearLayout bandOfArtistViewLayout;
    @BindView(R.id.band_of_artist)
    RecyclerView recyclerView;

    public BandOfArtistView(Context mContext, LinearLayout container) {
        this.mContext = mContext;
        bandOfArtistViewLayout = (LinearLayout) View.inflate(mContext, R.layout.customview_band_of_artist,null);
        container.addView(bandOfArtistViewLayout);
        ButterKnife.bind(this,container);
    }


    public void updateUI(){

        List<String> bandOfArtistList = new ArrayList<>();
        bandOfArtistList.add("1");
        bandOfArtistList.add("1");
        bandOfArtistList.add("1");
        bandOfArtistList.add("1");


        BandOfArtistAdapter bandOfArtistAdapter = new BandOfArtistAdapter(mContext, bandOfArtistList, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(bandOfArtistAdapter);
        recyclerView.setNestedScrollingEnabled(false);



    }

    @Override
    public void onItemClick(View v, int position) {

        Toast.makeText(mContext,"Clicked",Toast.LENGTH_SHORT).show();

    }
}

