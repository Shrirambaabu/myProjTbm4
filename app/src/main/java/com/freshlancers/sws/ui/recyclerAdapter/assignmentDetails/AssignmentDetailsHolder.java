package com.freshlancers.sws.ui.recyclerAdapter.assignmentDetails;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.recyclerAdapter.assignment.AssignmentAdapterContract;
import com.freshlancers.sws.ui.recyclerAdapter.assignment.AssignmentListPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashith VL on 12/1/2017.
 */

public class AssignmentDetailsHolder extends RecyclerView.ViewHolder implements AssignmentDetailsAdapterContract.AssignmentDetailsRowView, View.OnClickListener {

    private AssignmentDetailsListPresenter assignmentListPresenter;

    AssignmentDetailsHolder(View itemView, AssignmentDetailsListPresenter assignmentListPresenter) {
        super(itemView);
        this.assignmentListPresenter = assignmentListPresenter;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        assignmentListPresenter.onItemClick(getAdapterPosition());
    }

}
