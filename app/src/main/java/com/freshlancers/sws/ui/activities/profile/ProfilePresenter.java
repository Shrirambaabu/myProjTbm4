package com.freshlancers.sws.ui.activities.profile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.activities.forgotPassword.ForgotPasswordActivity;
import com.freshlancers.sws.ui.activities.login.LoginActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 18-12-17.
 */

public class ProfilePresenter extends BasePresenter<ProfileContract.View> implements ProfileContract.Presenter {

    private Context context;

    ProfilePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
    }


    @Override
    public void popupDisplay(View view) {

        PopupWindow popupWindow = new PopupWindow(context);

        TextView changePasswordTextView;
        TextView logoutTextView;
        Activity activity = (Activity) context;

        // inflate your layout or dynamically add view
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewInflater = null;
        if (inflater != null) {
            viewInflater = inflater.inflate(R.layout.overflow_layout, null);

            changePasswordTextView = viewInflater.findViewById(R.id.changePassword);
            logoutTextView = viewInflater.findViewById(R.id.logout);

            changePasswordTextView.setOnClickListener(view1 -> {
                Intent changePasswordIntent = new Intent(context, ForgotPasswordActivity.class);
                activity.startActivity(changePasswordIntent);
                activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            });
            logoutTextView.setOnClickListener(view1 -> {
                Intent logoutIntent = new Intent(context, LoginActivity.class);
                logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                activity.startActivity(logoutIntent);
                activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            });
        }
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(
                context.getResources(),
                Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888)
        ));
        popupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        popupWindow.setContentView(viewInflater);

        getView().viewPopUp(popupWindow, view);


    }


}
