package com.freshlancers.sws.ui.activities.calender;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;
import com.freshlancers.sws.ui.models.CalendarEvents;
import com.freshlancers.sws.ui.models.TimeTable;
import com.freshlancers.sws.ui.recyclerAdapter.calendar.CalendarEventsListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.calendar.CalendarEventsRecyclerAdapter;
import com.freshlancers.sws.ui.recyclerAdapter.calendar.TimeTableListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.calendar.TimeTableRecyclerAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 28-12-17.
 */
@Module(includes = {ActivityContext.class})
@PerActivityScope
class CalendarModule {

    @Provides
    @PerActivityScope
    ArrayList<TimeTable> providesTimeTables() {
        return new ArrayList<>();
    }

    @Provides
    @PerActivityScope
    ArrayList<CalendarEvents> providesCalendarEvents() {
        return new ArrayList<>();
    }

    @Provides
    @PerActivityScope
    CalendarPresenter provideCalendarPresenter(Context context) {
        return new CalendarPresenter(context);
    }

    @Provides
    @PerActivityScope
    CalendarEventsListPresenter providesCalendarEventsListPresenter(Context context, ArrayList<CalendarEvents> calendarEvents) {
        return new CalendarEventsListPresenter(context, calendarEvents);
    }

    @Provides
    @PerActivityScope
    TimeTableListPresenter providesTimeTableListPresenter(Context context, ArrayList<TimeTable> timeTables) {
        return new TimeTableListPresenter(context, timeTables);
    }

    @Provides
    @PerActivityScope
    CalendarEventsRecyclerAdapter providesCalendarEventsRecyclerAdapter(CalendarEventsListPresenter calendarEventsListPresenter) {
        return new CalendarEventsRecyclerAdapter(calendarEventsListPresenter);
    }

    @Provides
    @PerActivityScope
    TimeTableRecyclerAdapter providesTimeTableRecyclerAdapter(TimeTableListPresenter timeTableListPresenter) {
        return new TimeTableRecyclerAdapter(timeTableListPresenter);
    }

}
