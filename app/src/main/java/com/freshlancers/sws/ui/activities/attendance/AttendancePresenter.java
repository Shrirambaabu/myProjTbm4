package com.freshlancers.sws.ui.activities.attendance;

import android.content.Context;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.services.DataService;
import com.freshlancers.sws.ui.activities.attendance.decorators.AttendanceDecorator;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import timber.log.Timber;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by ADMIN on 12/28/2017.
 */

public class AttendancePresenter extends BasePresenter<AttendanceContract.View> implements AttendanceContract.Presenter {
    private Context mContext;

    AttendancePresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
    }

    @Override
    public void addDecorator(MaterialCalendarView materialCalendarView, Context context) {

        ArrayList<CalendarDay> presentDays = DataService.getAttendanceDays("Present");
        ArrayList<CalendarDay> absentDays = DataService.getAttendanceDays("Absent");
        ArrayList<CalendarDay> lateDays = DataService.getAttendanceDays("Late");
        ArrayList<CalendarDay> excuseDays = DataService.getAttendanceDays("Excuse");
        ArrayList<CalendarDay> holidayDays = DataService.getAttendanceDays("Holiday");

        materialCalendarView.addDecorator(
                new AttendanceDecorator(mContext, presentDays, R.drawable.attendance_green_circle));
        materialCalendarView.addDecorator(
                new AttendanceDecorator(mContext, absentDays, R.drawable.attendance_red_circle));
        materialCalendarView.addDecorator(
                new AttendanceDecorator(mContext, lateDays, R.drawable.attendance_yellow_circle));
        materialCalendarView.addDecorator(
                new AttendanceDecorator(mContext, excuseDays, R.drawable.attendance_blue_circle));
        materialCalendarView.addDecorator(
                new AttendanceDecorator(mContext, holidayDays, R.drawable.attendance_gray_circle));

        getView().setPresent(String.valueOf(presentDays.size()));
        getView().setLeaves(String.valueOf(absentDays.size()));
        getView().setLate(String.valueOf(lateDays.size()));
        getView().setExcuse(String.valueOf(excuseDays.size()));

    }
}
