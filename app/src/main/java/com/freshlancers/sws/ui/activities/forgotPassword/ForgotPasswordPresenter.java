package com.freshlancers.sws.ui.activities.forgotPassword;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;

import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.activities.forgotPasswordSuccess.ForgotPasswordSuccessActivity;
import com.freshlancers.sws.ui.activities.home.HomeActivity;

/**
 * Created by Leon on 29-12-17.
 */

public class ForgotPasswordPresenter extends BasePresenter<ForgotActivityContract.View> implements ForgotActivityContract.Presenter {
    private Context context;

    public ForgotPasswordPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void checkPasswords(TextInputLayout passwordTextInputLayout, TextInputLayout confirmPasswordTextInputLayout,
                               TextInputLayout oldPasswordTextInputLayout) {
        if (passwordTextInputLayout.getEditText().getText().toString()
                .equals(confirmPasswordTextInputLayout.getEditText().getText().toString())
                && oldPasswordTextInputLayout.getEditText().getText().toString().length() > 3) {
            getView().passwordChangedSuccessFully();
        } else if (!passwordTextInputLayout.getEditText().getText().toString().trim()
                .equals(confirmPasswordTextInputLayout.getEditText().getText().toString().toLowerCase())) {
            getView().showPasswordNotMatchingError();
        } else if (oldPasswordTextInputLayout.getEditText().getText().toString().length() < 3) {
            getView().showOldPasswordError();
        }
    }

    @Override
    public void success(Activity activity) {
        Intent loginIntent = new Intent(activity, ForgotPasswordSuccessActivity.class);
        loginIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(loginIntent);
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
