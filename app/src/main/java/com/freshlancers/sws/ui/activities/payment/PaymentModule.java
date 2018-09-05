package com.freshlancers.sws.ui.activities.payment;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;
import com.freshlancers.sws.ui.fragments.paymentCurrent.PaymentCurrentFragment;
import com.freshlancers.sws.ui.fragments.paymentHistory.PaymentHistoryFragment;
import com.freshlancers.sws.utils.SectionsStatePagerAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 25-12-17.
 */
@Module(includes = {ActivityContext.class})
@PerActivityScope
public class PaymentModule {

    PaymentActivity paymentActivity;

    public PaymentModule(PaymentActivity paymentActivity) {
        this.paymentActivity = paymentActivity;
    }

    @Provides
    @PerActivityScope
    PaymentPresenter providePaymentPresenter(Context context) {
        return new PaymentPresenter(context);
    }

    @Provides
    @PerActivityScope
    SectionsStatePagerAdapter providesSectionsStatePagerAdapter() {
        return new SectionsStatePagerAdapter(paymentActivity.getSupportFragmentManager());
    }

    @Provides
    @PerActivityScope
    PaymentCurrentFragment providesPaymentCurrentFragment() {
        return new PaymentCurrentFragment();
    }

    @Provides
    @PerActivityScope
    PaymentHistoryFragment providesPaymentHistoryFragment() {
        return new PaymentHistoryFragment();
    }

}
