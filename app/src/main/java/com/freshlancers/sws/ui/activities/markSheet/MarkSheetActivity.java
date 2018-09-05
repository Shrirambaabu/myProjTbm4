package com.freshlancers.sws.ui.activities.markSheet;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.ui.recyclerAdapter.mark.MarkSheetListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.mark.MarkSheetRecyclerAdapter;
import com.freshlancers.sws.ui.models.MarkSheet;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.freshlancers.sws.utils.BottomNavigationHelper.enableNavigation;
import static com.freshlancers.sws.utils.Utils.backButtonOnToolbar;
import static com.freshlancers.sws.utils.Utils.setCheckable;

public class MarkSheetActivity extends AppCompatActivity implements MarkSheetContract.View {


    private static final String TAG = "MarkSheetActivity";
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationView;
    @BindView(R.id.percentageBar)
    ProgressBar percentageBar;
    @BindView(R.id.percentage_value)
    TextView percentageValue;
    @BindView(R.id.gradeBar)
    ProgressBar gradeBar;
    @BindView(R.id.grade_value)
    TextView gradeValue;
    @BindView(R.id.examTypeSpinner)
    MaterialSpinner examTypeSpinner;
    @BindView(R.id.empty_view)
    RelativeLayout emptyView;
    @BindView(R.id.recycler_view_empty)
    EmptyRecyclerView recyclerView;
    @BindView(R.id.relLayout3)
    RelativeLayout relLayout3;
    @Inject
    MarkSheetPresenter markSheetPresenter;
    @Inject
    MarkSheetRecyclerAdapter markSheetRecyclerAdapter;
    @Inject
    ArrayList<MarkSheet> markSheetList;
    @Inject
    MarkSheetListPresenter markSheetListPresenter;
    private Context mContext = MarkSheetActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark_sheet);
        ButterKnife.bind(this);

        DaggerMarkSheetComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);

        markSheetPresenter.attach(this);

        markSheetPresenter.bottomNavigationViewSetup(bottomNavigationView);

        markSheetPresenter.setupShowsRecyclerView(recyclerView, emptyView, relLayout3);

        markSheetPresenter.setupExamSpinner(examTypeSpinner);

        markSheetPresenter.setupPercentageProgressBar();

        markSheetPresenter.setupGradeProgressBar();

        backButtonOnToolbar(MarkSheetActivity.this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        markSheetPresenter.detach();
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
    public void showEmptyRecyclerView() {
        relLayout3.setVisibility(View.GONE);
        recyclerView.setEmptyView(emptyView);
    }

    @Override
    public void showRecyclerView() {
        recyclerView.setAdapter(markSheetRecyclerAdapter);
    }

    @OnClick(R.id.examTypeSpinner)
    public void selectSpinner() {
        examTypeSpinner.setOnItemSelectedListener((view, position, id, item) -> {
            Log.d(TAG, "selectSpinner: " + position);
            markSheetPresenter.setSelectedSpinnerValue(position, markSheetList, item.toString());
        });
    }

    @Override
    public void updateAdapter() {
        relLayout3.setVisibility(View.VISIBLE);
        markSheetRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void updatePercentageProgressBar(int percentage) {

        percentageBar.setProgress(percentage);

        StringBuilder percentageStringBuilder = new StringBuilder()
                .append(String.valueOf(percentage))
                .append(" %");

        percentageValue.setText(percentageStringBuilder);
    }

    @Override
    public void updateGradeProgressBar(int marks, String grade) {

        gradeBar.setProgress(marks);
        gradeValue.setText(grade);

    }
}
