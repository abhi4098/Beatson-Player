package customViews.homepage;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.hotpepper.beatzon.R;

import java.util.ArrayList;
import java.util.List;

import com.hotpepper.beatzon.activities.adapters.TopBandsAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

/**
 * Created by Nitish Singh on 17/8/16.
 */
public class TopBandsView implements RecyclerViewOnClick {
    Context context;
    @BindView(R.id.top_bands_lv)
    RecyclerView recyclerView;


    public TopBandsView(Context context, LinearLayout viewContainer) {
        this.context = context;
        LinearLayout layout = (LinearLayout) View.inflate(context, R.layout.customview_top_bands_layout,null);
        viewContainer.addView(layout);
        ButterKnife.bind(this,viewContainer);
    }


    public void updateUI(){
        List<String> topBandsList = new ArrayList<>();
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");
        topBandsList.add("1");


        TopBandsAdapter topBandsAdapter = new TopBandsAdapter(context,topBandsList,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(topBandsAdapter);
        recyclerView.setNestedScrollingEnabled(false);

    }

    @Override
    public void onItemClick(View v, int position) {

    }
}
