package com.freshlancers.sws.ui.activities.notification;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.BaseView;
import com.freshlancers.sws.ui.recyclerAdapter.notification.NotificationRecyclerAdapter;
import com.freshlancers.sws.ui.recyclerAdapter.notification.NotificationListPresenter;
import com.freshlancers.sws.ui.models.Notification;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;
import static com.freshlancers.sws.utils.Utils.returnHome;

public class NotificationActivity extends AppCompatActivity implements NotificationContract.View, BaseView {

    private static final String TAG = "NotificationActivity";
    private static final int ACTIVITY_NUM = 2;
    @BindView(R.id.recycler_view)
    RecyclerView notificationRecyclerView;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationViewEx;
    @Inject
    NotificationPresenter notificationPresenter;
    @Inject
    ArrayList<Notification> mNotificationArrayList;
    @Inject
    NotificationRecyclerAdapter mNotificationRecyclerAdapter;
    @Inject
    NotificationListPresenter notificationListPresenter;
    private Context mContext = NotificationActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);

        DaggerNotificationComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        notificationPresenter.attach(this);

        notificationPresenter.bottomNavigationViewSetup(bottomNavigationViewEx);

        notificationPresenter.setupShowsRecyclerView(notificationRecyclerView);

        backButtonOnToolbar(NotificationActivity.this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notificationPresenter.detach();
    }

    @Override
    public void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx) {
        enableNavigation(mContext, this, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);

        // add badge
        // Badge mBadge = addBadgeAt(mContext, 2, 12, bottomNavigationViewEx);
    }

    @Override
    public void showRecyclerView() {
        notificationRecyclerView.setAdapter(mNotificationRecyclerAdapter);
        notificationPresenter.populateRecyclerView(mNotificationArrayList);
    }

    @Override
    public void updateAdapter() {
        mNotificationRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void updateAdapter(int position) {
        mNotificationRecyclerAdapter.notifyDataSetChanged();
        mNotificationRecyclerAdapter.notifyItemRangeChanged(position, mNotificationRecyclerAdapter.getItemCount());
    }

    @Override
    public void showError(String message) {
        Log.d(TAG, "showError: " + message);
    }

    @Override
    public boolean onSupportNavigateUp() {
        returnHome(mContext, NotificationActivity.this);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        returnHome(mContext, NotificationActivity.this);
    }

}
