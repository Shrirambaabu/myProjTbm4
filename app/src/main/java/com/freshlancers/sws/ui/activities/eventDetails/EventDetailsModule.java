package com.freshlancers.sws.ui.activities.eventDetails;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 22-12-17.
 */
@Module(includes = ActivityContext.class)
@PerActivityScope
public class EventDetailsModule {

    @Provides
    @PerActivityScope
    EventDetailsPresenter providesEventDetailsPresenter(Context context) {
        return new EventDetailsPresenter(context);
    }
}
