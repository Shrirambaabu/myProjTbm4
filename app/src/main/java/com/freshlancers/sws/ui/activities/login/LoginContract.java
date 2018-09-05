package com.freshlancers.sws.ui.activities.login;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.base.BasePresenter;

/**
 * Created by Leon on 28-12-17.
 */

public interface LoginContract {

    interface Presenter extends BaseMvpPresenter<LoginContract.View> {

        void validateLogin(TextInputLayout usernameInputLayout, TextInputLayout passwordTextInputLayout);

        void validateForgetPassword(TextInputLayout usernameTextInputLayout);

        void login(Activity activity);

        void dialogForgetPassword(Activity activity);

    }

    interface View {

        void loginSuccessful();

        void forgotPasswordSuccess();

        void showUsernameError();

        void showPasswordError();

    }

}
