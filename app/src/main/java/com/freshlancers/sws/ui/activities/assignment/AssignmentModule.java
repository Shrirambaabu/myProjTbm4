package com.freshlancers.sws.ui.activities.assignment;

import android.content.Context;

import com.freshlancers.sws.base.ActivityContext;
import com.freshlancers.sws.base.PerActivityScope;
import com.freshlancers.sws.ui.recyclerAdapter.assignment.AssignmentListPresenter;
import com.freshlancers.sws.ui.recyclerAdapter.assignment.AssignmentRecyclerAdapter;
import com.freshlancers.sws.ui.models.Assignment;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 22-12-17.
 */
@Module(includes = ActivityContext.class)
@PerActivityScope
class AssignmentModule {

    @Provides
    @PerActivityScope
    AssignmentPresenter providesAssignmentPresenter(Context context) {
        return new AssignmentPresenter(context);
    }

    @Provides
    @PerActivityScope
    ArrayList<Assignment> providesAssignmentArrayList() {
        return new ArrayList<>();
    }

    @Provides
    @PerActivityScope
    AssignmentListPresenter providesAssignmentListPresenter(Context context, ArrayList<Assignment> assignmentList) {
        return new AssignmentListPresenter(context, assignmentList);
    }

    @Provides
    @PerActivityScope
    AssignmentRecyclerAdapter providesAssignmentRecyclerAdapter(AssignmentListPresenter assignmentListPresenter) {
        return new AssignmentRecyclerAdapter(assignmentListPresenter);
    }

}
