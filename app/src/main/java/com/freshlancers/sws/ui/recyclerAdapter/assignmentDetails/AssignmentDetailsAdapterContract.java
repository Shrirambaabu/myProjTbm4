package com.freshlancers.sws.ui.recyclerAdapter.assignmentDetails;

/**
 * Created by Leon on 21-12-17.
 */

public class AssignmentDetailsAdapterContract {

    interface Presenter {

        int getItemCount();

        void bindEventRow(int position, AssignmentDetailsRowView holder);

        void onItemClick(int adapterPosition);
    }

    interface AssignmentDetailsRowView {

    }

}
