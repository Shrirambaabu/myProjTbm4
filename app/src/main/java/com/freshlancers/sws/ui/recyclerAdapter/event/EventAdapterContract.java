package com.freshlancers.sws.ui.recyclerAdapter.event;

/**
 * Created by Leon on 21-12-17.
 */

public class EventAdapterContract {

    interface Presenter {

        int getItemCount();

        void bindEventRow(int position, EventRowView holder);

        void onItemClick(int adapterPosition);
    }

    interface EventRowView {

        void setTitle(String title);

        void setDescription(String description);

        void setPlace(String place);

        void setDate(String date);
    }

}
