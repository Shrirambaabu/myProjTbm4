package com.freshlancers.sws.ui.activities.calender.decorators;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Date;

/**
 * Created by Leon on 27-12-17.
 */

public class ToDayDecorator implements DayViewDecorator {

    private CalendarDay date;

    public ToDayDecorator() {
        date = CalendarDay.today();
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return date != null && day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new StyleSpan(Typeface.BOLD));
        view.addSpan(new RelativeSizeSpan(1.3f));
        view.addSpan(new ForegroundColorSpan(Color.parseColor("#61a1d1")));
    }

    public void setDate(Date date) {
        this.date = CalendarDay.from(date);
    }
}