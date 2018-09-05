package com.freshlancers.sws.ui.recyclerAdapter.assignment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.activities.assignmentDetail.AssignmentDetailsActivity;
import com.freshlancers.sws.ui.models.Assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon on 19-12-17.
 */

public class AssignmentListPresenter implements AssignmentAdapterContract.Presenter {

    private List<Assignment> assignmentArrayList;
    private Context context;

    public AssignmentListPresenter(Context context, ArrayList<Assignment> assignmentArrayList) {
        this.assignmentArrayList = assignmentArrayList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return (null != assignmentArrayList ? assignmentArrayList.size() : 0);
    }

    @Override
    public void bindEventRow(int position, AssignmentAdapterContract.AssignmentRowView rowView) {

        Assignment assignment = assignmentArrayList.get(position);

        rowView.setAssignmentName(assignment.getAssignmentName());

        rowView.setAssignmentSubject(assignment.getAssignmentSubject());

        rowView.setDate(assignment.getDate());

        rowView.setMonth(assignment.getMonth());

    }

    @Override
    public void onItemClick(int position) {
        Activity activity = (Activity) context;
        Intent eventDetailsIntent = new Intent(context, AssignmentDetailsActivity.class);
        eventDetailsIntent.putExtra(activity.getString(R.string.assignmentName), assignmentArrayList.get(position).getAssignmentName());
        eventDetailsIntent.putExtra(activity.getString(R.string.assignmentSubject), assignmentArrayList.get(position).getAssignmentSubject());
        eventDetailsIntent.putExtra(activity.getString(R.string.date), assignmentArrayList.get(position).getDate());
        eventDetailsIntent.putExtra(activity.getString(R.string.month), assignmentArrayList.get(position).getMonth());
        context.startActivity(eventDetailsIntent);
        activity.overridePendingTransition(R.anim.enter_right_to_left, R.anim.exit_left_to_right);
    }
}
