package com.freshlancers.sws.base;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 28-12-17.
 */
@Module
@PerActivityScope
public class ActivityContext {
    private Context context;

    public ActivityContext(Context context) {
        this.context = context;
    }

    @PerActivityScope
    @Provides
    public Context getContext() {
        return context;
    }
}
