package com.freshlancers.sws.ui.recyclerAdapter.payment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.freshlancers.sws.R;


/**
 * Created by Ashith VL on 12/1/2017.
 */

public class PaymentRecyclerAdapter extends RecyclerView.Adapter<PaymentHolder> {

    private static final String TAG = "NotificationRecyclerAda";
    PaymentListPresenter currentFragmentListPresenter;

    public PaymentRecyclerAdapter(PaymentListPresenter currentFragmentListPresenter) {
        this.currentFragmentListPresenter = currentFragmentListPresenter;
    }

    @Override
    public PaymentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PaymentHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_payment, parent, false), currentFragmentListPresenter);
    }

    @Override
    public void onBindViewHolder(PaymentHolder holder, int position) {
        currentFragmentListPresenter.bindEventRow(position, holder);
    }

    @Override
    public int getItemCount() {
        return currentFragmentListPresenter.getItemCount();
    }

}
