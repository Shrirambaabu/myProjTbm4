package com.freshlancers.sws.ui.models;

/**
 * Created by Ashith VL on 12/4/2017.
 */

public class Notification {

    private String title;
    private String heading;
    private String timeAgo;
    private String description;

    public Notification(String title, String timeAgo, String heading, String description) {
        this.title = title;
        this.heading = heading;
        this.timeAgo = timeAgo;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getTimeAgo() {
        return timeAgo;
    }

    public void setTimeAgo(String timeAgo) {
        this.timeAgo = timeAgo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
