package com.example.proto.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainCalculator extends Activity implements View.OnClickListener{

    Button width, height, calc;
    TextView area;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);
        width = (Button)findViewById(R.id.button1);
        height = (Button)findViewById(R.id.button2);
        calc = (Button)findViewById(R.id.button3);
        area = (TextView)findViewById(R.id.textView1);

        width.setOnClickListener(this);
        height.setOnClickListener(this);
        calc.setOnClickListener(this);
    }
}
