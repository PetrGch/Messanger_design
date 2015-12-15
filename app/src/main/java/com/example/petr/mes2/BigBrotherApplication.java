package com.example.petr.mes2;

import android.app.Application;
import android.widget.Toast;

import yoba.protocol.adapter.Adapter;
import yoba.protocol.adapter.network.NetworkFailException;

/**
 * Created by petr on 15.12.15.
 */
public class BigBrotherApplication extends Application  {

    public Adapter serverAdapter = null;

    @Override
    public void onCreate() {

        super.onCreate();
        initServerAdapter();

    }

    public Adapter getServerAdapter() {
        if(serverAdapter == null) initServerAdapter();
        return serverAdapter;
    }

    private void initServerAdapter(){
        try {
            serverAdapter = new Adapter(NetworkConstants.host, NetworkConstants.port);
        }
        catch (NetworkFailException e){
            Toast.makeText(this, "Tadadam", Toast.LENGTH_LONG).show();
        }
    }
}
