package com.freshlancers.sws.ui.recyclerAdapter.calendar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.freshlancers.sws.R;


/**
 * Created by Ashith VL on 12/1/2017.
 */

public class TimeTableRecyclerAdapter extends RecyclerView.Adapter<TimeTableHolder> {

    private static final String TAG = "NotificationRecyclerAda";
    TimeTableListPresenter timeTableListPresenter;

    public TimeTableRecyclerAdapter(TimeTableListPresenter timeTableListPresenter) {
        this.timeTableListPresenter = timeTableListPresenter;
    }

    @Override
    public TimeTableHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TimeTableHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_time_table, parent, false),
                timeTableListPresenter);
    }

    @Override
    public void onBindViewHolder(TimeTableHolder holder, int position) {
        timeTableListPresenter.bindEventRow(position, holder);
    }

    @Override
    public int getItemCount() {
        return timeTableListPresenter.getItemCount();
    }

}
