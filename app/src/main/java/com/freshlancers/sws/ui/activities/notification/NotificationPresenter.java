package com.freshlancers.sws.ui.activities.notification;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.models.Notification;
import com.freshlancers.sws.ui.services.DataService;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.List;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 18-12-17.
 */

public class NotificationPresenter extends BasePresenter<NotificationContract.View> implements NotificationContract.Presenter {

    private Context context;

    NotificationPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
    }

    @Override
    public void setupShowsRecyclerView(RecyclerView notificationRecyclerView) {
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(context, resId);
        notificationRecyclerView.setLayoutAnimation(animation);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        notificationRecyclerView.setLayoutManager(mLayoutManager);
        notificationRecyclerView.setItemAnimator(new DefaultItemAnimator());
        notificationRecyclerView.setHasFixedSize(true);

        getView().showRecyclerView();
    }

    @Override
    public void populateRecyclerView(List<Notification> notificationList) {
        notificationList.addAll(DataService.getNotificationList());
        getView().updateAdapter();
    }

}
