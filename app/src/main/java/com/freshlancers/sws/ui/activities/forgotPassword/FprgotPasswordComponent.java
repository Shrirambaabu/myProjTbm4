package com.freshlancers.sws.ui.activities.forgotPassword;

import com.freshlancers.sws.base.PerActivityScope;
import com.freshlancers.sws.ui.activities.login.LoginActivity;
import com.freshlancers.sws.ui.activities.login.LoginModule;

import dagger.Component;

/**
 * Created by Leon on 28-12-17.
 */
@Component(modules = {ForgotPasswordModule.class})
@PerActivityScope
public interface FprgotPasswordComponent {

    void inject(ForgotPasswordActivity forgotPasswordActivity);

}
