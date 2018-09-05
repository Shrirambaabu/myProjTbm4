package com.freshlancers.sws.ui.fragments.paymentCurrent;

import android.widget.RelativeLayout;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.ui.models.Payment;
import com.freshlancers.sws.utils.EmptyRecyclerView;

import java.util.List;

/**
 * Created by Leon on 25-12-17.
 */

public interface PaymentCurrentFragmentContract {


    interface Presenter extends BaseMvpPresenter<PaymentCurrentFragmentContract.View> {

        void setupShowsRecyclerView(EmptyRecyclerView paymentCurrentRecyclerView, RelativeLayout emptyView);

        void populateRecyclerView(List<Payment> events);

    }

    // Action callbacks. Activity/Fragment will implement
    interface View {

        void showRecyclerView();

        void updateAdapter();

        void showError(String message);
    }


}
