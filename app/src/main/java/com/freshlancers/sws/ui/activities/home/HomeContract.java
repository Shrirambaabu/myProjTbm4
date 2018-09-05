package com.freshlancers.sws.ui.activities.home;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Leon on 17-12-17.
 */

public interface HomeContract {

    interface Presenter extends BaseMvpPresenter<View> {

        void carouselViewSetUp(ViewPager mPager, CircleIndicator indicator);

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

        void onBackPress();
    }

    // Action callbacks. Activity/Fragment will implement
    interface View {

        void viewCarousel(PagerAdapter pagerAdapter, ViewPager mPager);

        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);
    }
}
