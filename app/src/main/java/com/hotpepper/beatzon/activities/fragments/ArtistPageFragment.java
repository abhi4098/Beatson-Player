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
import com.hotpepper.beatzon.activities.interfaces.ViewLoadCallback;
import com.hotpepper.beatzon.activities.tasks.LoadViewAsync;

import butterknife.ButterKnife;
import customView.artistpage.ArtistAllTracksView;
import customView.artistpage.ArtistMostPopularTracksView;
import customView.artistpage.ArtistNewestTracksView;
import customView.artistpage.BandOfArtistView;
import customView.bandpage.AllTracksView;
import customView.bandpage.MostPopularTracksView;
import customView.bandpage.NewestTracksView;

/**
 * Created by Abhinandan on 3/5/17.
 */

public class ArtistPageFragment extends Fragment implements ViewLoadCallback {
    NestedScrollView rootView;
    ViewLoadCallback viewLoadCallBack;
    LinearLayout viewContainer;

    ArtistMostPopularTracksView artistMostPopularTracksView;
    ArtistNewestTracksView artistNewestTracksView;
    BandOfArtistView bandOfArtistView;
    ArtistAllTracksView artistAllTracksView;
    // RecentViewedView recentViewedView;
    public ArtistPageFragment() {
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
                new LoadViewAsync(getActivity(), viewLoadCallBack).execute(R.layout.fragment_artist_page);
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


        artistMostPopularTracksView = new ArtistMostPopularTracksView(getActivity(),viewContainer);
        artistMostPopularTracksView.updateUI();

        artistNewestTracksView = new ArtistNewestTracksView(getActivity(),viewContainer);
        artistNewestTracksView.updateUI();

        bandOfArtistView = new BandOfArtistView(getActivity(),viewContainer);
        bandOfArtistView.updateUI();

        artistAllTracksView = new ArtistAllTracksView(getActivity(),viewContainer);
        artistAllTracksView.updateUI();

       /*

        recentViewedView = new RecentViewedView(getActivity(),viewContainer);
        recentViewedView.updateUI();
*/

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

