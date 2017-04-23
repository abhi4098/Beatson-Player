package com.hotpepper.beatzon.activities.tasks;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import com.hotpepper.beatzon.activities.interfaces.ViewLoadCallback;

/**
 * Created by Nitish Singh on 17/8/16.
 */
public class LoadViewAsync extends AsyncTask<Integer,Void,View> {

    Activity context;
    ViewLoadCallback viewLoadCallBack;

    public LoadViewAsync(Context context, ViewLoadCallback viewLoadCallBack) {
        this.context = (Activity) context;
        this.viewLoadCallBack = viewLoadCallBack;
    }
    @Override
    protected View doInBackground(Integer... params) {
        return context.getLayoutInflater().inflate(params[0], null, false);
    }


    @Override
    protected void onPostExecute(View view) {
        viewLoadCallBack.onViewLoaded(view);
        super.onPostExecute(view);
    }
}
