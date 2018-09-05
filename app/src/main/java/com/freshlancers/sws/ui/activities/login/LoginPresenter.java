package com.freshlancers.sws.ui.activities.login;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;

import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.activities.home.HomeActivity;

/**
 * Created by Leon on 28-12-17.
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    private Context context;

    LoginPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void validateLogin(TextInputLayout usernameInputLayout, TextInputLayout passwordTextInputLayout) {
        if (usernameInputLayout.getEditText().getText().toString().length() > 3
                && passwordTextInputLayout.getEditText().getText().toString().length() > 3) {
            getView().loginSuccessful();
        } else if (usernameInputLayout.getEditText().getText().toString().length() < 3) {
            getView().showUsernameError();
        } else if (passwordTextInputLayout.getEditText().getText().toString().length() < 3) {
            getView().showPasswordError();
        }
    }

    @Override
    public void validateForgetPassword(TextInputLayout usernameTextInputLayout) {
        if (usernameTextInputLayout.getEditText().getText().toString().length() > 3) {
            getView().forgotPasswordSuccess();
        } else {
            getView().showPasswordError();
        }
    }

    @Override
    public void login(Activity activity) {
        Intent loginIntent = new Intent(activity, HomeActivity.class);
        activity.startActivity(loginIntent);
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void dialogForgetPassword(Activity activity) {
        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setTitle("Success!");
        alertDialog.setMessage("Please contact the Administrator, to get your new password");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                (dialog, which) -> dialog.dismiss());
        alertDialog.show();
    }
}
