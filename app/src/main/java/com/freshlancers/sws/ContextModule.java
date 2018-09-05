package com.freshlancers.sws;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 20-12-17.
 */

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @SwsScope
    public Context getContext() {
        return context;
    }
}
