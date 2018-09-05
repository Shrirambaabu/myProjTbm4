package com.freshlancers.sws.ui.activities.markSheet;

import android.widget.RelativeLayout;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.ui.models.MarkSheet;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.util.List;

/**
 * Created by Leon on 23-12-17.
 */

public class MarkSheetContract {

    interface Presenter extends BaseMvpPresenter<MarkSheetContract.View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

        void setupShowsRecyclerView(EmptyRecyclerView eventsRecyclerView, RelativeLayout emptyRelativeLayout, RelativeLayout VisibilityGoneRelativeLayout);

        void setupExamSpinner(MaterialSpinner examTypeSpinner);

        void setupPercentageProgressBar();

        void setupGradeProgressBar();

        void setSelectedSpinnerValue(int position, List<MarkSheet> markSheetList, String selectedItem);

    }

    // Action callbacks. Activity/Fragment will implement
    interface View {

        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);

        void showEmptyRecyclerView();

        void showRecyclerView();

        void updateAdapter();

        void showError(String message);

        void updatePercentageProgressBar(int percentage);

        void updateGradeProgressBar(int marks, String grade);

    }

}
