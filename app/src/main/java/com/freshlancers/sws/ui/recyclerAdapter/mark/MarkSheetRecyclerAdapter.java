package com.freshlancers.sws.ui.recyclerAdapter.mark;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freshlancers.sws.R;

/**
 * Created by Leon on 23-12-17.
 */

public class MarkSheetRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "MarkSheetRecyclerAdapte";
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_BODY = 1;
    private MarkSheetListPresenter markSheetListPresenter;

    public MarkSheetRecyclerAdapter(MarkSheetListPresenter markSheetListPresenter) {
        this.markSheetListPresenter = markSheetListPresenter;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_marksheet_header, parent, false);
            return new MarkSheetHeaderHolder(layoutView);
        } else if (viewType == TYPE_BODY) {
            View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_marksheet, parent, false);
            return new MarkSheetHolder(layoutView, markSheetListPresenter);
        }
        throw new RuntimeException("No match for " + viewType + ".");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MarkSheetAdapterContract.MarkSheetRowView) {
            markSheetListPresenter.bindEventRow(position, (MarkSheetAdapterContract.MarkSheetRowView) holder);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_BODY;
    }

    @Override
    public int getItemCount() {
        return markSheetListPresenter.getItemCount();
    }

}
