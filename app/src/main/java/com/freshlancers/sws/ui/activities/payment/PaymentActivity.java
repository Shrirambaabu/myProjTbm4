package com.freshlancers.sws.ui.activities.payment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.ui.fragments.paymentCurrent.PaymentCurrentFragment;
import com.freshlancers.sws.ui.fragments.paymentHistory.PaymentHistoryFragment;
import com.freshlancers.sws.utils.SectionsStatePagerAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;
import static com.freshlancers.sws.utils.Utils.setCheckable;

public class PaymentActivity extends AppCompatActivity implements PaymentContract.View {

    public static final int TAB_ONE = 0;
    public static final int TAB_TWO = 1;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.container)
    ViewPager pager;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationView;

    @Inject
    PaymentPresenter paymentPresenter;
    @Inject
    SectionsStatePagerAdapter adapter;
    @Inject
    PaymentCurrentFragment paymentCurrentFragment;
    @Inject
    PaymentHistoryFragment paymentHistoryFragment;

    private Context mContext = PaymentActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ButterKnife.bind(this);

        DaggerPaymentComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .paymentModule(new PaymentModule(this))
                .build()
                .inject(this);

        paymentPresenter.attach(this);

        paymentPresenter.setupViewPager(pager, adapter, paymentCurrentFragment, paymentHistoryFragment);

        paymentPresenter.bottomNavigationViewSetup(bottomNavigationView);

        backButtonOnToolbar(PaymentActivity.this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        paymentPresenter.detach();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
    }

    @Override
    public void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx) {

        enableNavigation(mContext, this, bottomNavigationViewEx);
        setCheckable(bottomNavigationViewEx, false);

        // add badge
        //Badge mBadge = addBadgeAt(mContext, 2, 12, bottomNavigationViewEx);
    }

    @Override
    public void showTabLayout() {
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public void showError(String message) {

    }
}
