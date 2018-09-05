package com.freshlancers.sws.ui.activities.assignment;

import android.widget.RelativeLayout;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.ui.models.Assignment;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;

/**
 * Created by Leon on 26-12-17.
 */

interface AssignmentContract {

    interface Presenter extends BaseMvpPresenter<AssignmentContract.View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

        void setupWeekScroller(HorizontalCalendar horizontalCalendar);

        void setSetupSelectedListener(HorizontalCalendar horizontalCalendar);

        void setupShowsRecyclerView(EmptyRecyclerView eventsRecyclerView, RelativeLayout emptyRelativeLayout);

        void populateRecyclerView(List<Assignment> events);
    }

    // Action callbacks. Activity/Fragment will implement
    interface View {

        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);

        void showWeekScroller(HorizontalCalendar horizontalCalendar);

        void showSelectedDate(HorizontalCalendar horizontalCalendar);

        void showRecyclerView();

        void updateAdapter();

        void showError(String message);

    }
}