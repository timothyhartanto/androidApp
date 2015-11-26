package com.example.proto.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainCalculator extends Activity implements View.OnClickListener{

    Button width, height, calc;
    TextView area;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data.getExtras().containsKey("widthInfo")){
            width.setText(data.getStringExtra("widthInfo"));
        }
        if(data.getExtras().containsKey("heightInfo")){
            height.setText(data.getStringExtra("heightInfo"));
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Numbers.class);
        switch(v.getId()){
            case R.id.buttonWidth:
                i.putExtra("numbers", "width");
                startActivityForResult(i, 1);
            break;
            case R.id.buttonHeight:
                i.putExtra("numbers","height");
                startActivityForResult(i, 1);
                break;
            case R.id.buttonCalc:
                int w = Integer.valueOf(width.getText().toString());
                int h = Integer.valueOf(height.getText().toString());
                area.setText(w*h + " sq ft");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calculator);
        width = (Button)findViewById(R.id.buttonWidth);
        height = (Button)findViewById(R.id.buttonHeight);
        calc = (Button)findViewById(R.id.buttonCalc);
        area = (TextView)findViewById(R.id.textArea);

        width.setOnClickListener(this);
        height.setOnClickListener(this);
        calc.setOnClickListener(this);
    }
}
