package com.freshlancers.sws;

import android.support.v7.widget.LinearLayoutManager;

import dagger.Component;

/**
 * Created by Leon on 20-12-17.
 */
@Component(modules = {RetrofitModule.class, SwsAppModule.class})
@SwsScope
public interface SwsComponent {

    void inject(SwsApplication swsApplication);

}
