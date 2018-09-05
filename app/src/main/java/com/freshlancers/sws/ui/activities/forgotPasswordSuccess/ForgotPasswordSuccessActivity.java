package com.freshlancers.sws.ui.activities.forgotPasswordSuccess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.activities.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordSuccessActivity extends AppCompatActivity {

    @BindView(R.id.btn_done)
    AppCompatButton btnDone;

    private Context context = ForgotPasswordSuccessActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_success);
        ButterKnife.bind(this);
    }

    @Override
    public void onBackPressed() {

    }

    @OnClick(R.id.btn_done)
    public void onViewClicked() {
        Intent logoutIntent = new Intent(context, LoginActivity.class);
        logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(logoutIntent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
