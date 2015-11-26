package com.example.proto.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Numbers extends Activity implements View.OnClickListener{

    EditText number;
    Button sendInfo;

    @Override
    public void onClick(View v) {
        String num = number.getText().toString();
        Intent i = getIntent();
        String msg = i.getStringExtra("numbers");
        if(msg.contentEquals("width")){
            i.putExtra("widthInfo", num);
            setResult(RESULT_OK, i);
            finish();
        }
        if(msg.contentEquals("height")){
            i.putExtra("heightInfo", num);
            setResult(RESULT_OK, i);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number);
        number = (EditText)findViewById(R.id.editText1);
        sendInfo = (Button)findViewById(R.id.button1);
        sendInfo.setOnClickListener(this);
    }
}
