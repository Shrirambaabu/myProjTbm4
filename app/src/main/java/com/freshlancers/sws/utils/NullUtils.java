package com.freshlancers.sws.utils;

import android.support.annotation.Nullable;

public class NullUtils {

    public static boolean notEmpty(@Nullable String string) {
        return string != null && string.length() > 0;
    }
}