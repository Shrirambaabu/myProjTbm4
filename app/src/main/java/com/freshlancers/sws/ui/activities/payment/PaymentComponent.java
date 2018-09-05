package com.freshlancers.sws.ui.activities.payment;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 25-12-17.
 */
@Component(modules = {PaymentModule.class})
@PerActivityScope
public interface PaymentComponent {

    void inject(PaymentActivity paymentActivity);

}
