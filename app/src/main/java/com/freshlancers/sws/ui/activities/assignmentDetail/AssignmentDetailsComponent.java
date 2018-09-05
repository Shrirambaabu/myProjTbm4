package com.freshlancers.sws.ui.activities.assignmentDetail;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 26-12-17.
 */
@Component(modules = {AssignmentDetailsModule.class})
@PerActivityScope
public interface AssignmentDetailsComponent {

    void inject(AssignmentDetailsActivity assignmentDetailsActivity);

}
