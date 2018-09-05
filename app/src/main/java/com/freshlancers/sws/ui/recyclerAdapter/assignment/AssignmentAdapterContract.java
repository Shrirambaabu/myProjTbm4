package com.freshlancers.sws.ui.recyclerAdapter.assignment;

/**
 * Created by Leon on 21-12-17.
 */

public class AssignmentAdapterContract {

    interface Presenter {

        int getItemCount();

        void bindEventRow(int position, AssignmentRowView holder);

        void onItemClick(int adapterPosition);
    }

    interface AssignmentRowView {

        void setDate(String date);

        void setMonth(String month);

        void setAssignmentName(String assignmentName);

        void setAssignmentSubject(String assignmentSubject);
    }

}
