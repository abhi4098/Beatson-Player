package com.hotpepper.beatzon.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.hotpepper.beatzon.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_login)
    public void openHomeScreen(){
        Intent intent = new Intent(LoginActivity.this,HomePageActivity.class);
        startActivity(intent);
    }
}
