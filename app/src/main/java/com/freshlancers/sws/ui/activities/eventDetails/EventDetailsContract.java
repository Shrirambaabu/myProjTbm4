package com.freshlancers.sws.ui.activities.eventDetails;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Leon on 22-12-17.
 */

public interface EventDetailsContract {

    interface Presenter extends BaseMvpPresenter<View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

    }

    // Action callbacks. Activity/Fragment will implement
    interface View {

        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);
    }

}
