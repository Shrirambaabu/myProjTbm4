package com.freshlancers.sws.ui.activities.attendance;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by ADMIN on 12/28/2017.
 */
@Component(modules = {AttendanceModule.class})
@PerActivityScope
public interface AttendanceComponent {

    void inject(AttendanceActivity attendanceActivity);
}
