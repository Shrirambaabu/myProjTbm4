package com.freshlancers.sws.ui.activities.noNotification;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 22-12-17.
 */
@Module(includes = {ActivityContext.class})
@PerActivityScope
class NoNotificationModule {

    @Provides
    @PerActivityScope
    NoNotificationPresenter providesNotificationPresenter(Context context) {
        return new NoNotificationPresenter(context);
    }

}
