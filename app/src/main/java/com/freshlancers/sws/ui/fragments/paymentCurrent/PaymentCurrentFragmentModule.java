package com.freshlancers.sws.ui.fragments.paymentCurrent;

import android.content.Context;

import com.freshlancers.sws.base.FragmentContext;
import com.freshlancers.sws.base.PerFragmentScope;
import com.freshlancers.sws.ui.recyclerAdapter.payment.PaymentListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.payment.PaymentRecyclerAdapter;
import com.freshlancers.sws.ui.models.Payment;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 25-12-17.
 */
@Module(includes = {FragmentContext.class})
@PerFragmentScope
public class PaymentCurrentFragmentModule {

    @Provides
    @PerFragmentScope
    PaymentCurrentFragmentPresenter providesPaymentCurrentFragmentPresenter(Context context) {
        return new PaymentCurrentFragmentPresenter(context);
    }

    @Provides
    @PerFragmentScope
    ArrayList<Payment> providesPaymentCurrentArrayList() {
        return new ArrayList<>();
    }

    @Provides
    @PerFragmentScope
    PaymentListPresenter providesPaymentCurrentFragmentListPresenter(Context context, ArrayList<Payment> currentArrayList) {
        return new PaymentListPresenter(context, currentArrayList);
    }

    @Provides
    @PerFragmentScope
    PaymentRecyclerAdapter providesPaymentCurrentRecyclerAdapter(PaymentListPresenter currentFragmentListPresenter) {
        return new PaymentRecyclerAdapter(currentFragmentListPresenter);
    }

}
