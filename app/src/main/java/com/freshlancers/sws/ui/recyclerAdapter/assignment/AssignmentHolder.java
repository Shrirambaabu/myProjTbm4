package com.freshlancers.sws.ui.recyclerAdapter.assignment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.freshlancers.sws.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashith VL on 12/1/2017.
 */

public class AssignmentHolder extends RecyclerView.ViewHolder implements AssignmentAdapterContract.AssignmentRowView, View.OnClickListener {

    @BindView(R.id.day)
    TextView dayTextView;
    @BindView(R.id.month)
    TextView monthTextView;
    @BindView(R.id.assignmentTittle)
    TextView assignmentTittleTextView;
    @BindView(R.id.assignmentSubject)
    TextView assignmentSubjectTextView;

    private AssignmentListPresenter assignmentListPresenter;

    AssignmentHolder(View itemView, AssignmentListPresenter assignmentListPresenter) {
        super(itemView);
        this.assignmentListPresenter = assignmentListPresenter;
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        assignmentListPresenter.onItemClick(getAdapterPosition());
    }

    @Override
    public void setDate(String date) {
        dayTextView.setText(date);
    }

    @Override
    public void setMonth(String month) {
        monthTextView.setText(month);
    }

    @Override
    public void setAssignmentName(String assignmentName) {
        assignmentTittleTextView.setText(assignmentName);
    }

    @Override
    public void setAssignmentSubject(String assignmentSubject) {
        assignmentSubjectTextView.setText(assignmentSubject);
    }
}
