package com.freshlancers.sws.ui.models;

/**
 * Created by Ashith VL on 12/6/2017.
 */

public class Events {

    private String title;
    private String shortDescription;
    private String date;
    private String place;

    public Events(String title, String shortDescription, String date, String place) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.date = date;
        this.place = place;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
