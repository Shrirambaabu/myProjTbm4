package com.freshlancers.sws.ui.activities.login;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 28-12-17.
 */
@Module(includes = {ActivityContext.class})
@PerActivityScope
public class LoginModule {

    @PerActivityScope
    @Provides
    LoginPresenter providesLoginPresenter(Context context){
        return new LoginPresenter(context);
    }

}
