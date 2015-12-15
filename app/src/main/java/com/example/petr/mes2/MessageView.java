package com.example.petr.mes2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by XlebNick for Messanger_design.
 */
public class MessageView extends LinearLayout{

    private boolean isFromMe = true;

    public MessageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.message_view_layout, this);

    }

    public void setIsFromMe(boolean isFromMe){
        LinearLayout ll = this;
        LayoutParams lp = new LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        if( isFromMe ){
            ll.setHorizontalGravity(Gravity.RIGHT);
            findViewById(R.id.container).setBackgroundResource(R.drawable.message);
            lp.leftMargin = (40);
        } else {
            findViewById(R.id.container).setBackgroundResource(R.drawable.message_by_not_you);
            ll.setHorizontalGravity(Gravity.LEFT);
            lp.rightMargin = (40);
        }

        findViewById(R.id.container).setLayoutParams(lp);
    }

    public boolean getIsFromMe(){
        return isFromMe;
    }

    public void setText(String text){
        ((TextView)findViewById(R.id.message_view_text)).setText(text);
    }

}
