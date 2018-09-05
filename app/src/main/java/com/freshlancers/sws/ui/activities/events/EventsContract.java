package com.freshlancers.sws.ui.activities.events;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.ui.activities.home.HomeContract;
import com.freshlancers.sws.ui.models.Events;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Leon on 20-12-17.
 */

public interface EventsContract {

    interface Presenter extends BaseMvpPresenter<EventsContract.View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

        void setupShowsRecyclerView(EmptyRecyclerView eventsRecyclerView, RelativeLayout emptyRelativeLayout);

        void populateRecyclerView(List<Events> events);
    }

    // Action callbacks. Activity/Fragment will implement
    interface View {

        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);

//        void showEmptyRecyclerView();

        void showRecyclerView();

        void updateAdapter();

        void showError(String message);

    }

}
