package com.hotpepper.beatzon.activities;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hotpepper.beatzon.R;
import com.hotpepper.beatzon.activities.fragments.BandPageFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerScreenActivity extends BaseActivity {
    @BindView(R.id.seekArc)
    com.triggertrap.seekarc.SeekArc seekArc;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_player_screen;
    }

    @Override
    public int getNavigationIconId() {
        return R.mipmap.ic_back_black;
    }

    @Override
    public void onNavigationIconClick(View v) {
        onBackPressed();
    }

    @Override
    public String getActivityTitle() {
        return "Player Screen";
    }

    @Override
    public boolean focusAtLaunch() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        toolbar = getToolbar();
        setTitleNames(toolbar);
        setFragment();



    }

    private void setFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BandPageFragment bandPageFragment = new BandPageFragment();
        fragmentTransaction.add(R.id.band_fragment_container, bandPageFragment, "bandpage");
        fragmentTransaction.commit();
    }

    private void setTitleNames(Toolbar toolbar) {

        toolbar.setTitle(getString(R.string.player_screen));
        toolbar.setTitleTextColor(Color.BLACK);
    }
}
