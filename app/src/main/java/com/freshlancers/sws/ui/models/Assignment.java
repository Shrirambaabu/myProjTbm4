package com.freshlancers.sws.ui.models;

/**
 * Created by Leon on 26-12-17.
 */

public class Assignment {

    private String date;
    private String month;
    private String assignmentName;
    private String assignmentSubject;

    public Assignment(String date, String month, String assignmentName, String assignmentSubject) {
        this.date = date;
        this.month = month;
        this.assignmentName = assignmentName;
        this.assignmentSubject = assignmentSubject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentSubject() {
        return assignmentSubject;
    }

    public void setAssignmentSubject(String assignmentSubject) {
        this.assignmentSubject = assignmentSubject;
    }
}
