package com.freshlancers.sws.ui.recyclerAdapter.mark;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.freshlancers.sws.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Leon on 23-12-17.
 */

public class MarkSheetHolder extends RecyclerView.ViewHolder implements MarkSheetAdapterContract.MarkSheetRowView {

    @BindView(R.id.subject_card)
    TextView subjectCardTextView;
    @BindView(R.id.marks_card)
    TextView markCardTextView;
    @BindView(R.id.status_card)
    TextView statusCardTextView;
    private MarkSheetListPresenter markSheetListPresenter;

    MarkSheetHolder(View itemView, MarkSheetListPresenter markSheetListPresenter) {
        super(itemView);
        this.markSheetListPresenter = markSheetListPresenter;
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setSubjectName(String subjectName) {
        subjectCardTextView.setText(subjectName);
    }

    @Override
    public void setSubjectMark(String subjectMark) {
        markCardTextView.setText(subjectMark);
    }

    @Override
    public void setSubjectStatus(String subjectStatus) {
        statusCardTextView.setText(subjectStatus);
    }

    @Override
    public void setSubjectStatusColor(int color) {
        statusCardTextView.setTextColor(color);
    }
}
