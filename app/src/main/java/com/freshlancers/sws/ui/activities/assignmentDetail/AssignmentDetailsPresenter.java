package com.freshlancers.sws.ui.activities.assignmentDetail;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.services.DataService;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.freshlancers.sws.utils.GridAutoFitLayoutManager;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 26-12-17.
 */

public class AssignmentDetailsPresenter extends BasePresenter<AssignmentDetailsContract.View> implements AssignmentDetailsContract.Presenter {

    private Context mContext;

    public AssignmentDetailsPresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
    }

    @Override
    public void setupShowsRecyclerView(EmptyRecyclerView eventsRecyclerView) {

        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(mContext, resId);
        eventsRecyclerView.setLayoutAnimation(animation);

        GridAutoFitLayoutManager gridLayoutManager = new GridAutoFitLayoutManager(mContext, 185);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        eventsRecyclerView.setLayoutManager(gridLayoutManager);
        eventsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        eventsRecyclerView.setHasFixedSize(true);

        getView().showRecyclerView();
    }

    @Override
    public void populateRecyclerView(List<String> stringList) {

        stringList.addAll(DataService.getDownloadLink());
        getView().updateAdapter();

    }

    @Override
    public void sendBundleData(Bundle bundle) {
        getView().showAssignmentName(bundle.getString(mContext.getString(R.string.assignmentName)));
        getView().showAssignmentSubject(bundle.getString(mContext.getString(R.string.assignmentSubject)));
        getView().showDueDate(bundle.getString(mContext.getString(R.string.date)),
                bundle.getString(mContext.getString(R.string.month)));
    }
}
