package com.example.petr.mes2;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by petr on 19.11.15.
 */
public class GoToRegistrationButtonView extends RelativeLayout {
    public GoToRegistrationButtonView(Context context) {
        super(context);
        init();
    }

    public GoToRegistrationButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GoToRegistrationButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.add_me, this);

    }
}
