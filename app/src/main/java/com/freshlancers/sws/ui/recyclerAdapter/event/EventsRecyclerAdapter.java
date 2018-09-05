package com.freshlancers.sws.ui.recyclerAdapter.event;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.freshlancers.sws.R;


/**
 * Created by Ashith VL on 12/1/2017.
 */

public class EventsRecyclerAdapter extends RecyclerView.Adapter<EventsHolder> {

    private static final String TAG = "NotificationRecyclerAda";
    EventsListPresenter eventsListPresenter;

    public EventsRecyclerAdapter(EventsListPresenter eventsListPresenter) {
        this.eventsListPresenter = eventsListPresenter;
    }

    @Override
    public EventsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_event, parent, false), eventsListPresenter);
    }

    @Override
    public void onBindViewHolder(EventsHolder holder, int position) {
        eventsListPresenter.bindEventRow(position, holder);
    }

    @Override
    public int getItemCount() {
        return eventsListPresenter.getItemCount();
    }

}
