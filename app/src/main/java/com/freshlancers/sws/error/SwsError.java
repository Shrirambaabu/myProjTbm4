package com.freshlancers.sws.error;

import java.io.IOException;

/**
 * Created by Leon on 26-12-17.
 */

class SwsError extends IOException {
    private int responseCode;
    private String message;

    SwsError(int responseCode, String message) {
        this.responseCode = responseCode;
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
