package customViews.homepage;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hotpepper.beatzon.R;

import java.util.ArrayList;
import java.util.List;

import com.hotpepper.beatzon.activities.ArtistActivity;
import com.hotpepper.beatzon.activities.BandActivity;
import com.hotpepper.beatzon.activities.adapters.TopArtistsAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

/**
 * Created by Nitish Singh on 17/8/16.
 */
public class TopArtistsView implements RecyclerViewOnClick {


    Context context;
    @BindView(R.id.top_artists_lv)
    RecyclerView recyclerView;


    public TopArtistsView(Context context, LinearLayout viewContainer) {
        this.context = context;

        LinearLayout artistsLayout = (LinearLayout) View.inflate(context, R.layout.cutsomview_top_artists_layout,null);
        viewContainer.addView(artistsLayout);
        ButterKnife.bind(this,viewContainer);
    }



    public void updateUI(){
        List<String> topArtistsList = new ArrayList<>();
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");
        topArtistsList.add("1");

        TopArtistsAdapter topArtistsAdapter = new TopArtistsAdapter(context,topArtistsList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(topArtistsAdapter);
        recyclerView.setNestedScrollingEnabled(false);

    }
    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, ArtistActivity.class);
        context.startActivity(intent);
    }
}
