package com.freshlancers.sws.ui.activities.events;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.BaseView;
import com.freshlancers.sws.ui.recyclerAdapter.event.EventsRecyclerAdapter;
import com.freshlancers.sws.ui.recyclerAdapter.event.EventsListPresenter;
import com.freshlancers.sws.ui.models.Events;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;
import static com.freshlancers.sws.utils.Utils.setCheckable;

public class EventsActivity extends AppCompatActivity implements EventsContract.View, BaseView {

    private static final String TAG = "EventsActivity";
    @BindView(R.id.recycler_view_empty)
    EmptyRecyclerView eventsRecyclerView;
    @BindView(R.id.empty_view)
    RelativeLayout emptyRelativeLayout;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationViewEx;

    private Context mContext = EventsActivity.this;

    @Inject
    EventsPresenter eventsPresenter;
    @Inject
    EventsRecyclerAdapter mEventsRecyclerAdapter;
    @Inject
    ArrayList<Events> mEventsArrayList;
    @Inject
    EventsListPresenter eventsListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        ButterKnife.bind(this);

        // eventsPresenter = new EventsPresenter(mContext);

        DaggerEventsComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        eventsPresenter.attach(this);

//        eventsListPresenter = new EventsListPresenter(mContext, mEventsArrayList);

//        mEventsRecyclerAdapter = new EventsRecyclerAdapter(eventsListPresenter);

        eventsPresenter.bottomNavigationViewSetup(bottomNavigationViewEx);
        eventsPresenter.setupShowsRecyclerView(eventsRecyclerView,emptyRelativeLayout);

        backButtonOnToolbar(EventsActivity.this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        eventsPresenter.detach();
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

    @Override
    public void showRecyclerView() {
        eventsRecyclerView.setAdapter(mEventsRecyclerAdapter);
        eventsPresenter.populateRecyclerView(mEventsArrayList);
    }

    @Override
    public void updateAdapter() {
        mEventsRecyclerAdapter.notifyDataSetChanged();
    }


    @Override
    public void showError(String message) {
        Log.d(TAG, "showError: " + message);
    }
}
