package com.freshlancers.sws.ui.activities.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.BaseView;
import com.freshlancers.sws.ui.activities.assignment.AssignmentActivity;
import com.freshlancers.sws.ui.activities.attendance.AttendanceActivity;
import com.freshlancers.sws.ui.activities.calender.CalendarActivity;
import com.freshlancers.sws.ui.activities.events.EventsActivity;
import com.freshlancers.sws.ui.activities.markSheet.MarkSheetActivity;
import com.freshlancers.sws.ui.activities.payment.PaymentActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.crosswall.lib.coverflow.core.PagerContainer;
import me.relex.circleindicator.CircleIndicator;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;

public class HomeActivity extends AppCompatActivity implements HomeContract.View, BaseView {

    private Context mContext = HomeActivity.this;
    private static final int ACTIVITY_NUM = 0;
    private ViewPager mPager;

    @Inject
    HomePresenter homePresenter;

    @BindView(R.id.indicator)
    CircleIndicator indicator;

    @BindView(R.id.pager_container)
    PagerContainer container;

    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationViewEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

//        homePresenter = new HomePresenter(mContext);

        DaggerHomeComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        homePresenter.attach(this);

        mPager = container.getViewPager();
        homePresenter.carouselViewSetUp(mPager, indicator);
        homePresenter.bottomNavigationViewSetup(bottomNavigationViewEx);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenter.detach();
    }

    @Override
    public void onBackPressed() {
        homePresenter.onBackPress();
    }

    @OnClick(R.id.eventsRelativeLayout)
    public void openEventsActivity() {
        Intent eventsIntent = new Intent(mContext, EventsActivity.class);
        startActivity(eventsIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @OnClick(R.id.markSheetRelativeLayout)
    public void openMarkSheetActivity() {
        Intent eventsIntent = new Intent(mContext, MarkSheetActivity.class);
        startActivity(eventsIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @OnClick(R.id.paymentRelativeLayout)
    public void openPaymentActivity() {
        Intent paymentIntent = new Intent(mContext, PaymentActivity.class);
        startActivity(paymentIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @OnClick(R.id.assignmentRelativeLayout)
    public void openAssignmentActivity() {
        Intent paymentIntent = new Intent(mContext, AssignmentActivity.class);
        startActivity(paymentIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @OnClick(R.id.calenderRelativeLayout)
    public void openCalenderActivity() {
        Intent paymentIntent = new Intent(mContext, CalendarActivity.class);
        startActivity(paymentIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @OnClick(R.id.attendanceRelativeLayout)
    public void openAttendanceActivity() {
        Intent paymentIntent = new Intent(mContext, AttendanceActivity.class);
        startActivity(paymentIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void viewCarousel(final PagerAdapter wrappedAdapter, ViewPager mPager) {
        mPager.setAdapter(wrappedAdapter);
        indicator.setViewPager(mPager);
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
