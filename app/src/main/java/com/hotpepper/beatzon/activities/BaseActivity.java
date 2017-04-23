package com.hotpepper.beatzon.activities;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.hotpepper.beatzon.R;

import com.hotpepper.beatzon.activities.utils.InputUtils;
import com.hotpepper.beatzon.activities.utils.SnackBarEventManager;


/**
 * Created by Nitish Singh on 10/8/16.
 */

public abstract class BaseActivity extends AppCompatActivity implements SnackBarEventManager.SnackBarNotifyListener {

    public abstract int getLayoutResourceId();

    public abstract int getNavigationIconId();

    public abstract void onNavigationIconClick(View v);

    public abstract String getActivityTitle();

    public abstract boolean focusAtLaunch();

    public Toolbar getToolbar() {
        return toolbar;
    }

    Toolbar toolbar;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (!focusAtLaunch()) {
            this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (getNavigationIconId() != 0)
            toolbar.setNavigationIcon(getNavigationIconId());
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(getActivityTitle());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (InputUtils.isKeyBoardOpen(BaseActivity.this))
                    InputUtils.hideKeyboard(BaseActivity.this);
                onNavigationIconClick(v);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SnackBarEventManager.addListener(this);
    }

    @Override
    protected void onStop() {
        SnackBarEventManager.removeListener(this);
        super.onStop();
    }

    @Override
    public void onNotify(SnackBarEventManager.SnackBarNotification e) {
        Snackbar.make(findViewById(android.R.id.content), e.getMessage(), Snackbar.LENGTH_LONG).show();
    }
}
