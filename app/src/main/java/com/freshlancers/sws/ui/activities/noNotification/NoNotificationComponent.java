package com.freshlancers.sws.ui.activities.noNotification;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 22-12-17.
 */
@Component(modules = {NoNotificationModule.class})
@PerActivityScope
public interface NoNotificationComponent {

    void inject(NoNotificationActivity noNotificationActivity);

}
