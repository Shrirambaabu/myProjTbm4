package com.freshlancers.sws.utils;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Ashith VL on 12/2/2017.
 */

public class DisableTouchListener implements View.OnTouchListener {

    public DisableTouchListener() {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return true;
    }
}
