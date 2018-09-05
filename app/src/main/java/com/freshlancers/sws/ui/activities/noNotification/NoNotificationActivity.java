package com.freshlancers.sws.ui.activities.noNotification;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.BaseView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;
import static com.freshlancers.sws.utils.Utils.returnHome;

public class NoNotificationActivity extends AppCompatActivity implements NoNotificationContract.View, BaseView {

    private static final String TAG = "NoNotificationActivity";
    private Context mContext = NoNotificationActivity.this;
    private static final int ACTIVITY_NUM = 2;

    @Inject
    NoNotificationPresenter noNotificationPresenter;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationViewEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_notification);

        ButterKnife.bind(this);

//        noNotificationPresenter = new NoNotificationPresenter(mContext);

        DaggerNoNotificationComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        noNotificationPresenter.attach(this);

        noNotificationPresenter.bottomNavigationViewSetup(bottomNavigationViewEx);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        noNotificationPresenter.detach();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        returnHome(mContext, NoNotificationActivity.this);
    }


    @Override
    public void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx) {
        enableNavigation(mContext, this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

        // add badge
//        Badge mBadge = addBadgeAt(mContext, 2, 12, bottomNavigationViewEx);
//        mBadge.hide(true);
    }
}
