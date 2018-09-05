package com.freshlancers.sws.ui.activities.payment;

import android.support.v4.view.ViewPager;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.ui.fragments.paymentCurrent.PaymentCurrentFragment;
import com.freshlancers.sws.ui.fragments.paymentHistory.PaymentHistoryFragment;
import com.freshlancers.sws.utils.SectionsStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Leon on 20-12-17.
 */

public interface PaymentContract {

    interface Presenter extends BaseMvpPresenter<PaymentContract.View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

        void setupViewPager(ViewPager viewPager, SectionsStatePagerAdapter adapter, PaymentCurrentFragment paymentCurrentFragment, PaymentHistoryFragment paymentHistoryFragment);
    }

    // Action callbacks. Activity/Fragment will implement
    interface View {

        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);

        void showTabLayout();

        void showError(String message);

    }

}
