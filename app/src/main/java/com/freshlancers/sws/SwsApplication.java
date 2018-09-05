package com.freshlancers.sws;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.freshlancers.sws.error.CrashlyticsTree;
import com.google.gson.Gson;
import com.squareup.leakcanary.LeakCanary;

import net.danlew.android.joda.JodaTimeAndroid;

import javax.inject.Inject;

import io.fabric.sdk.android.Fabric;
import retrofit2.Retrofit;
import timber.log.Timber;

/**
 * Created by Leon on 17-12-17.
 */

public class SwsApplication extends Application {

    private static final String TAG = "SwsApplication";

    public static final String BASE_URL = "http://api.tvmaze.com";

    @Inject
    Retrofit retrofit;
    @Inject
    Gson gson;
    @Inject
    SharedPreferences sharedPreferences;

    private SwsComponent swsComponent;

    public static SwsApplication get(Activity activity) {
        return (SwsApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        JodaTimeAndroid.init(this);

        Context context = this;

        swsComponent = DaggerSwsComponent.builder()
                .contextModule(new ContextModule(context))
                .swsAppModule(new SwsAppModule(this))
                .build();

        swsComponent.inject(this);

        CrashlyticsCore core = new CrashlyticsCore.Builder()
                .disabled(BuildConfig.DEBUG)
                .build();
        Fabric.with(this, new Crashlytics.Builder().core(core).build());

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Timber.plant(new CrashlyticsTree());

    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public Gson getGson() {
        return gson;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public SwsComponent getSwsComponent() {
        return swsComponent;
    }
}