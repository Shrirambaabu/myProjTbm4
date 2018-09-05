package com.freshlancers.sws.ui.recyclerAdapter.notification;

/**
 * Created by Leon on 21-12-17.
 */

public class NotificationAdapterContract {

    interface Presenter {

        int getItemCount();

        void bindEventRow(int position, NotificationRowView holder);

        void onItemRemove(int position);
    }

    interface NotificationRowView {

        void setTitle(String title);

        void setDescription(String description);

        void setTimeAgo(String timeAgo);

        void setHeading(String heading);

    }

}
