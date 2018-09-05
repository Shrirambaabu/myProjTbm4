package com.freshlancers.sws.ui.models;

/**
 * Created by Leon on 28-12-17.
 */

public class CalendarEvents {

    private String title;
    private String shortDescription;

    public CalendarEvents(String title, String shortDescription) {
        this.title = title;
        this.shortDescription = shortDescription;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
