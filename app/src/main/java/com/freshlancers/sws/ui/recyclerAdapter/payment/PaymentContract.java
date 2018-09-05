package com.freshlancers.sws.ui.recyclerAdapter.payment;

/**
 * Created by Leon on 21-12-17.
 */

public class PaymentContract {

    interface Presenter {

        int getItemCount();

        void bindEventRow(int position, PaymentRowView holder);

    }

    interface PaymentRowView {

        void setNotificationTime(String notificationTime);

        void setPaymentName(String paymentName);

        void setDueDate(String dueDate);

        void setPaymentAmount(String paymentAmount);

        void setPaymentStatus(String paymentStatus);

        void setPaymentStatusColor(int color);
    }

}
