package com.hotpepper.beatzon.activities;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.hotpepper.beatzon.R;

import butterknife.ButterKnife;
import com.hotpepper.beatzon.activities.fragments.HomePageFragment;


public class HomePageActivity extends BaseActivity {
   /* @BindView(R.id.txtTest)
    TextView testTextView;*/

    Toolbar toolbar;

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_main;
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
        return "BeatsOn";
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
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomePageFragment homePageFragment = new HomePageFragment();
        fragmentTransaction.add(R.id.fragement_container, homePageFragment,"homepage");
        fragmentTransaction.commit();
    }



    private void setTitleNames(Toolbar toolbar) {

        toolbar.setTitle(getString(R.string.appName));
        toolbar.setTitleTextColor(Color.BLACK);
    }
}
