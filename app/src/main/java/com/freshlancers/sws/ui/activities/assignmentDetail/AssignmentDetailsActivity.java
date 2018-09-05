package com.freshlancers.sws.ui.activities.assignmentDetail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.ui.recyclerAdapter.assignmentDetails.AssignmentDetailsListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.assignmentDetails.AssignmentDetailsRecyclerAdapter;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;
import static com.freshlancers.sws.utils.Utils.setCheckable;

public class AssignmentDetailsActivity extends AppCompatActivity implements AssignmentDetailsContract.View {

    @BindView(R.id.day)
    TextView dayTextView;
    @BindView(R.id.month)
    TextView monthTextView;
    @BindView(R.id.assignmentTittle)
    TextView assignmentTittleTextView;
    @BindView(R.id.assignmentSubject)
    TextView assignmentSubjectTextView;
    @BindView(R.id.recycler_view_empty)
    EmptyRecyclerView recyclerView;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationView;

    @Inject
    AssignmentDetailsListPresenter assignmentDetailsListPresenter;
    @Inject
    AssignmentDetailsRecyclerAdapter assignmentDetailsRecyclerAdapter;
    @Inject
    ArrayList<String> stringArrayList;
    @Inject
    AssignmentDetailsPresenter assignmentDetailsPresenter;

    private Context mContext = AssignmentDetailsActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_details);
        ButterKnife.bind(this);

        DaggerAssignmentDetailsComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        assignmentDetailsPresenter.attach(this);

        assignmentDetailsPresenter.bottomNavigationViewSetup(bottomNavigationView);

        assignmentDetailsPresenter.setupShowsRecyclerView(recyclerView);

        assignmentDetailsPresenter.sendBundleData(getIntent().getExtras());

        backButtonOnToolbar(AssignmentDetailsActivity.this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        assignmentDetailsPresenter.detach();
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
    public void showRecyclerView() {
        recyclerView.setAdapter(assignmentDetailsRecyclerAdapter);
        assignmentDetailsPresenter.populateRecyclerView(stringArrayList);
    }

    @Override
    public void updateAdapter() {
        assignmentDetailsRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        Timber.e(message);
    }

    @Override
    public void showDueDate(String dueDate, String month) {
        dayTextView.setText(dueDate);
        monthTextView.setText(month);
    }

    @Override
    public void showAssignmentName(String assignmentName) {
        assignmentTittleTextView.setText(assignmentName);
    }

    @Override
    public void showAssignmentSubject(String assignmentSubject) {
        assignmentSubjectTextView.setText(assignmentSubject);
    }
}
