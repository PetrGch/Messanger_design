package com.example.petr.bigbrotherchat;

import yoba.protocol.adapter.Message;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by voldemarich on 6.1.2016.
 */
public class MessagingStorageAdapter {


    public MessagingStorageAdapter(){

    }

    public void putMessages(ArrayList<Message> messagelist){

    }

    /**
     *
     * @param id Message id, if set returns one msg in list
     * @param sender Search by sender, can be filtered later
     * @param receiver Search by receiver ==
     * @param datetime Search by date and time, returns messages after the given date
     * @return ArrayList of Message which contains received results
     */
    public ArrayList<Message> getMessagesByFiltering(Long id, String sender, String receiver, Date datetime){
        return null;
    }
}
