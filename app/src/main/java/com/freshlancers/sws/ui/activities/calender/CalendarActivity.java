package com.freshlancers.sws.ui.activities.calender;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.ui.models.CalendarEvents;
import com.freshlancers.sws.ui.models.TimeTable;
import com.freshlancers.sws.ui.recyclerAdapter.calendar.CalendarEventsListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.calendar.CalendarEventsRecyclerAdapter;
import com.freshlancers.sws.ui.recyclerAdapter.calendar.TimeTableListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.calendar.TimeTableRecyclerAdapter;
import com.freshlancers.sws.utils.DateUtils;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;
import static com.freshlancers.sws.utils.Utils.setCheckable;

public class CalendarActivity extends AppCompatActivity implements CalendarContract.View {

    private static CalendarDay calendarDay;
    @BindView(R.id.recycler_view_empty)
    EmptyRecyclerView timeTableRmptyRecyclerView;
    @BindView(R.id.empty_view)
    RelativeLayout emptyView;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationView;
    @BindView(R.id.compact_calendar_view)
    MaterialCalendarView materialCalendarView;
    @BindView(R.id.recycler_view)
    RecyclerView eventsRecyclerView;
    @BindView(R.id.selectedDate)
    TextView selectedDateTextView;
    @BindView(R.id.events)
    TextView events;
    @Inject
    CalendarPresenter calendarPresenter;
    @Inject
    ArrayList<CalendarEvents> calendarEventsArrayList;
    @Inject
    ArrayList<TimeTable> timeTableArrayList;
    @Inject
    CalendarEventsListPresenter calendarEventsListPresenter;
    @Inject
    CalendarEventsRecyclerAdapter calendarEventsRecyclerAdapter;
    @Inject
    TimeTableListPresenter timeTableListPresenter;
    @Inject
    TimeTableRecyclerAdapter timeTableRecyclerAdapter;
    private Context mContext = CalendarActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        ButterKnife.bind(this);

        DaggerCalendarComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        calendarPresenter.attach(this);
        calendarPresenter.bottomNavigationViewSetup(bottomNavigationView);
        calendarPresenter.setupCalendar(materialCalendarView);
        calendarPresenter.setupEventRecyclerView(eventsRecyclerView);
        calendarPresenter.setupTimeTableRecyclerView(timeTableRmptyRecyclerView, emptyView);

        backButtonOnToolbar(CalendarActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        calendarPresenter.detach();
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
    public void viewCalender() {
        calendarPresenter.setDateChangedListener(materialCalendarView);
    }

    @Override
    public void setSelectedDateOnTimeTableHeader(CalendarDay calendarDay) {
        CalendarActivity.calendarDay = calendarDay;
        selectedDateTextView.setText(DateUtils.formatDayMonthDateYear(calendarDay.getCalendar()));
    }

    @Override
    public void showEventsRecyclerView() {
        eventsRecyclerView.setAdapter(calendarEventsRecyclerAdapter);
        calendarPresenter.populateEventRecyclerView(calendarEventsArrayList, calendarDay);
    }

    @Override
    public void updateEventsAdapter() {
        calendarEventsRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void hideEventsHeading() {
        events.setVisibility(View.GONE);
    }

    @Override
    public void showEventsHeading() {
        events.setVisibility(View.VISIBLE);
    }

    @Override
    public void showTimeTableHeading() {
        selectedDateTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTimeTableHeading() {
        selectedDateTextView.setVisibility(View.GONE);
    }

    @Override
    public void showTimeTableRecyclerView() {
        timeTableRmptyRecyclerView.setAdapter(timeTableRecyclerAdapter);
        calendarPresenter.populateTimeTableRecyclerView(timeTableArrayList, calendarDay);
    }

    @Override
    public void updateTimeTableAdapter() {
        timeTableRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {

    }
}
