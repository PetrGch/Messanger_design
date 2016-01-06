package com.example.petr.mes2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import yoba.protocol.adapter.Message;

public class MessageActivity extends AppCompatActivity implements UpdatableMessagingActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ListView listView = (ListView) findViewById(R.id.message_list);
        listView.setDividerHeight(0);
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message(Long.MAX_VALUE, "", "", "dlrungbldifunhblidfnh bg", "2015-11-11 11:11:11"));
        listView.setAdapter(new MessageListAdapter(this, R.layout.message_view_layout, messages));
    }
}
