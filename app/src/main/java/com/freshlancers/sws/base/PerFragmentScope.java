package com.freshlancers.sws.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Leon on 25-12-17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragmentScope {
}
