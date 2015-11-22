package com.example.petr.mes2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by petr on 21.11.15.
 */
public class CustomView2 extends RelativeLayout {

    public CustomView2(Context context) {
        super(context);
        init();
    }

    public CustomView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.reg_me, this);

    }
}
