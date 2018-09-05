package com.freshlancers.sws.ui.recyclerAdapter.assignmentDetails;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.recyclerAdapter.assignment.AssignmentHolder;
import com.freshlancers.sws.ui.recyclerAdapter.assignment.AssignmentListPresenter;


/**
 * Created by Ashith VL on 12/1/2017.
 */

public class AssignmentDetailsRecyclerAdapter extends RecyclerView.Adapter<AssignmentDetailsHolder> {

    private static final String TAG = "NotificationRecyclerAda";
    AssignmentDetailsListPresenter listPresenter;

    public AssignmentDetailsRecyclerAdapter(AssignmentDetailsListPresenter listPresenter) {
        this.listPresenter = listPresenter;
    }

    @Override
    public AssignmentDetailsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AssignmentDetailsHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_assignment_detail,
                parent, false), listPresenter);
    }

    @Override
    public void onBindViewHolder(AssignmentDetailsHolder holder, int position) {
        listPresenter.bindEventRow(position, holder);
    }

    @Override
    public int getItemCount() {
        return listPresenter.getItemCount();
    }

}
