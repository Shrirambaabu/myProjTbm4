package com.freshlancers.sws.ui.activities.forgotPassword;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 29-12-17.
 */
@Module(includes = {ActivityContext.class})
@PerActivityScope
public class ForgotPasswordModule {

    @PerActivityScope
    @Provides
    ForgotPasswordPresenter providesForgotPasswordPresenter(Context context){
        return new ForgotPasswordPresenter(context);
    }

}
