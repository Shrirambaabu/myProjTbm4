package com.freshlancers.sws.ui.activities.events;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.models.Events;
import com.freshlancers.sws.ui.services.DataService;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 20-12-17.
 */

public class EventsPresenter extends BasePresenter<EventsContract.View> implements EventsContract.Presenter {

    private Context context;

    public EventsPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
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

        eventsRecyclerView.setEmptyView(emptyRelativeLayout);

        getView().showRecyclerView();
    }

    @Override
    public void populateRecyclerView(List<Events> events) {

        events.addAll(DataService.getEvents());
//        events.clear();
        getView().updateAdapter();

    }
}
