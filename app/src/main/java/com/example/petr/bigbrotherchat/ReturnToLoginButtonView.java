package com.example.petr.bigbrotherchat;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by petr on 21.11.15.
 */
public class ReturnToLoginButtonView extends RelativeLayout {

    public ReturnToLoginButtonView(Context context) {
        super(context);
        init();
    }

    public ReturnToLoginButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ReturnToLoginButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.reg_me, this);

    }
}
