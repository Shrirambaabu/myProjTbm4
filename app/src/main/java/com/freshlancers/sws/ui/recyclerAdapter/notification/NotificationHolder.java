package com.freshlancers.sws.ui.recyclerAdapter.notification;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.freshlancers.sws.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashith VL on 12/1/2017.
 */

public class NotificationHolder extends RecyclerView.ViewHolder implements NotificationAdapterContract.NotificationRowView, View.OnClickListener {

    @BindView(R.id.title)
    TextView titleTextView;
    @BindView(R.id.description)
    TextView descriptionTextView;
    @BindView(R.id.heading)
    TextView headingTextView;
    @BindView(R.id.time_ago)
    TextView timeAgoTextView;
    @BindView(R.id.close)
    ImageView closeImageView;

    private NotificationListPresenter notificationListPresenter;

    public NotificationHolder(View itemView, NotificationListPresenter notificationListPresenter) {
        super(itemView);
        this.notificationListPresenter = notificationListPresenter;
        ButterKnife.bind(this, itemView);

        closeImageView.setOnClickListener(this);
    }

    @Override
    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    @Override
    public void setDescription(String description) {
        descriptionTextView.setText(description);
    }

    @Override
    public void setTimeAgo(String timeAgo) {
        timeAgoTextView.setText(timeAgo);
    }

    @Override
    public void setHeading(String heading) {
        headingTextView.setText(heading);
    }

    @Override
    public void onClick(View v) {
        notificationListPresenter.onItemRemove(getAdapterPosition());
    }
}
