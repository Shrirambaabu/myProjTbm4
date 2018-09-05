package com.freshlancers.sws.ui.activities.calender.decorators;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import android.text.style.LineBackgroundSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Leon on 27-12-17.
 */

public class SelectedDateDecorator implements DayViewDecorator {

    private int color;
    private HashSet<CalendarDay> dates;
    private Date date;

    public SelectedDateDecorator(int color, Date date) {
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
        view.addSpan(new StyleSpan(Typeface.BOLD));
        view.addSpan(new ForegroundColorSpan(color));
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
