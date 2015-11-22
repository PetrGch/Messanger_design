package com.example.petr.mes2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ActionMenuView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Mes2 extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout mainRegPage;

    EditText editLogin;
    EditText editPassword;
    EditText editRegName;
    EditText editRegPassword;
    EditText editRegCongPass;
    EditText editRegEmail;

    CheckBox savePassword;
    CheckBox savePassword2;

    android.support.v7.widget.AppCompatButton btnLogin;
    android.support.v7.widget.AppCompatButton btnRegistration;
    android.support.v7.widget.AppCompatButton btnForgotPass;

    CustomView addMe;
    CustomView2 btnReturn;

    android.support.v7.widget.CardView loginCard;
    android.support.v7.widget.CardView registrationCard;

    String TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_mes2);
        getSupportActionBar().hide();

        /*View group*/

        mainRegPage = (RelativeLayout) findViewById(R.id.mainRegPage);

        editLogin = (EditText) findViewById(R.id.editLogin);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editRegName = (EditText) findViewById(R.id.editRegName);
        editRegPassword = (EditText) findViewById(R.id.editRegPassword);
        editRegCongPass = (EditText) findViewById(R.id.editRegConfPass);
        editRegEmail = (EditText) findViewById(R.id.editRegEmail);

        savePassword = (CheckBox) findViewById(R.id.savePassword);
        savePassword2 = (CheckBox) findViewById(R.id.savePassword2);

        btnLogin = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btnLogin);
        btnRegistration = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btnRegistration);
        btnForgotPass = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btnForgetPass);

        loginCard = (android.support.v7.widget.CardView) findViewById(R.id.loginCard);
        registrationCard = (android.support.v7.widget.CardView) findViewById(R.id.registrationCard);

        btnReturn = (com.example.petr.mes2.CustomView2) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);

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


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addMe:
                animationForButton(0);
                switchCard(0);
                break;
            case R.id.btnReturn:
                animationForButton(1);
                switchCard(1);
                break;
        }
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

    public void animationForButton (int value) {
        Animation animation;

        if (value == 0) {
            animation = AnimationUtils.loadAnimation(this, R.anim.translat_right);
            btnLogin.startAnimation(animation);
        } else if (value == 1) {
            animation = AnimationUtils.loadAnimation(this, R.anim.translat_right);
            btnRegistration.startAnimation(animation);

            mainRegPage.removeView(btnForgotPass);
        }
    }

    public void switchCard (int value) {

        if (value == 0) {
            registrationCard.setVisibility(View.VISIBLE);
            loginCard.setVisibility(View.GONE);

        } else if (value == 1) {
            registrationCard.setVisibility(View.GONE);
            loginCard.setVisibility(View.VISIBLE);
        }
    }

    public void errorMessage () {

    }
}
