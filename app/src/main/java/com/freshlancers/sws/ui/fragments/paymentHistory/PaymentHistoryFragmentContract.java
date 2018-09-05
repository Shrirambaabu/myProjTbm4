package com.freshlancers.sws.ui.fragments.paymentHistory;

import android.widget.RelativeLayout;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.ui.models.Payment;
import com.freshlancers.sws.utils.EmptyRecyclerView;

import java.util.List;

/**
 * Created by Leon on 25-12-17.
 */

public interface PaymentHistoryFragmentContract {

    interface Presenter extends BaseMvpPresenter<PaymentHistoryFragmentContract.View> {

        void setupShowsRecyclerView(EmptyRecyclerView emptyRecyclerView, RelativeLayout emptyView);

        void populateRecyclerView(List<Payment> events);

    }

    // Action callbacks. Activity/Fragment will implement
    interface View {

        void showRecyclerView();

        void updateAdapter();

        void showError(String message);
    }


}
