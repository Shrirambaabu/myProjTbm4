package com.freshlancers.sws.ui.models;

/**
 * Created by Leon on 28-12-17.
 */

public class TimeTable {

    private String subeject;
    private String staffName;
    private String time;

    public TimeTable(String subeject, String staffName, String time) {
        this.subeject = subeject;
        this.staffName = staffName;
        this.time = time;
    }

    public String getSubeject() {

        return subeject;
    }

    public void setSubeject(String subeject) {
        this.subeject = subeject;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String timeStart) {
        this.time = time;
    }

}
