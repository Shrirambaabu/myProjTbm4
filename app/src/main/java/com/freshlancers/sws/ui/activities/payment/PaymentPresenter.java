package com.freshlancers.sws.ui.activities.payment;

import android.content.Context;
import android.support.v4.view.ViewPager;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.fragments.paymentCurrent.PaymentCurrentFragment;
import com.freshlancers.sws.ui.fragments.paymentHistory.PaymentHistoryFragment;
import com.freshlancers.sws.utils.SectionsStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 20-12-17.
 */

public class PaymentPresenter extends BasePresenter<PaymentContract.View> implements PaymentContract.Presenter {

    private Context context;

    public PaymentPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
    }

    @Override
    public void setupViewPager(ViewPager viewPager, SectionsStatePagerAdapter adapter, PaymentCurrentFragment paymentCurrentFragment, PaymentHistoryFragment paymentHistoryFragment) {
        adapter.addFragment(paymentCurrentFragment, context.getString(R.string.current));
        adapter.addFragment(paymentHistoryFragment, context.getString(R.string.history));
        viewPager.setAdapter(adapter);
        getView().showTabLayout();
    }

}
