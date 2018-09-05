package com.freshlancers.sws.ui.activities.attendance.decorators;

import android.content.Context;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import timber.log.Timber;

/**
 * Created by ADMIN on 12/27/2017.
 */

public class AttendanceDecorator implements DayViewDecorator {

    private final Calendar calendar = Calendar.getInstance();
    private HashSet<CalendarDay> dates;
    private Context context;
    private int drawable;

    public AttendanceDecorator(Context context, Collection<CalendarDay> dates, int drawable) {
        this.context = context;
        this.drawable = drawable;
        this.dates = new HashSet<>(dates);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        return dates.contains(day) || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(context.getResources().getDrawable(drawable));
    }
}