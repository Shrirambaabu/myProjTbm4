package com.freshlancers.sws.ui.recyclerAdapter.mark;

/**
 * Created by Leon on 23-12-17.
 */

public class MarkSheetAdapterContract {

    interface Presenter {

        int getItemCount();

        void bindEventRow(int position, MarkSheetRowView holder);

    }

    interface MarkSheetRowView {

        void setSubjectName(String subjectName);

        void setSubjectMark(String subjectMark);

        void setSubjectStatus(String subjectStatus);

        void setSubjectStatusColor(int color);

    }
}
