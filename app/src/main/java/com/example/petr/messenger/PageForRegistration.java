package com.example.petr.messenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.petr.messenger.R;

public class PageForRegistration extends Activity implements View.OnClickListener {

    EditText editLogin;
    EditText editPassword;
    EditText editConfPassw;
    EditText editEmail;

    Button btnLogin;
    Button btnReg;

    LinearLayout layoutReg;

    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.page_for_registration);

        //View group
        layoutReg = (LinearLayout) findViewById(R.id.layoutReg);

        editLogin = (EditText) findViewById(R.id.editLogin);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editConfPassw = (EditText) findViewById(R.id.editConfPassw);
        editEmail = (EditText) findViewById(R.id.editEmail);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnReg = (Button) findViewById(R.id.btnReg);

        //Buttons group
        btnReg.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "PageForRegistration: onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "PageForRegistration: onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "PageForRegistration: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "PageForRegistration: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "PageForRegistration: onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "PageForRegistration: onDestroy()");
    }

    @Override
    public void onClick (View v) {

        switch (v.getId()) {
            case R.id.btnReg:
                if (layoutReg.getHeight() == 0) {
                    Animation expension = createExpension();
                    expension.setDuration(500);
                    layoutReg.startAnimation(expension);
                    Log.d("myLog", layoutReg.getHeight() + "");
                } else {
                    Animation callapse = creatCallapse();
                    callapse.setDuration(500);
                    layoutReg.startAnimation(callapse);
                    Log.d("myLog", layoutReg.getHeight() + "");
                }
                break;
            case R.id.btnLogin:
                //Call ContactList activity
                Intent intent = new Intent(this, ContactList.class);
                startActivity(intent);
                break;
        }

    }

    public Animation createExpension () {

        return new SizedHeightScaleAnimation(layoutReg, 0, 1,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
    }

    public Animation creatCallapse () {

        return new SizedHeightScaleAnimation(layoutReg, 1, 0,
                Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0f);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_page_for_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
