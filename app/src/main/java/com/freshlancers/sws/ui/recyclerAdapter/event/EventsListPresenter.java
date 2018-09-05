package com.freshlancers.sws.ui.recyclerAdapter.event;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.activities.eventDetails.EventDetailsActivity;
import com.freshlancers.sws.ui.models.Events;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon on 19-12-17.
 */

public class EventsListPresenter implements EventAdapterContract.Presenter {

    private List<Events> eventsList;
    private Context context;

    public EventsListPresenter(Context context, ArrayList<Events> eventsList) {
        this.eventsList = eventsList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return (null != eventsList ? eventsList.size() : 0);
    }

    @Override
    public void bindEventRow(int position, EventAdapterContract.EventRowView rowView) {

        Events mEvents = eventsList.get(position);

        rowView.setTitle(mEvents.getTitle());

        rowView.setDescription(mEvents.getShortDescription());

        rowView.setPlace(mEvents.getPlace());

        rowView.setDate(mEvents.getDate());

    }

    @Override
    public void onItemClick(int position) {
        Activity activity = (Activity) context;
        Intent eventDetailsIntent = new Intent(context, EventDetailsActivity.class);
        context.startActivity(eventDetailsIntent);
        activity.overridePendingTransition(R.anim.enter_right_to_left, R.anim.exit_left_to_right);
    }
}
