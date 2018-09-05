package com.freshlancers.sws.ui.fragments.paymentHistory;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.models.Payment;
import com.freshlancers.sws.ui.services.DataService;
import com.freshlancers.sws.utils.EmptyRecyclerView;

import java.util.List;

/**
 * Created by Leon on 25-12-17.
 */

public class PaymentHistoryFragmentPresenter extends BasePresenter<PaymentHistoryFragmentContract.View> implements PaymentHistoryFragmentContract.Presenter {

    private Context context;

    PaymentHistoryFragmentPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void setupShowsRecyclerView(EmptyRecyclerView paymentCurrentRecyclerView, RelativeLayout emptyView) {

        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, resId);
        paymentCurrentRecyclerView.setLayoutAnimation(animation);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        paymentCurrentRecyclerView.setLayoutManager(mLayoutManager);
        paymentCurrentRecyclerView.setItemAnimator(new DefaultItemAnimator());
        paymentCurrentRecyclerView.setHasFixedSize(true);

        paymentCurrentRecyclerView.setEmptyView(emptyView);

        getView().showRecyclerView();
    }

    @Override
    public void populateRecyclerView(List<Payment> paymentList) {
        paymentList.addAll(DataService.getHistoryPaymentList());
        getView().updateAdapter();
    }
}
