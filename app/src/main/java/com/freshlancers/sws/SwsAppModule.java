package com.freshlancers.sws;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 22-12-17.
 */
@Module
@SwsScope
public class SwsAppModule {
    Application mApplication;

    public SwsAppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @SwsScope
    Application provideApplication() {
        return mApplication;
    }
}
