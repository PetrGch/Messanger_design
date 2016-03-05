package com.example.petr.bigbrotherchat;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import yoba.protocol.adapter.Adapter;
import yoba.protocol.adapter.network.NetworkFailException;

/**
 * Created by petr on 15.12.15.
 */
public class BigBrotherApplication extends Application  {

    private Adapter serverAdapter;

    @Override
    public void onCreate() {

        super.onCreate();
        boolean success = false;
        try {
            success = new AsyncTask<Void, Void, Boolean>() {
                @Override
                protected Boolean doInBackground(Void... params) {
                    return initServerAdapter();
                }
            }.execute().get();
        } catch (Exception e) {
            success = false;
        }
        if(!success) Toast.makeText(this, "Network fail(", Toast.LENGTH_LONG).show();

    }

    public Adapter getServerAdapter() {
        if(serverAdapter == null) {
            if(!initServerAdapter()) throw new NetworkFailException(-1, "Can’t initialize - no connection to remote server");
        }
        return serverAdapter;
    }

    private boolean initServerAdapter() {
        try {
            serverAdapter = new Adapter(NetworkConstants.host, NetworkConstants.port);
        }
        catch (NetworkFailException e){
            return false;
        }
        return true;
    }
}
