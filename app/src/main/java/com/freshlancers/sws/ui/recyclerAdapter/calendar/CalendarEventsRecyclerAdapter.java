package com.freshlancers.sws.ui.recyclerAdapter.calendar;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.models.CalendarEvents;
import com.freshlancers.sws.ui.recyclerAdapter.event.EventsHolder;
import com.freshlancers.sws.ui.recyclerAdapter.event.EventsListPresenter;


/**
 * Created by Ashith VL on 12/1/2017.
 */

public class CalendarEventsRecyclerAdapter extends RecyclerView.Adapter<CalendarEventsHolder> {

    CalendarEventsListPresenter eventsListPresenter;

    public CalendarEventsRecyclerAdapter(CalendarEventsListPresenter eventsListPresenter) {
        this.eventsListPresenter = eventsListPresenter;
    }

    @Override
    public CalendarEventsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CalendarEventsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_calendar_event, parent, false), eventsListPresenter);
    }

    @Override
    public void onBindViewHolder(CalendarEventsHolder holder, int position) {
        eventsListPresenter.bindEventRow(position, holder);
    }

    @Override
    public int getItemCount() {
        return eventsListPresenter.getItemCount();
    }

}
