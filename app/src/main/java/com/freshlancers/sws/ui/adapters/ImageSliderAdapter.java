package com.freshlancers.sws.ui.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.freshlancers.sws.GlideApp;
import com.freshlancers.sws.R;
import com.jackandphantom.circularimageview.RoundedImage;

import java.util.ArrayList;
/**
 * Created by Ashith VL on 11/28/2017.
 */

public class ImageSliderAdapter extends PagerAdapter {

    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public  ImageSliderAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images=images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.fragment_slider, view, false);
        RoundedImage myImage = (RoundedImage) myImageLayout.findViewById(R.id.image_view);
        myImage.setRoundedRadius(10);
//        myImage.setImageResource(images.get(position));

        GlideApp.with(context)
                .load(images.get(position))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(myImage);


        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

}