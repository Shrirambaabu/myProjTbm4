package com.freshlancers.sws.ui.recyclerAdapter.event;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.freshlancers.sws.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashith VL on 12/1/2017.
 */

public class EventsHolder extends RecyclerView.ViewHolder implements EventAdapterContract.EventRowView, View.OnClickListener {

    @BindView(R.id.title)
    TextView titleTextView;
    @BindView(R.id.description)
    TextView descriptionTextView;
    @BindView(R.id.date)
    TextView dateTextView;
    @BindView(R.id.place)
    TextView placeTextView;

    private EventsListPresenter eventsListPresenter;

    EventsHolder(View itemView, EventsListPresenter eventsListPresenter) {
        super(itemView);
        this.eventsListPresenter = eventsListPresenter;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    @Override
    public void setDescription(String description) {
        descriptionTextView.setText(description);
    }

    @Override
    public void setPlace(String place) {
        placeTextView.setText(place);
    }

    @Override
    public void setDate(String date) {
        dateTextView.setText(date);
    }

    @Override
    public void onClick(View v) {
        eventsListPresenter.onItemClick(getAdapterPosition());
    }
}
