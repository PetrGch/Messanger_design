package com.example.petr.bigbrotherchat;


import android.os.AsyncTask;
import yoba.protocol.adapter.Message;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by voldemarich on 6.1.2016.
 */
public class MessageReceiveScheduler {

    private static int frequpdate = 100;
    String usertoken;
    UpdatableMessagingActivity contactList;
    UpdatableMessagingActivity currentChat = null; //null explicitly by default.
    private final ScheduledExecutorService looper = Executors.newScheduledThreadPool(1);
    private ScheduledFuture updateLoop;


    public MessageReceiveScheduler(String usertoken, UpdatableMessagingActivity contactList){
        this.usertoken = usertoken;
        this.contactList = contactList;
    }

    public void runUpdates(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                updateCycle();
            }
        };
        updateLoop = looper.scheduleAtFixedRate(r, frequpdate, frequpdate, TimeUnit.MILLISECONDS);
    }

    public void stopUpdates(){
        updateLoop.cancel(true);
    }

    private void updateCycle(){
        new AsyncTask<Void, Void, ArrayList<Message>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(ArrayList<Message> messages) {
                super.onPostExecute(messages);
            }

            @Override
            protected ArrayList<Message> doInBackground(Void... params) {
                return null;
            }
        }.execute();
    }

    public void setCurrentChat(UpdatableMessagingActivity currentChat) {
        this.currentChat = currentChat;
    }
}
