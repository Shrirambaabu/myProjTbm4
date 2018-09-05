package com.freshlancers.sws;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.freshlancers.sws.error.ErrorInterceptor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * Created by Leon on 20-12-17.
 */
@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @SwsScope
    Cache cache(File fileCache) {
        int cacheSize = 10 * 1024 * 1024;
        return new Cache(fileCache, cacheSize);//10Mb cache
    }

    @Provides
    @SwsScope
    File cacheFile(Context context) {
        return new File(context.getCacheDir(), "cache_sws");
    }

    @Provides
    @SwsScope
    OkHttpClient okHttpClient(Cache cache) {
        return new OkHttpClient().newBuilder()
                .addInterceptor(new ErrorInterceptor())
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(cache)
                .build();
    }

    @Provides
    @SwsScope
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @SwsScope
    Gson providesGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

}
