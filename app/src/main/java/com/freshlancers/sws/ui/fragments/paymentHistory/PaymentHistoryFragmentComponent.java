package com.freshlancers.sws.ui.fragments.paymentHistory;

import com.freshlancers.sws.base.PerFragmentScope;

import dagger.Component;

/**
 * Created by Leon on 25-12-17.
 */
@Component(modules = { PaymentHistoryFragmentModule.class})
@PerFragmentScope
public interface PaymentHistoryFragmentComponent {

    void inject(PaymentHistoryFragment paymentHistoryFragment);

}
