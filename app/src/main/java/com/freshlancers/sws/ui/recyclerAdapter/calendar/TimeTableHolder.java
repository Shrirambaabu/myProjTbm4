package com.freshlancers.sws.ui.recyclerAdapter.calendar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.recyclerAdapter.event.EventAdapterContract;
import com.freshlancers.sws.ui.recyclerAdapter.event.EventsListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashith VL on 12/1/2017.
 */

public class TimeTableHolder extends RecyclerView.ViewHolder implements TimeTableAdapterContract.TimeTableRowView {

    @BindView(R.id.subject)
    TextView subjectTextView;
    @BindView(R.id.time_btw)
    TextView timeTextView;
    @BindView(R.id.staff_name)
    TextView staffNameTextView;

    private TimeTableListPresenter timeTableListPresenter;

    TimeTableHolder(View itemView, TimeTableListPresenter timeTableListPresenter) {
        super(itemView);
        this.timeTableListPresenter = timeTableListPresenter;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setSubject(String subject) {
        subjectTextView.setText(subject);
    }

    @Override
    public void setTime(String time) {
        timeTextView.setText(time);
    }

    @Override
    public void setStaffName(String staffName) {
        staffNameTextView.setText(staffName);
    }
}
