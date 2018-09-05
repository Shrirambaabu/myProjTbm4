package com.freshlancers.sws.ui.models;

/**
 * Created by Leon on 25-12-17.
 */

public class Payment {

    String PaymentName;

    String NotificationTime;

    String dueDate;

    String paymentAmount;

    String paymentStatus;

    public Payment(String paymentName, String notificationTime, String dueDate, String paymentAmount, String paymentStatus) {
        PaymentName = paymentName;
        NotificationTime = notificationTime;
        this.dueDate = dueDate;
        this.paymentAmount = paymentAmount;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentName() {
        return PaymentName;
    }

    public void setPaymentName(String paymentName) {
        PaymentName = paymentName;
    }

    public String getNotificationTime() {
        return NotificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        NotificationTime = notificationTime;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
