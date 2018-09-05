package com.freshlancers.sws.ui.activities.home;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 22-12-17.
 */
@Module(includes = {ActivityContext.class})
@PerActivityScope
public class HomeModule {

    @Provides
    @PerActivityScope
    HomePresenter providesHomePresenter(Context context) {
        return new HomePresenter(context);
    }

}
