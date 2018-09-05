package com.freshlancers.sws.ui.activities.profile;

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
class ProfileModule {

    @Provides
    @PerActivityScope
    ProfilePresenter providesProfilePresenter(Context context) {
        return new ProfilePresenter(context);
    }

}
