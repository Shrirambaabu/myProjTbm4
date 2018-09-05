package com.freshlancers.sws.ui.activities.events;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;
import com.freshlancers.sws.ui.recyclerAdapter.event.EventsListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.event.EventsRecyclerAdapter;
import com.freshlancers.sws.ui.models.Events;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 22-12-17.
 */
@Module(includes = ActivityContext.class)
@PerActivityScope
class EventsModule {

    @Provides
    @PerActivityScope
    EventsPresenter providesEventsPresenter(Context context) {
        return new EventsPresenter(context);
    }

    @Provides
    @PerActivityScope
    ArrayList<Events> providesEventsArrayList() {
        return new ArrayList<>();
    }

    @Provides
    @PerActivityScope
    EventsListPresenter providesEventsListPresenter(Context context, ArrayList<Events> eventsList) {
        return new EventsListPresenter(context, eventsList);
    }

    @Provides
    @PerActivityScope
    EventsRecyclerAdapter providesEventsRecyclerAdapter(EventsListPresenter eventsListPresenter) {
        return new EventsRecyclerAdapter(eventsListPresenter);
    }

}
