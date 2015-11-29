package com.example.proto.application;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Reading extends Activity implements View.OnClickListener{

    Spinner spinner;
    TextView title, entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reading);
        spinner = (Spinner)findViewById(R.id.spinner1);
        title = (TextView)findViewById(R.id.textView1);
        entry = (TextView)findViewById(R.id.textView2);
        getFileNames();
    }

    @Override
    public void onClick(View v) {

    }

    private void getFileNames(){
        String[] fileNames = getApplicationContext().fileList();
        List<String> list = new ArrayList<String>();

        for(int i = 0; i < fileNames.length; i++){
            //Log.d("Filename", fileNames[i]);
            list.add(fileNames[i]);
        }

        ArrayAdapter<String> fileNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, list);
        spinner.setAdapter(fileNameAdapter);
    }
}
