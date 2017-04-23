package customViews.homepage;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.hotpepper.beatzon.R;

import java.util.ArrayList;
import java.util.List;

import com.hotpepper.beatzon.activities.adapters.RecentlyViewedAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

/**
 * Created by Nitish Singh on 17/8/16.
 */
public class RecentViewedView implements RecyclerViewOnClick {

    Context context;
    @BindView(R.id.recent_viewed_lv)
    RecyclerView recyclerView;

    public RecentViewedView(Context context, LinearLayout viewContainer) {
        this.context = context;
        LinearLayout recentlayout = (LinearLayout) View.inflate(context,R.layout.customview_recent_viewed_layout,null);
        viewContainer.addView(recentlayout);
        ButterKnife.bind(this,viewContainer);
    }



    public void updateUI(){
        List<String> recentList = new ArrayList<>();
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");
        recentList.add("1");

        RecentlyViewedAdapter viewedAdapter = new RecentlyViewedAdapter(context,recentList,this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(viewedAdapter);
        recyclerView.setNestedScrollingEnabled(false);
    }


    @Override
    public void onItemClick(View v, int position) {

    }
}
