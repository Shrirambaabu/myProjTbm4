package com.freshlancers.sws.ui.fragments.paymentCurrent;

import com.freshlancers.sws.base.PerFragmentScope;

import dagger.Component;

/**
 * Created by Leon on 25-12-17.
 */
@Component(modules = {PaymentCurrentFragmentModule.class})
@PerFragmentScope
public interface PaymentCurrentFragmentComponent {

    void inject(PaymentCurrentFragment paymentCurrentFragment);

}
