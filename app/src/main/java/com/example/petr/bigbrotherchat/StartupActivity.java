package com.example.petr.bigbrotherchat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;

import java.util.ArrayList;

import yoba.protocol.adapter.network.NetworkFailException;

public class StartupActivity extends AppCompatActivity implements View.OnClickListener {

    public enum actionType {LOGIN, REGISTER};

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

    GoToRegistrationButtonView addMe;
    ReturnToLoginButtonView btnReturn;

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

        btnReturn = (com.example.petr.bigbrotherchat.ReturnToLoginButtonView) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(this);

        addMe = (GoToRegistrationButtonView) findViewById(R.id.addMe);
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
                animationForButton(actionType.LOGIN.ordinal());
                switchCard(actionType.LOGIN.ordinal());
                break;
            case R.id.btnReturn:
                animationForButton(actionType.REGISTER.ordinal());
                switchCard(actionType.REGISTER.ordinal());
                break;
            case R.id.btnLogin:
                errorMessage(0);
                saveData();
                intent = new Intent(this, ContactListActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRegistration:
                errorMessage(1);

                Bundle bundle = new Bundle();

                bundle.putString("regName", editRegName.getText().toString());
                bundle.putString("regPass", editRegPassword.getText().toString());
                bundle.putString("regEmail", editRegEmail.getText().toString());

                String token;
                try {
                    new AsyncTask<Bundle, Void, String>() {


                        @Override
                        protected String doInBackground(Bundle... params) {
                            Bundle regparams = params[0];
                            try {
                                return ((BigBrotherApplication)StartupActivity.this.getApplication()).getServerAdapter().registerUser(
                                        regparams.getString("regName"),
                                        regparams.getString("regPass"),
                                        regparams.getString("regEmail")
                                );
                                //((BigBrotherApplication)getApplication()).getServerAdapter();
                            } catch (final NetworkFailException e){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                            return null;
                        }

                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            getSharedPreferences("userdata" ,MODE_APPEND).edit().putString("usertoken", s);
                            Toast.makeText(getApplicationContext(), "Authorized: "+s, Toast.LENGTH_LONG).show();
                        }
                    }.execute(bundle);

                } catch (Exception e){return;}

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

                EditText result = editList.get(x);
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
