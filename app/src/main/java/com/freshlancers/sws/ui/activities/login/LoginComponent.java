package com.freshlancers.sws.ui.activities.login;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 28-12-17.
 */
@Component(modules = {LoginModule.class})
@PerActivityScope
public interface LoginComponent {

    void inject(LoginActivity loginActivity);

}
