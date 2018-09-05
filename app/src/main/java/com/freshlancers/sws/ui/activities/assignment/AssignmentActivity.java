package com.freshlancers.sws.ui.activities.assignment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.ui.recyclerAdapter.assignment.AssignmentListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.assignment.AssignmentRecyclerAdapter;
import com.freshlancers.sws.ui.models.Assignment;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarListener;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import timber.log.Timber;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;
import static com.freshlancers.sws.utils.Utils.setCheckable;

public class AssignmentActivity extends AppCompatActivity implements AssignmentContract.View {

    public static final int NUMBER_OF_DATES_ON_SCREEN = 7;
    @BindView(R.id.recycler_view_empty)
    EmptyRecyclerView assignmentRecyclerView;
    @BindView(R.id.empty_view)
    RelativeLayout emptyRelativeLayout;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationViewEx;

    @Inject
    AssignmentPresenter assignmentPresenter;
    @Inject
    AssignmentRecyclerAdapter mAssignmentRecyclerAdapter;
    @Inject
    ArrayList<Assignment> mAssignmentArrayList;
    @Inject
    AssignmentListPresenter assignmentListPresenter;

    private Context mContext = AssignmentActivity.this;
    private HorizontalCalendar horizontalCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        ButterKnife.bind(this);

        DaggerAssignmentComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        assignmentPresenter.attach(this);
        assignmentPresenter.setupWeekScroller(horizontalCalendar);
        assignmentPresenter.bottomNavigationViewSetup(bottomNavigationViewEx);
        assignmentPresenter.setupShowsRecyclerView(assignmentRecyclerView, emptyRelativeLayout);

        backButtonOnToolbar(AssignmentActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        assignmentPresenter.detach();
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
    public void showWeekScroller(HorizontalCalendar horizontalCalendar) {

        /* end after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);


        /* start before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.weekScrollerView)
                .startDate(startDate.getTime())
                .endDate(endDate.getTime())
                .datesNumberOnScreen(NUMBER_OF_DATES_ON_SCREEN)
                .configure()
                .sizeTopText(12)
                .colorTextTop(ContextCompat.getColor(mContext, R.color.heading)
                        , ContextCompat.getColor(mContext, R.color.black_baby))
                .sizeMiddleText(15)
                .colorTextMiddle(ContextCompat.getColor(mContext, R.color.black_baby)
                        , ContextCompat.getColor(mContext, R.color.black_baby))
                .sizeBottomText(11)
                .colorTextBottom(ContextCompat.getColor(mContext, R.color.heading)
                        , ContextCompat.getColor(mContext, R.color.black_baby))
                .selectedDateBackground(ContextCompat.getDrawable(mContext, R.drawable.indicator_assignment))
                .selectorColor(ContextCompat.getColor(mContext, android.R.color.transparent))
                .end()
                .build();

        assignmentPresenter.setSetupSelectedListener(horizontalCalendar);

    }

    @Override
    public void showSelectedDate(HorizontalCalendar horizontalCalendar) {

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Date date, int position) {

            }

            @Override
            public void onCalendarScroll(HorizontalCalendarView calendarView, int dx, int dy) {

            }

            @Override
            public boolean onDateLongClicked(Date date, int position) {
                return true;
            }
        });

    }

    @Override
    public void showRecyclerView() {
        assignmentRecyclerView.setAdapter(mAssignmentRecyclerAdapter);
        assignmentPresenter.populateRecyclerView(mAssignmentArrayList);
    }

    @Override
    public void updateAdapter() {
        mAssignmentRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        Timber.e(message);
    }
}
