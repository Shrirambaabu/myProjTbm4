package com.freshlancers.sws.ui.activities.markSheet;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.models.MarkSheet;
import com.freshlancers.sws.ui.services.DataService;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.List;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 23-12-17.
 */

public class MarkSheetPresenter extends BasePresenter<MarkSheetContract.View> implements MarkSheetContract.Presenter {

    private Context context;

    MarkSheetPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
    }

    @Override
    public void setupShowsRecyclerView(EmptyRecyclerView eventsRecyclerView, RelativeLayout emptyRelativeLayout,RelativeLayout relLayout3) {
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, resId);
        eventsRecyclerView.setLayoutAnimation(animation);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        eventsRecyclerView.setLayoutManager(mLayoutManager);
        eventsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        eventsRecyclerView.setEmptyView(emptyRelativeLayout);
        eventsRecyclerView.setHasFixedSize(true);
        relLayout3.setVisibility(View.GONE);
        getView().showRecyclerView();
    }


    @Override
    public void setupExamSpinner(MaterialSpinner examTypeSpinner) {

        getView().showEmptyRecyclerView();

        examTypeSpinner.setItems(DataService.getExamTypes());

    }

    @Override
    public void setupPercentageProgressBar() {
        getView().updatePercentageProgressBar(75);
    }

    @Override
    public void setupGradeProgressBar() {
        getView().updateGradeProgressBar(80,"A");
    }

    @Override
    public void setSelectedSpinnerValue(int position, List<MarkSheet> markSheetList, String selectedItem) {
        if (position == 0) {
            markSheetList.clear();
            getView().showEmptyRecyclerView();
        } else {
            markSheetList.clear();
            markSheetList.addAll(DataService.getMarks());
            getView().updateAdapter();
        }
    }
}
