package com.freshlancers.sws.ui.activities.calender;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 22-12-17.
 */
@Component(modules = {CalendarModule.class})
@PerActivityScope
public interface CalendarComponent {

    void inject(CalendarActivity calendarActivity);

}
