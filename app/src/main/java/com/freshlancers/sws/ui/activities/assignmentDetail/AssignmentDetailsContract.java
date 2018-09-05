package com.freshlancers.sws.ui.activities.assignmentDetail;

import android.os.Bundle;
import android.widget.RelativeLayout;

import com.freshlancers.sws.base.BaseMvpPresenter;
import com.freshlancers.sws.utils.EmptyRecyclerView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

/**
 * Created by Leon on 26-12-17.
 */

interface AssignmentDetailsContract {

    interface Presenter extends BaseMvpPresenter<AssignmentDetailsContract.View> {

        void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx);

        void setupShowsRecyclerView(EmptyRecyclerView eventsRecyclerView);

        void populateRecyclerView(List<String> events);

        void sendBundleData(Bundle bundle);
    }

    // Action callbacks. Activity/Fragment will implement
    interface View {

        void viewBottomNavigation(BottomNavigationViewEx bottomNavigationViewEx);

        void showRecyclerView();

        void updateAdapter();

        void showError(String message);

        void showDueDate(String dueDate, String month);

        void showAssignmentName(String assignmentName);

        void showAssignmentSubject(String assignmentSubject);



    }

}
