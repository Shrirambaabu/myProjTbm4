package com.freshlancers.sws.ui.recyclerAdapter.assignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.freshlancers.sws.R;


/**
 * Created by Ashith VL on 12/1/2017.
 */

public class AssignmentRecyclerAdapter extends RecyclerView.Adapter<AssignmentHolder> {

    private static final String TAG = "NotificationRecyclerAda";
    AssignmentListPresenter listPresenter;

    public AssignmentRecyclerAdapter(AssignmentListPresenter listPresenter) {
        this.listPresenter = listPresenter;
    }

    @Override
    public AssignmentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AssignmentHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_assignment, parent, false), listPresenter);
    }

    @Override
    public void onBindViewHolder(AssignmentHolder holder, int position) {
        listPresenter.bindEventRow(position, holder);
    }

    @Override
    public int getItemCount() {
        return listPresenter.getItemCount();
    }

}
