package com.example.proto.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Numbers extends Activity implements View.OnClickListener{

    EditText number;
    Button sendInfo;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);
        number = (EditText)findViewById(R.id.editText1);
        sendInfo = (Button)findViewById(R.id.button1);
    }
}
