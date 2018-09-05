package com.freshlancers.sws.ui.activities.noNotification;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.ui.activities.notification.NotificationContract;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Leon on 20-12-17.
 */

public interface NoNotificationContract {

    interface Presenter extends BaseMvpPresenter<NoNotificationContract.View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

    }

    // Action callbacks. Activity/Fragment will implement
    interface View {
        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);
    }



}
