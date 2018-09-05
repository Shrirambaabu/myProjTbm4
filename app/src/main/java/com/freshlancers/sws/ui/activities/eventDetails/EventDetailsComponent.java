package com.freshlancers.sws.ui.activities.eventDetails;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 22-12-17.
 */
@Component(modules = {EventDetailsModule.class})
@PerActivityScope
public interface EventDetailsComponent {

    void inject(EventDetailsActivity eventDetailsActivity);

}
