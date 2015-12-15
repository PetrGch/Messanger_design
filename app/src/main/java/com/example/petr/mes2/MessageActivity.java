package com.example.petr.mes2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ((MessageView) findViewById(R.id.message)).setText("SHIT");
        ((MessageView) findViewById(R.id.message2)).setText("dgiubhdrku tvbdkr ygvskuryhfbv osuhyv gf djhf.kguhdfkghdg kis");
        ((MessageView) findViewById(R.id.message3)).setText("ryugvbkbg  fkh bfdig fdkh kudf fg hbdfkmhv d hgdksufh kusrhg kdu hgkudr hgkur hgku hgf ");
        ((MessageView) findViewById(R.id.message4)).setText("rgvk hjjk f hbjfd, f jdkgdjkfhg ldfh ljdf h");
        ((MessageView) findViewById(R.id.message5)).setText("rdfhg dfbg dg nbdjkhg duhf gkduf hgld hgd g,hgd j,dfb ");

        ((MessageView) findViewById(R.id.message)).setIsFromMe(true);
        ((MessageView) findViewById(R.id.message2)).setIsFromMe(false);
        ((MessageView) findViewById(R.id.message3)).setIsFromMe(true);
        ((MessageView) findViewById(R.id.message4)).setIsFromMe(false);
        ((MessageView) findViewById(R.id.message5)).setIsFromMe(true);
    }
}
