package com.freshlancers.sws.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.activities.home.HomeActivity;
import com.freshlancers.sws.ui.activities.notification.NotificationActivity;
import com.freshlancers.sws.ui.activities.profile.ProfileActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * Created by Ashith VL on 10/13/2017.
 */

public class BottomNavigationHelper {

    public static void setupBottomNavigationSetUp(BottomNavigationViewEx bnve){
        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);
        bnve.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, final Activity callingActivity, BottomNavigationViewEx bnve){

        // add badge
        Badge mBadge = addBadgeAt(context, 2, 12, bnve);

        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.ic_house:
                        Intent homeIntent = new Intent(context, HomeActivity.class);
                        context.startActivity(homeIntent);
                        callingActivity.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        break;
                    case R.id.ic_profile:
                        Intent searchIntent = new Intent(context, ProfileActivity.class);
                        context.startActivity(searchIntent);
                        callingActivity.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        break;
                    case R.id.ic_alert:
                        Intent circleIntent = new Intent(context, NotificationActivity.class);
                        context.startActivity(circleIntent);
                        callingActivity.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                        break;

                }
                return false;
            }
        });
    }

    /**
     * to add notification on the bottom navigation view
     * @param context
     * @param position
     * @param number
     * @param bottomNavigationViewEx
     * @return
     */

    public static Badge addBadgeAt(final Context context, int position, int number, BottomNavigationViewEx bottomNavigationViewEx) {
        // add badge
        return new QBadgeView(context)
                .setBadgeNumber(number)
                .setGravityOffset(36, 0, true)
                .bindTarget(bottomNavigationViewEx.getBottomNavigationItemView(position))
                .setBadgeBackgroundColor(Color.parseColor("#ff1400"))
                .setBadgeTextColor(Color.WHITE)
                .setShowShadow(true);
    }

}
