package com.freshlancers.sws.ui.activities.assignmentDetail;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;
import com.freshlancers.sws.ui.recyclerAdapter.assignmentDetails.AssignmentDetailsListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.assignmentDetails.AssignmentDetailsRecyclerAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 22-12-17.
 */
@Module(includes = ActivityContext.class)
@PerActivityScope
class AssignmentDetailsModule {

    @Provides
    @PerActivityScope
    AssignmentDetailsPresenter providesAssignmentDetailsPresenter(Context context) {
        return new AssignmentDetailsPresenter(context);
    }

    @Provides
    @PerActivityScope
    ArrayList<String> providesAssignmentDetailsArrayList() {
        return new ArrayList<>();
    }

    @Provides
    @PerActivityScope
    AssignmentDetailsListPresenter providesAssignmentDetailsListPresenter(Context context, ArrayList<String> assignmentList) {
        return new AssignmentDetailsListPresenter(context, assignmentList);
    }

    @Provides
    @PerActivityScope
    AssignmentDetailsRecyclerAdapter providesAssignmentDetailsRecyclerAdapter(AssignmentDetailsListPresenter assignmentListPresenter) {
        return new AssignmentDetailsRecyclerAdapter(assignmentListPresenter);
    }

}
