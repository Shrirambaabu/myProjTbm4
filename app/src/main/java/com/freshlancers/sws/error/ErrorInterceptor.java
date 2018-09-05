package com.freshlancers.sws.error;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by Leon on 26-12-17.
 */

public class ErrorInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        if (!response.isSuccessful()) {
            throw new SwsError(
                    response.code(),
                    response.message()
            );
        }
        return response;
    }
}
