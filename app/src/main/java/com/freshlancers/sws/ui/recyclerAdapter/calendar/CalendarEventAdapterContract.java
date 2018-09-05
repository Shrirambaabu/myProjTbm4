package com.freshlancers.sws.ui.recyclerAdapter.calendar;

/**
 * Created by Leon on 21-12-17.
 */

public class CalendarEventAdapterContract {

    interface Presenter {

        int getItemCount();

        void bindEventRow(int position, CalendarEventRowView holder);

        void onItemClick(int adapterPosition);
    }

    interface CalendarEventRowView {

        void setTitle(String title);

        void setDescription(String description);

    }

}
