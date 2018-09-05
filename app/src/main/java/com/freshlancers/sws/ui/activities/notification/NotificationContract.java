package com.freshlancers.sws.ui.activities.notification;

import android.support.v7.widget.RecyclerView;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.ui.models.Notification;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

/**
 * Created by Leon on 18-12-17.
 */

public interface NotificationContract {

    interface Presenter extends BaseMvpPresenter<NotificationContract.View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

        void setupShowsRecyclerView(RecyclerView notificationRecyclerView);

        void populateRecyclerView(List<Notification> events);


    }

    // Action callbacks. Activity/Fragment will implement
    interface View {
        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);

        void showRecyclerView();

        void updateAdapter();

        void updateAdapter(int position);

        void showError(String message);
    }

}
