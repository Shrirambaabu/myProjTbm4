package com.freshlancers.sws.ui.recyclerAdapter.payment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.freshlancers.sws.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Leon on 25-12-17.
 */

public class PaymentHolder extends RecyclerView.ViewHolder implements PaymentContract.PaymentRowView {

    PaymentListPresenter fragmentListPresenter;

    @BindView(R.id.notificationDate)
    TextView notificationDateTextView;
    @BindView(R.id.paymentName)
    TextView paymentNameTextView;
    @BindView(R.id.paymentAmount)
    TextView paymentAmountTextView;
    @BindView(R.id.paymentDate)
    TextView paymentDateTextView;
    @BindView(R.id.paymentStatus)
    TextView paymentStatusTextView;

    PaymentHolder(View itemView, PaymentListPresenter fragmentListPresenter) {
        super(itemView);
        this.fragmentListPresenter = fragmentListPresenter;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setNotificationTime(String notificationTime) {
        notificationDateTextView.setText(notificationTime);
    }

    @Override
    public void setPaymentName(String paymentName) {
        paymentNameTextView.setText(paymentName);
    }

    @Override
    public void setDueDate(String dueDate) {
        paymentDateTextView.setText(dueDate);
    }

    @Override
    public void setPaymentAmount(String paymentAmount) {
        paymentAmountTextView.setText(paymentAmount);
    }

    @Override
    public void setPaymentStatus(String paymentStatus) {
        paymentStatusTextView.setText(paymentStatus);
    }

    @Override
    public void setPaymentStatusColor(int color) {
        paymentStatusTextView.setTextColor(color);
    }
}
