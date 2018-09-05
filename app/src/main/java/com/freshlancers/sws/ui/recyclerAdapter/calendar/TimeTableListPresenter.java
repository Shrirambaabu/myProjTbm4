package com.freshlancers.sws.ui.recyclerAdapter.calendar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.activities.eventDetails.EventDetailsActivity;
import com.freshlancers.sws.ui.models.Events;
import com.freshlancers.sws.ui.models.TimeTable;
import com.freshlancers.sws.ui.recyclerAdapter.event.EventAdapterContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon on 19-12-17.
 */

public class TimeTableListPresenter implements TimeTableAdapterContract.Presenter {

    private List<TimeTable> timeTables;
    private Context context;

    public TimeTableListPresenter(Context context, ArrayList<TimeTable> timeTables) {
        this.timeTables = timeTables;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return (null != timeTables ? timeTables.size() : 0);
    }

    @Override
    public void bindEventRow(int position, TimeTableAdapterContract.TimeTableRowView rowView) {

        TimeTable timeTable = timeTables.get(position);

        rowView.setSubject(timeTable.getSubeject());

        rowView.setTime(timeTable.getTime());

        rowView.setStaffName(timeTable.getStaffName());

    }

}
