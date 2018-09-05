package com.freshlancers.sws.ui.activities.home;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;

import com.antonyt.infiniteviewpager.InfinitePagerAdapter;
import com.freshlancers.sws.R;
import com.freshlancers.sws.base.BasePresenter;
import com.freshlancers.sws.ui.adapters.ImageSliderAdapter;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.Arrays;

import me.crosswall.lib.coverflow.CoverFlow;
import me.relex.circleindicator.CircleIndicator;

import static com.freshlancers.sws.utils.BottomNavigationHelper.setupBottomNavigationSetUp;

/**
 * Created by Leon on 17-12-17.
 */

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    private Context mContext;

    HomePresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void carouselViewSetUp(ViewPager mPager, CircleIndicator indicator) {

        final Integer[] images = {R.drawable.dummyslide1, R.drawable.dummyslide2, R.drawable.dummyslide3};
        final ArrayList<Integer> imagesArray = new ArrayList<Integer>();
        imagesArray.addAll(Arrays.asList(images));

        //mPager = (ViewPager) findViewById(R.id.pager);

        // mPager.setOnTouchListener(new DisableTouchListener());
        mPager.setClipToPadding(false);
        mPager.setPageMargin(24);
        mPager.setPadding(48, 24, 48, 16);
        mPager.setOffscreenPageLimit(imagesArray.size());

        //CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        PagerAdapter pagerAdapter = new ImageSliderAdapter(mContext, imagesArray);
        InfinitePagerAdapter wrappedAdapter = new InfinitePagerAdapter(pagerAdapter);

        new CoverFlow.Builder()
                .with(mPager)
                .pagerMargin(-100f)
                .scale(0.3f)
                .spaceSize(0f)
                .rotationY(0f)
                .build();

        getView().viewCarousel(wrappedAdapter, mPager);

    }

    @Override
    public void bottomNavigationViewSetup(BottomNavigationViewEx bottomNavigationViewEx) {
        setupBottomNavigationSetUp(bottomNavigationViewEx);
        getView().viewBottomNavigation(bottomNavigationViewEx);
    }

    @Override
    public void onBackPress() {
        AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
        alertDialog.setTitle("Confirm !!!");
        alertDialog.setMessage("Are you sure you want to close this application ?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                (dialog, which) -> {
                    dialog.dismiss();
                    Intent startMain = new Intent(Intent.ACTION_MAIN);
                    startMain.addCategory(Intent.CATEGORY_HOME);
                    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(startMain);
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
                (dialog, which) -> {
                    dialog.dismiss();
                });
        alertDialog.show();
    }
}