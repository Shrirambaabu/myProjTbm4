package com.freshlancers.sws.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.freshlancers.sws.ui.activities.home.HomeActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Ashith VL on 12/6/2017.
 */

public class Utils {

    public static void returnHome(Context mContext, Activity mActivity) {
        Intent homeIntent = new Intent(mContext, HomeActivity.class);
        mContext.startActivity(homeIntent);
        mActivity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public static void backButtonOnToolbar(AppCompatActivity mActivity) {
        if (mActivity.getSupportActionBar() != null) {
            mActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public static void setCheckable(BottomNavigationViewEx view, boolean checkable) {
        final Menu menu = view.getMenu();
        for (int i = 0; i < menu.size(); i++) {
            menu.getItem(i).setCheckable(checkable);
        }
    }

}
