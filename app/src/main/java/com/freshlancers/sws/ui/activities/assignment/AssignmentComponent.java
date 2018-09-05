package com.freshlancers.sws.ui.activities.assignment;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 26-12-17.
 */
@Component(modules = {AssignmentModule.class})
@PerActivityScope
public interface AssignmentComponent {

    void inject(AssignmentActivity assignmentActivity);

}
