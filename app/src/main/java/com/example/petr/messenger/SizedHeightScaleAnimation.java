package com.example.petr.messenger;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;

/**
 * Created by petr on 13.11.15.
 */
public class SizedHeightScaleAnimation extends ScaleAnimation {

    private float fromHeight;
    private float toHeight;
    private View myViewToSclae;

    public SizedHeightScaleAnimation(View myViewToSclae,
                                     float fromY,
                                     float toY,
                                     int pivotXType,
                                     float pivotXValue,
                                     int pivotYType,
                                     float pivotYValue) {
        super(1, 1, fromY, toY, pivotXType, pivotXValue, pivotYType, pivotYValue);
        init(myViewToSclae, fromY, toY);
    }

    private void init(View myViewToSclae, float fromY, float toY) {

        this.myViewToSclae = myViewToSclae;
        myViewToSclae.measure(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        fromHeight = myViewToSclae.getMeasuredHeight() * fromY;
        toHeight = myViewToSclae.getMeasuredHeight() * toY;
        Log.d("myLog", toHeight + "");
        Log.d("myLog", fromHeight + "");
    }

    public static Animation createExpension (View viewContent) {

        return new SizedHeightScaleAnimation(viewContent, 0, 1,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
    }

    public static Animation creatCallapse (View viewContent) {

        return new SizedHeightScaleAnimation(viewContent, 1, 0,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);

        final int newHeight = (int) (fromHeight * (1 - interpolatedTime) + toHeight * interpolatedTime);
        Log.d("myInterpolatedTime", interpolatedTime + "");
        Log.d("t", t + "");
        myViewToSclae.getLayoutParams().height = newHeight;
        Log.d("newGeight", newHeight + "");
        myViewToSclae.requestLayout();
    }
}
