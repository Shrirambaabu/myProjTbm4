package com.freshlancers.sws.ui.activities.forgotPassword;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.EditText;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;

public class ForgotPasswordActivity extends AppCompatActivity implements ForgotActivityContract.View {

    @BindView(R.id.input_password)
    EditText inputPassword;
    @BindView(R.id.passwordWrapper)
    TextInputLayout passwordWrapper;
    @BindView(R.id.input_new_password)
    EditText inputNewPassword;
    @BindView(R.id.newPasswordWrapper)
    TextInputLayout newPasswordWrapper;
    @BindView(R.id.input_confirm_password)
    EditText inputConfirmPassword;
    @BindView(R.id.confirmPasswordWrapper)
    TextInputLayout confirmPasswordWrapper;
    @BindView(R.id.btn_confirm)
    AppCompatButton btnConfirm;
    @Inject
    ForgotPasswordPresenter forgotPasswordPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        ButterKnife.bind(this);

        DaggerFprgotPasswordComponent.builder()
                .activityContext(new ActivityContext(this))
                .build()
                .inject(this);

        forgotPasswordPresenter.attach(this);
        backButtonOnToolbar(ForgotPasswordActivity.this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        forgotPasswordPresenter.detach();
    }

    @OnClick(R.id.btn_confirm)
    public void onViewClicked() {
        forgotPasswordPresenter.checkPasswords(newPasswordWrapper, confirmPasswordWrapper, passwordWrapper);
    }

    @Override
    public void passwordChangedSuccessFully() {
        passwordWrapper.setErrorEnabled(false);
        newPasswordWrapper.setErrorEnabled(false);
        confirmPasswordWrapper.setErrorEnabled(false);
        forgotPasswordPresenter.success(this);
    }

    @Override
    public void showPasswordNotMatchingError() {
        newPasswordWrapper.setError(getString(R.string.password_didnt_match));
        confirmPasswordWrapper.setError(getString(R.string.password_didnt_match));
    }

    @Override
    public void showOldPasswordError() {
        passwordWrapper.setError(getString(R.string.not_a_valid_password));
    }

}
