package com.freshlancers.sws.ui.activities.eventDetails;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.BaseView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;
import static com.freshlancers.sws.utils.Utils.setCheckable;

public class EventDetailsActivity extends AppCompatActivity implements EventDetailsContract.View, BaseView {

    private static final String TAG = "EventDetailsActivity";
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationView;

    private Context mContext = EventDetailsActivity.this;

    @Inject
    EventDetailsPresenter eventDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        ButterKnife.bind(this);

//        eventDetailsPresenter = new EventDetailsPresenter(mContext);

        DaggerEventDetailsComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        eventDetailsPresenter.attach(this);

        eventDetailsPresenter.bottomNavigationViewSetup(bottomNavigationView);

        backButtonOnToolbar(EventDetailsActivity.this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        eventDetailsPresenter.detach();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
    }

    @Override
    public void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx) {
        enableNavigation(mContext, this, bottomNavigationViewEx);
        setCheckable(bottomNavigationViewEx, false);

        // add badge
        //Badge mBadge = addBadgeAt(mContext, 2, 12, bottomNavigationViewEx);
    }
}
