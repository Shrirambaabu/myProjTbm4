package com.freshlancers.sws.ui.recyclerAdapter.assignmentDetails;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.activities.assignmentDetail.AssignmentDetailsActivity;
import com.freshlancers.sws.ui.models.Assignment;
import com.freshlancers.sws.ui.recyclerAdapter.assignment.AssignmentAdapterContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leon on 19-12-17.
 */

public class AssignmentDetailsListPresenter implements AssignmentDetailsAdapterContract.Presenter {

    private List<String> assignmentArrayList;
    private Context context;

    public AssignmentDetailsListPresenter(Context context, ArrayList<String> assignmentArrayList) {
        this.assignmentArrayList = assignmentArrayList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return (null != assignmentArrayList ? assignmentArrayList.size() : 0);
    }

    @Override
    public void bindEventRow(int position, AssignmentDetailsAdapterContract.AssignmentDetailsRowView rowView) {

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(context, "clicked " + position + " value is "
                + assignmentArrayList.get(position), Toast.LENGTH_LONG).show();
    }
}
