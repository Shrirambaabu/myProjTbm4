package com.freshlancers.sws.ui.recyclerAdapter.payment;

import android.content.Context;
import android.graphics.Color;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.models.Payment;

import java.util.ArrayList;

/**
 * Created by Leon on 25-12-17.
 */

public class PaymentListPresenter implements PaymentContract.Presenter {

    private Context context;
    private ArrayList<Payment> payments;

    public PaymentListPresenter(Context context, ArrayList<Payment> payments) {
        this.context = context;
        this.payments = payments;
    }

    @Override
    public int getItemCount() {
        return (null != payments ? payments.size() : 0);
    }

    @Override
    public void bindEventRow(int position, PaymentContract.PaymentRowView rowView) {
        Payment payment = payments.get(position);

        rowView.setPaymentName(payment.getPaymentName());

        rowView.setNotificationTime(payment.getNotificationTime());

        rowView.setDueDate(payment.getDueDate());

        rowView.setPaymentAmount(payment.getPaymentAmount());

        rowView.setPaymentStatus(payment.getPaymentStatus());

        if (payment.getPaymentStatus().equals(context.getString(R.string.done))) {
            rowView.setPaymentStatusColor(Color.parseColor("#56DF6F"));
        } else {
            rowView.setPaymentStatusColor(Color.parseColor("#dd4437"));
        }


    }
}
