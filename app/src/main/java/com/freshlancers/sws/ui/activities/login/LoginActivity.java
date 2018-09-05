package com.freshlancers.sws.ui.activities.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    @BindView(R.id.user_name)
    EditText userNameEditText;
    @BindView(R.id.usernameWrapper)
    TextInputLayout usernameWrapper;
    @BindView(R.id.input_password)
    EditText passwordEditText;
    @BindView(R.id.passwordWrapper)
    TextInputLayout passwordWrapper;
    @BindView(R.id.btn_login)
    AppCompatButton btnLogin;
    @BindView(R.id.forget_password)
    TextView forgetPasswordTextView;

    @Inject
    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        DaggerLoginComponent.builder()
                .activityContext(new ActivityContext(this))
                .build()
                .inject(this);

        loginPresenter.attach(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detach();
    }

    @OnClick({R.id.btn_login, R.id.forget_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                loginPresenter.validateLogin(usernameWrapper, passwordWrapper);
                break;
            case R.id.forget_password:
                loginPresenter.validateForgetPassword(usernameWrapper);
                break;
        }
    }

    @Override
    public void loginSuccessful() {
        usernameWrapper.setErrorEnabled(false);
        passwordWrapper.setErrorEnabled(false);
        loginPresenter.login(this);
    }

    @Override
    public void forgotPasswordSuccess() {
        usernameWrapper.setErrorEnabled(false);
        passwordWrapper.setErrorEnabled(false);
        loginPresenter.dialogForgetPassword(this);
    }

    @Override
    public void showUsernameError() {
        usernameWrapper.setError(getString(R.string.not_a_valid_username));
    }

    @Override
    public void showPasswordError() {
        passwordWrapper.setError(getString(R.string.not_a_valid_password));
    }
}
