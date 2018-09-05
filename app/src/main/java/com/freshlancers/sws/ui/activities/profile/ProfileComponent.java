package com.freshlancers.sws.ui.activities.profile;

import com.freshlancers.sws.base.PerActivityScope;

import dagger.Component;

/**
 * Created by Leon on 22-12-17.
 */
@Component(modules = {ProfileModule.class})
@PerActivityScope
public interface ProfileComponent {

    void inject(ProfileActivity profileActivity);

}
