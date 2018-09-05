package com.freshlancers.sws.base;

/**
 * Created by Leon on 17-12-17.
 */

/**
 * Each presenter must implement this interface
 *
 * @param <V> View for the presenter
 */
public interface BaseMvpPresenter<V> {

    /**
     * Called when view attached to presenter
     *
     * @param view
     */
    void attach(V view);

    /**
     * Called when view is detached from presenter
     */
    void detach();

    /**
     * @return true if view is attached to presenter
     */
    boolean isAttached();
}