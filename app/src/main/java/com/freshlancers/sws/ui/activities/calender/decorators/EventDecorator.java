package com.freshlancers.sws.ui.activities.calender.decorators;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineBackgroundSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import timber.log.Timber;

/**
 * Created by Leon on 27-12-17.
 */

public class EventDecorator implements DayViewDecorator {

    private int color;
    private HashSet<CalendarDay> dates;
    private Date date;

    public EventDecorator(int color, Collection<CalendarDay> dates) {
        this.color = color;
        this.dates = new HashSet<>(dates);
    }

    public EventDecorator(int color, Date date) {
        this.color = color;
        this.date = date;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        if (dates != null)
            return dates.contains(day);
        else
            return day.getDate().equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.BLACK));
        view.addSpan((LineBackgroundSpan) (canvas, paint, left, right, top, baseline, bottom, charSequence, start, end, lineNum) -> {
            if (color != 0) {
                paint.setColor(color);
            }
            paint.setAntiAlias(true);
            paint.setStrokeWidth(4);
            canvas.drawLine(left + bottom, bottom + 5, right - bottom, bottom + 5, paint);
        });
    }
}
