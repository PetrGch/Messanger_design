package com.example.petr.mes2;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.ArrayList;
import java.util.Vector;

public class Mes2 extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout mainRegPage;

    EditText editLogin;
    EditText editPassword;
    EditText editRegName;
    EditText editRegPassword;
    EditText editRegConfPass;
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
    ArrayList<EditText> editList = new ArrayList<>();

    SharedPreferences sPref;

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
        editRegConfPass = (EditText) findViewById(R.id.editRegConfPass);
        editRegEmail = (EditText) findViewById(R.id.editRegEmail);

        savePassword = (CheckBox) findViewById(R.id.savePassword);
        savePassword2 = (CheckBox) findViewById(R.id.savePassword2);

        loginCard = (android.support.v7.widget.CardView) findViewById(R.id.loginCard);
        registrationCard = (android.support.v7.widget.CardView) findViewById(R.id.registrationCard);

        btnLogin = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        btnRegistration = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(this);

        btnForgotPass = (android.support.v7.widget.AppCompatButton) findViewById(R.id.btnForgetPass);
        btnForgotPass.setOnClickListener(this);

        btnReturn = (com.example.petr.mes2.CustomView2) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);

        addMe = (CustomView) findViewById(R.id.addMe);
        addMe.setOnClickListener(this);

    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();

        logData();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.addMe:
                animationForButton(0);
                switchCard(0);
                break;
            case R.id.btnReturn:
                animationForButton(1);
                switchCard(1);
                break;
            case R.id.btnLogin:
                errorMessage(0);
                saveData();
                intent = new Intent(this, ContactList.class);
                startActivity(intent);
                break;
            case R.id.btnRegistration:
                errorMessage(1);
                if (savePassword.isChecked()) {
                }
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
        }
    }

    public void switchCard (int value) {

        if (value == 0) {
            registrationCard.setVisibility(View.VISIBLE);
            loginCard.setVisibility(View.GONE);

            editList.clear();
            editList.add(editLogin);
            editList.add(editPassword);

            for (EditText view:editList) {
                view.setText("");
                view.setError(null);
            }

            mainRegPage.removeView(btnForgotPass);

        } else if (value == 1) {
            registrationCard.setVisibility(View.GONE);
            loginCard.setVisibility(View.VISIBLE);

            editList.clear();
            editList.add(editRegName);
            editList.add(editRegPassword);
            editList.add(editRegConfPass);
            editList.add(editRegEmail);

            for (EditText view:editList) {
                view.setText("");
                view.setError(null);
            }

            mainRegPage.addView(btnForgotPass);
        }
    }

    public void errorMessage (int value) {

        if (value == 0) {
            editList.clear();
            editList.add(editLogin);
            editList.add(editPassword);

            for (int x = 0; x < editList.size(); x++) {

                EditText result = (EditText) editList.get(x);
                if (result.getText().toString().length() == 0) {
                    result.setError("The field is not filled");
                }
            }

        } else if (value == 1) {
            editList.clear();
            editList.add(editRegName);
            editList.add(editRegPassword);
            editList.add(editRegConfPass);
            editList.add(editRegEmail);

            for (int x = 0; x < editList.size(); x++) {

                EditText result = (EditText) editList.get(x);
                if (result.getText().toString().length() == 0) {
                    result.setError("The field is not filled");
                }
            }
        }
    }

    public void saveData () {

        sPref = getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("logIn", editLogin.getText().toString());
        ed.putString("password", editPassword.getText().toString());
        ed.commit();
    }

    public void logData () {
        sPref = getSharedPreferences("myPref", MODE_PRIVATE);
        String logIn = sPref.getString("logIn", "");
        String password = sPref.getString("password", "");
        editLogin.setText(logIn);
        editPassword.setText(password);
    }


}
