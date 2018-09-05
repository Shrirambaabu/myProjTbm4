package com.freshlancers.sws.ui.activities.attendance;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;
import static com.freshlancers.sws.utils.Utils.setCheckable;

public class AttendanceActivity extends AppCompatActivity implements AttendanceContract.View {

    private static final String TAG = "AttendanceActivity";

    @BindView(R.id.calendarView)
    MaterialCalendarView materialCalendarView;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationViewEx;

    @BindView(R.id.present_count)
    TextView presentCountTextView;
    @BindView(R.id.absent_count)
    TextView leaveCountTextView;
    @BindView(R.id.late_count)
    TextView lateCountTextView;
    @BindView(R.id.excuse_count)
    TextView excuseCountTextView;

    @Inject
    AttendancePresenter attendancePresenter;

    private Context mContext = AttendanceActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        ButterKnife.bind(this);

        DaggerAttendanceComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        attendancePresenter.attach(this);
        attendancePresenter.bottomNavigationViewSetup(bottomNavigationViewEx);
        attendancePresenter.addDecorator(materialCalendarView, mContext);

        backButtonOnToolbar(AttendanceActivity.this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_left_to_right, R.anim.back_right_to_left);
    }


    @Override
    public void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx) {
        enableNavigation(mContext, this, bottomNavigationViewEx);
        setCheckable(bottomNavigationViewEx, false);

        // add badge
        //Badge mBadge = addBadgeAt(mContext, 2, 12, bottomNavigationViewEx);
    }

    @Override
    public void setPresent(String present) {
        presentCountTextView.setText(present);
    }

    @Override
    public void setLeaves(String leaves) {
        leaveCountTextView.setText(leaves);
    }

    @Override
    public void setLate(String late) {
        lateCountTextView.setText(late);
    }

    @Override
    public void setExcuse(String excuse) {
        excuseCountTextView.setText(excuse);
    }
}
