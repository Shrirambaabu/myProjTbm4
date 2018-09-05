package com.freshlancers.sws.ui.recyclerAdapter.notification;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.freshlancers.sws.R;


/**
 * Created by Ashith VL on 12/1/2017.
 */

public class NotificationRecyclerAdapter extends RecyclerView.Adapter<NotificationHolder> {

    private static final String TAG = "NotificationRecyclerAda";

    NotificationListPresenter notificationListPresenter;

    public NotificationRecyclerAdapter(NotificationListPresenter notificationListPresenter) {
        this.notificationListPresenter = notificationListPresenter;
    }

    @Override
    public NotificationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotificationHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_notification, parent, false), notificationListPresenter);

    }

    @Override
    public void onBindViewHolder(NotificationHolder holder, final int position) {
        notificationListPresenter.bindEventRow(position, holder);
    }

    @Override
    public int getItemCount() {
        return notificationListPresenter.getItemCount();
    }

//    @Override
//    public void updateAdapter(int position) {
//        notifyDataSetChanged();
//        notifyItemRangeChanged(position, getItemCount());
//    }
}
