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

public class CalendarEventsHolder extends RecyclerView.ViewHolder implements CalendarEventAdapterContract.CalendarEventRowView, View.OnClickListener {

    @BindView(R.id.title)
    TextView titleTextView;
    @BindView(R.id.description)
    TextView descriptionTextView;

    private CalendarEventsListPresenter eventsListPresenter;

    CalendarEventsHolder(View itemView, CalendarEventsListPresenter eventsListPresenter) {
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
    public void onClick(View v) {
        eventsListPresenter.onItemClick(getAdapterPosition());
    }
}
