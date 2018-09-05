package com.freshlancers.sws.ui.activities.attendance;

import android.content.Context;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

/**
 * Created by ADMIN on 12/28/2017.
 */

interface AttendanceContract {


    interface Presenter extends BaseMvpPresenter<View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

        void addDecorator(MaterialCalendarView  materialCalendarView,Context context);
    }

    interface View {

        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);

        void setPresent(String present);

        void setLeaves(String leaves);

        void setLate(String late);

        void setExcuse(String excuse);
    }
}
