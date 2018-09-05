package com.freshlancers.sws.base;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Leon on 25-12-17.
 */
@Module
@PerFragmentScope
public class FragmentContext {

    private Context context;

    public FragmentContext(Context context) {
        this.context = context;
    }

    @Provides
    @PerFragmentScope
    public Context getContext() {
        return context;
    }
}
