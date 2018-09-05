package com.freshlancers.sws.ui.models;

/**
 * Created by Leon on 23-12-17.
 */

public class MarkSheet {

    private String subjectName;
    private String subjectMark;
    private String subjectStatus;

    public MarkSheet(String subjectName, String subjectMark, String subjectStatus) {
        this.subjectName = subjectName;
        this.subjectMark = subjectMark;
        this.subjectStatus = subjectStatus;
    }

    public String getSubjectName() {

        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectMark() {
        return subjectMark;
    }

    public void setSubjectMark(String subjectMark) {
        this.subjectMark = subjectMark;
    }

    public String getSubjectStatus() {
        return subjectStatus;
    }

    public void setSubjectStatus(String subjectStatus) {
        this.subjectStatus = subjectStatus;
    }
}
