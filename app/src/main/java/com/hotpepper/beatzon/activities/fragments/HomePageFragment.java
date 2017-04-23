package com.hotpepper.beatzon.activities.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import com.hotpepper.beatzon.R;

import butterknife.ButterKnife;
import customViews.homepage.LatestTracksView;
import customViews.homepage.RecentViewedView;
import customViews.homepage.TopArtistsView;
import customViews.homepage.TopBandsView;
import com.hotpepper.beatzon.activities.interfaces.ViewLoadCallback;
import com.hotpepper.beatzon.activities.tasks.LoadViewAsync;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment implements ViewLoadCallback{
    NestedScrollView rootView;
    ViewLoadCallback viewLoadCallBack;
    LinearLayout viewContainer;

    LatestTracksView latestTracksView;
    TopBandsView topBandsView;
    TopArtistsView topArtistsView;
    RecentViewedView recentViewedView;
    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = (NestedScrollView) inflater.inflate(R.layout.empty_layout, container, false);
        viewLoadCallBack = this;

        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                    rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else
                    rootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                new LoadViewAsync(getActivity(), viewLoadCallBack).execute(R.layout.fragment_home_page);
            }
        });
        return rootView;
    }

    @Override
    public void onViewLoaded(View view) {
        viewContainer = (LinearLayout) view;
        rootView.removeAllViews();
        rootView.addView(view);
        ButterKnife.bind(this,rootView);
        updateUIWithData();
    }

    private void updateUIWithData() {

        latestTracksView = new LatestTracksView(getActivity(),viewContainer);
        latestTracksView.updateUI();

        topBandsView = new TopBandsView(getActivity(),viewContainer);
        topBandsView.updateUI();

        topArtistsView = new TopArtistsView(getActivity(),viewContainer);
        topArtistsView.updateUI();

        recentViewedView = new RecentViewedView(getActivity(),viewContainer);
        recentViewedView.updateUI();


        rootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                rootView.scrollTo(0, 0);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN)
                    rootView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                else
                    rootView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }


}
