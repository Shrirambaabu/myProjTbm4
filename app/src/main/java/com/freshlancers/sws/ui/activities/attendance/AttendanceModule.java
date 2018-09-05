package com.freshlancers.sws.ui.activities.attendance;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ADMIN on 12/28/2017.
 */
@Module(includes = ActivityContext.class)
@PerActivityScope
class AttendanceModule {

    @Provides
    @PerActivityScope
    AttendancePresenter providesAssignmentPresenter(Context context) {
        return new AttendancePresenter(context);
    }
}
