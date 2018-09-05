package com.freshlancers.sws.ui.recyclerAdapter.calendar;

/**
 * Created by Leon on 21-12-17.
 */

public class TimeTableAdapterContract {

    interface Presenter {

        int getItemCount();

        void bindEventRow(int position, TimeTableRowView holder);
    }

    interface TimeTableRowView {

        void setSubject(String subject);

        void setTime(String time);

        void setStaffName(String staffName);

    }

}
