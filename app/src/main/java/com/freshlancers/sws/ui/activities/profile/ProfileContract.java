package com.freshlancers.sws.ui.activities.profile;

import android.widget.PopupWindow;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Leon on 18-12-17.
 */

public interface ProfileContract {

    interface Presenter extends BaseMvpPresenter<ProfileContract.View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

        void popupDisplay(android.view.View view);
    }

    // Action callbacks. Activity/Fragment will implement
    interface View {
        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);

        void viewPopUp(PopupWindow popupWindow, android.view.View view);
    }

}
