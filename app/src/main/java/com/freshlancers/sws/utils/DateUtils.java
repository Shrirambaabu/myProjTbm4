package com.freshlancers.sws.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Leon on 28-12-17.
 */

public class DateUtils {

    public static String formatDayMonthDateYear(Calendar calendar){

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMM dd, yyyy", Locale.getDefault());

        return sdf.format(calendar.getTime());
    }

}
