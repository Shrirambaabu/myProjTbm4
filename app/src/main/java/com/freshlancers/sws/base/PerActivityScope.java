package com.freshlancers.sws.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Leon on 28-12-17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivityScope {
}
