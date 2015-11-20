package com.example.petr.mes2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ActionMenuView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Mes2 extends AppCompatActivity implements View.OnClickListener {

    EditText editLogin;
    EditText editPassword;
    EditText editConfPassw;
    EditText editEmail;

    android.support.v7.widget.AppCompatButton btnLogin;
    CustomView addMe;

    com.example.petr.mes2.CustomView btnReturn;

    android.support.v7.widget.CardView loginCard;
    android.support.v7.widget.CardView registrationCard;

    LinearLayout layoutReg;
    RelativeLayout logCard;
    RelativeLayout mainRegPage;


    String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mes2);
        getSupportActionBar().hide();

        loginCard = (android.support.v7.widget.CardView) findViewById(R.id.loginCard);
        mainRegPage = (RelativeLayout) findViewById(R.id.mainRegPage);
        registrationCard = (android.support.v7.widget.CardView) findViewById(R.id.registrationCard);
        btnReturn = (com.example.petr.mes2.CustomView) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);

        btnLogin = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btnLogin);

        logCard = (RelativeLayout) findViewById(R.id.logCard);

        addMe = (CustomView) findViewById(R.id.addMe);
        addMe.setOnClickListener(this);
        //View group

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translat_right);
        btnLogin.startAnimation(animation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addMe:
                registrationMe();
                break;
            case R.id.btnReturn:
                logIn();
                break;
        }
    }

    public void registrationMe () {
        registrationCard.setVisibility(View.VISIBLE);
        logCard.setVisibility(View.GONE);
        /* public void logIn () {
        registrationCard.setVisibility(View.GONE);
        logCard.setVisibility(View.VISIBLE);
    }*/

    }

    public void logIn () {
        registrationCard.setVisibility(View.GONE);
        logCard.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mes2, menu);
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
