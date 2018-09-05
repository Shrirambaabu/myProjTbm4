package com.freshlancers.sws.ui.activities.events;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 22-12-17.
 */
@Component(modules = {EventsModule.class})
@PerActivityScope
public interface EventsComponent {

    void inject(EventsActivity eventsActivity);

}
