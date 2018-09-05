package com.freshlancers.sws.ui.activities.notification;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 22-12-17.
 */
@Component(modules = {NotificationModule.class})
@PerActivityScope
interface NotificationComponent {

    void inject(NotificationActivity notificationActivity);

}
