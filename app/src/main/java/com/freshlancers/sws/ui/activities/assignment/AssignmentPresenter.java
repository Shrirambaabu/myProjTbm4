package com.freshlancers.sws.ui.activities.assignment;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.models.Assignment;
import com.freshlancers.sws.ui.services.DataService;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 26-12-17.
 */

public class AssignmentPresenter extends BasePresenter<AssignmentContract.View> implements AssignmentContract.Presenter {

    private Context context;

    AssignmentPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
    }

    @Override
    public void setupWeekScroller(HorizontalCalendar horizontalCalendar) {
        getView().showWeekScroller(horizontalCalendar);
    }

    @Override
    public void setSetupSelectedListener(HorizontalCalendar horizontalCalendar) {
        getView().showSelectedDate(horizontalCalendar);
    }


    @Override
    public void setupShowsRecyclerView(EmptyRecyclerView eventsRecyclerView, RelativeLayout emptyRelativeLayout) {
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, resId);
        eventsRecyclerView.setLayoutAnimation(animation);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        eventsRecyclerView.setLayoutManager(mLayoutManager);
        eventsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        eventsRecyclerView.setHasFixedSize(true);
        eventsRecyclerView.setNestedScrollingEnabled(false);

        eventsRecyclerView.setEmptyView(emptyRelativeLayout);

        getView().showRecyclerView();
    }

    @Override
    public void populateRecyclerView(List<Assignment> assignments) {

        assignments.addAll(DataService.getAssignments());
        getView().updateAdapter();

    }
}
