package com.freshlancers.sws.ui.activities.eventDetails;

import android.content.Context;

import com.freshlancers.sws.base.BasePresenter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 22-12-17.
 */

public class EventDetailsPresenter extends BasePresenter<EventDetailsContract.View> implements EventDetailsContract.Presenter {

    private Context context;

    public EventDetailsPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
    }
}
