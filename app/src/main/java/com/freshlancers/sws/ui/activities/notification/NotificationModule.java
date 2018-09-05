package com.freshlancers.sws.ui.activities.notification;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;
import com.freshlancers.sws.ui.recyclerAdapter.notification.NotificationListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.notification.NotificationRecyclerAdapter;
import com.freshlancers.sws.ui.models.Notification;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 22-12-17.
 */

@Module(includes = {ActivityContext.class})
@PerActivityScope
class NotificationModule {

    @Provides
    @PerActivityScope
    NotificationPresenter providesNotificationPresenter(Context context) {
        return new NotificationPresenter(context);
    }

    @Provides
    @PerActivityScope
    ArrayList<Notification> providesNotificationArrayList() {
        return new ArrayList<>();
    }

    @Provides
    @PerActivityScope
    NotificationListPresenter providesNotificationListPresenter(Context context, ArrayList<Notification> notificationArrayList) {
        return new NotificationListPresenter(context, notificationArrayList);
    }

    @Provides
    @PerActivityScope
    NotificationRecyclerAdapter providesEventsRecyclerAdapter(NotificationListPresenter notificationListPresenter) {
        return new NotificationRecyclerAdapter(notificationListPresenter);
    }

}
