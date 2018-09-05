package com.freshlancers.sws.ui.activities.calender;

import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.ui.models.CalendarEvents;
import com.freshlancers.sws.ui.models.TimeTable;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.List;

/**
 * Created by Leon on 28-12-17.
 */

public interface CalendarContract {

    interface Presenter extends BaseMvpPresenter<CalendarContract.View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

        void setupEventRecyclerView(RecyclerView eventsRecyclerView);

        void populateEventRecyclerView(List<CalendarEvents> calendarEvents, CalendarDay date);

        void setupTimeTableRecyclerView(EmptyRecyclerView eventsRecyclerView, RelativeLayout emptyRelativeLayout);

        void populateTimeTableRecyclerView(List<TimeTable> timeTables, CalendarDay date);

        void setupCalendar(MaterialCalendarView materialCalendarView);

        void setDateChangedListener(MaterialCalendarView materialCalendarView);
    }

    // Action callbacks. Activity/Fragment will implement
    interface View {

        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);

        void showEventsRecyclerView();

        void updateEventsAdapter();

        void showTimeTableRecyclerView();

        void updateTimeTableAdapter();

        void viewCalender();

        void setSelectedDateOnTimeTableHeader(CalendarDay date);

        void showError(String message);

        void hideEventsHeading();

        void showEventsHeading();

        void showTimeTableHeading();

        void hideTimeTableHeading();
    }

}
