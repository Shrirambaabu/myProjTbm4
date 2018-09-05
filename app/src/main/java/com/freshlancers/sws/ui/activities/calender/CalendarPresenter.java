package com.freshlancers.sws.ui.activities.calender;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.activities.calender.decorators.EventDecorator;
import com.freshlancers.sws.ui.activities.calender.decorators.SelectedDateDecorator;
import com.freshlancers.sws.ui.activities.calender.decorators.ToDayDecorator;
import com.freshlancers.sws.ui.models.CalendarEvents;
import com.freshlancers.sws.ui.models.TimeTable;
import com.freshlancers.sws.ui.services.DataService;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 28-12-17.
 */

public class CalendarPresenter extends BasePresenter<CalendarContract.View> implements CalendarContract.Presenter {

    private final CalendarDay calendarDay;
    private Context context;

    CalendarPresenter(Context context) {
        this.context = context;

        calendarDay = CalendarDay.today();

    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);

    }

    @Override
    public void setupEventRecyclerView(RecyclerView eventsRecyclerView) {
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, resId);
        eventsRecyclerView.setLayoutAnimation(animation);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        eventsRecyclerView.setLayoutManager(mLayoutManager);
        eventsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        eventsRecyclerView.setNestedScrollingEnabled(false);
        eventsRecyclerView.setHasFixedSize(true);

        getView().showEventsRecyclerView();
    }

    @Override
    public void populateEventRecyclerView(List<CalendarEvents> calendarEvents, CalendarDay date) {

        calendarEvents.clear();
        calendarEvents.addAll(DataService.getCalenderEvents());

        getView().updateEventsAdapter();

        if (calendarEvents.size() > 0) {
            getView().showEventsHeading();
        } else {
            getView().hideEventsHeading();
        }

    }

    @Override
    public void setupTimeTableRecyclerView(EmptyRecyclerView timetableRecyclerView, RelativeLayout emptyRelativeLayout) {
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, resId);
        timetableRecyclerView.setLayoutAnimation(animation);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        timetableRecyclerView.setLayoutManager(mLayoutManager);
        timetableRecyclerView.setItemAnimator(new DefaultItemAnimator());
        timetableRecyclerView.setNestedScrollingEnabled(false);
        timetableRecyclerView.setHasFixedSize(true);
        timetableRecyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));

        timetableRecyclerView.setEmptyView(emptyRelativeLayout);

        getView().showTimeTableRecyclerView();
    }

    @Override
    public void populateTimeTableRecyclerView(List<TimeTable> timeTables, CalendarDay date) {

        timeTables.clear();
        timeTables.addAll(DataService.getTimeTable());
        getView().updateTimeTableAdapter();

        if (timeTables.size() > 0) {
            getView().showTimeTableHeading();
        } else {
            getView().hideTimeTableHeading();
        }

    }

    @Override
    public void setupCalendar(MaterialCalendarView materialCalendarView) {
        materialCalendarView.setSelectionMode(MaterialCalendarView.SELECTION_MODE_SINGLE);

        materialCalendarView.addDecorator(
                new EventDecorator(ContextCompat.getColor(context, R.color.indicator_selected), DataService.getDays()));

        materialCalendarView.addDecorator(new ToDayDecorator());
        getView().viewCalender();

        getView().setSelectedDateOnTimeTableHeader(calendarDay);
    }

    @Override
    public void setDateChangedListener(MaterialCalendarView materialCalendarView) {

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {

            private Date selectedDate;

            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

                getView().setSelectedDateOnTimeTableHeader(date);
                getView().showTimeTableRecyclerView();
                getView().showEventsRecyclerView();

                ArrayList<CalendarDay> days = DataService.getDays();
                for (int i = 0; i < days.size(); i++) {
                    if (selectedDate != null && !date.getDate().equals(selectedDate)) {
                        materialCalendarView.addDecorator(
                                new EventDecorator(ContextCompat.getColor(context, R.color.indicator_selected), selectedDate));
                    }
                    if (date.getDate().equals(days.get(i).getDate()) && selected) {
                        materialCalendarView.addDecorator(
                                new SelectedDateDecorator(ContextCompat.getColor(context, android.R.color.white), date.getDate()));
                        selectedDate = date.getDate();
                    }
                }
            }
        });

    }
}
