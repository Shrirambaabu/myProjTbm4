package com.freshlancers.sws.ui.activities.forgotPassword;

import android.app.Activity;
import android.support.design.widget.TextInputLayout;

import com.freshlancers.sws.base.BaseMvpPresenter;

/**
 * Created by Leon on 29-12-17.
 */

public interface ForgotActivityContract {

    interface Presenter extends BaseMvpPresenter<ForgotActivityContract.View> {

        void checkPasswords(TextInputLayout passwordTextInputLayout, TextInputLayout confirmPasswordTextInputLayout,TextInputLayout oldPasswordTextInputLayout);

        void success(Activity activity);

    }

    interface View {

        void showPasswordNotMatchingError();

        void showOldPasswordError();

        void passwordChangedSuccessFully();

    }

}
