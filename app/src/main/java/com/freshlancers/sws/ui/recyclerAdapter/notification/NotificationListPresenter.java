package com.freshlancers.sws.ui.recyclerAdapter.notification;

import android.content.Context;

import com.freshlancers.sws.ui.activities.notification.NotificationActivity;
import com.freshlancers.sws.ui.models.Notification;

import java.util.List;

/**
 * Created by Leon on 21-12-17.
 */

public class NotificationListPresenter implements NotificationAdapterContract.Presenter {

    private List<Notification> notificationList;
    private Context context;

    public NotificationListPresenter(Context context, List<Notification> notificationList) {
        this.notificationList = notificationList;
        this.context = context;
    }

    @Override
    public void bindEventRow(int position, NotificationAdapterContract.NotificationRowView rowView) {

        Notification notification = notificationList.get(position);

        rowView.setTitle(notification.getTitle());

        rowView.setDescription(notification.getDescription());

        rowView.setHeading(notification.getHeading());

        rowView.setTimeAgo(notification.getTimeAgo());

    }

    @Override
    public int getItemCount() {
        return (null != notificationList ? notificationList.size() : 0);
    }

    @Override
    public void onItemRemove(int position) {
        if (position != -1 && position < notificationList.size()) {
            notificationList.remove(position);
            ((NotificationActivity)context).updateAdapter(position);
        }
    }
}
