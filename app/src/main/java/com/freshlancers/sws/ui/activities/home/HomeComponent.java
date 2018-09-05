package com.freshlancers.sws.ui.activities.home;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 22-12-17.
 */
@Component(modules = {HomeModule.class})
@PerActivityScope
public interface HomeComponent {

    void inject(HomeActivity homeActivity);

}
