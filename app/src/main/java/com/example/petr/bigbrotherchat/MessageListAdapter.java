package com.example.petr.bigbrotherchat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import yoba.protocol.adapter.Message;

/**
 * Created by XlebNick for Messanger_design.
 */
public class MessageListAdapter extends ArrayAdapter<Message> {
    private final List<Message> messages;

    public MessageListAdapter(Context context, int resource, List<Message> objects) {
        super(context, resource, objects);
        this.messages = objects;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MessageView view = new MessageView(parent.getContext());
        view.setText(messages.get(position).getMessage());
//        view.setIsFromMe(messages.get(position).amISender());
        return view;
    }
}
