package com.freshlancers.sws.ui.activities.profile;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.BaseView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.View, BaseView {

    private static final String TAG = "ProfileActivity";
    private Context mContext = ProfileActivity.this;
    private static final int ACTIVITY_NUM = 1;

    @Inject
    ProfilePresenter profilePresenter;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationViewEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        backButtonOnToolbar(ProfileActivity.this);

       // profilePresenter = new ProfilePresenter(mContext);

        DaggerProfileComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        profilePresenter.attach(this);
        profilePresenter.bottomNavigationViewSetup(bottomNavigationViewEx);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        profilePresenter.detach();
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.overflow: {
                View view = findViewById(R.id.overflow);
                profilePresenter.popupDisplay(view);
                break;
            }
        }
        return false;
    }


    @Override
    public void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx) {
        enableNavigation(mContext, this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

        // add badge
        //Badge mBadge = addBadgeAt(mContext, 2, 12, bottomNavigationViewEx);
    }

    @Override
    public void viewPopUp(PopupWindow popupWindow, View view) {
        popupWindow.showAsDropDown(view, -225, 0);
    }

}
