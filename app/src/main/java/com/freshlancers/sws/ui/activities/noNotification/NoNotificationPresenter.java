package com.freshlancers.sws.ui.activities.noNotification;

import android.content.Context;

import com.freshlancers.sws.base.BasePresenter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 20-12-17.
 */

public class NoNotificationPresenter extends BasePresenter<NoNotificationContract.View> implements NoNotificationContract.Presenter {

    private Context context;

    public NoNotificationPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
    }
}
