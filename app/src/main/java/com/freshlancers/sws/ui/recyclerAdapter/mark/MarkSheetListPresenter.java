package com.freshlancers.sws.ui.recyclerAdapter.mark;

import android.content.Context;
import android.graphics.Color;

import com.freshlancers.sws.R;
import com.freshlancers.sws.ui.models.MarkSheet;

import java.util.ArrayList;

/**
 * Created by Leon on 23-12-17.
 */

public class MarkSheetListPresenter implements MarkSheetAdapterContract.Presenter {

    private static final String TAG = "MarkSheetListPresenter";

    private Context context;
    private ArrayList<MarkSheet> sheetArrayList;

    public MarkSheetListPresenter(Context context, ArrayList<MarkSheet> sheetArrayList) {
        this.context = context;
        this.sheetArrayList = sheetArrayList;
    }

    @Override
    public int getItemCount() {
        return (null != sheetArrayList ? sheetArrayList.size() : 0);
    }

    @Override
    public void bindEventRow(int position, MarkSheetAdapterContract.MarkSheetRowView rowView) {

        MarkSheet markSheet = sheetArrayList.get(position);

        rowView.setSubjectName(markSheet.getSubjectName());

        rowView.setSubjectMark(markSheet.getSubjectMark());

        rowView.setSubjectStatus(markSheet.getSubjectStatus());

        if (markSheet.getSubjectStatus().equals(context.getString(R.string.pass))) {
            rowView.setSubjectStatusColor(Color.parseColor("#56DF6F"));
        } else {
            rowView.setSubjectStatusColor(Color.parseColor("#dd4437"));
        }

    }
}
